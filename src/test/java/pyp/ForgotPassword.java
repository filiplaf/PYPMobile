package pyp;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.ForgotPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Base;


public class ForgotPassword extends Base{
	public static Logger log = LogManager.getLogger(ForgotPassword.class.getName());
	private String wrongPasswordFormat= "aaa";
	private String wrongConfirmPassword = "f123456";
	private String newPassword = "f12345";
	
	@Test(priority=1)
	public void forgotPasswordNavigation() throws IOException {
	driver = initializeDriver();
	driver.get("https://pyp.stage.ggstud.io/");
	LoginPage lp = new LoginPage(driver);
	Login login = new Login();
	ForgotPasswordPage fp = new ForgotPasswordPage(driver);
	lp.forgotPassword().click();
	if("Forgot Password".equals(fp.forgotPasswordText().getText())) {
		log.info("Forgot password page is opened");
	}
	else {
		log.error("Error opening Forgot Password page");
	}
	fp.email().sendKeys(login.email);
	fp.sendResetInstructionButton().click();
	try{
		if("Instructions Sent".equals(fp.instructionSent().getText())) {
			log.info(fp.resetMessage().getText());
	}
	}
	catch (Exception e) {
		log.error("Error with reset password");
	}
	driver.close();
	driver.quit();
}
	@Test(priority=2)
	public void resetPasswordMail() throws IOException {
		wait_time(7);
		driver = initializeDriver();
		driver.get("https://www.mailinator.com/");
		Login login = new Login();
		//Yomail
		WebElement MailName = driver.findElement(By.id("addOverlay"));
		MailName.sendKeys(login.email);
		MailName.sendKeys(Keys.ENTER);
		List<WebElement> Mail = driver.findElements(By.xpath("//*[contains(text(), 'Reset')]"));
		Mail.get(0).click();
		//Switch na frame i klik na link
		WebElement iframeMsg = driver.findElement(By.id("msg_body"));
		driver.switchTo().frame(iframeMsg); 
		wait_time(2);
		WebElement Clicklink = driver.findElement(By.cssSelector(".button.button-primary"));
		jsClick(Clicklink, driver);
		//Switcujemo se na novi tab
				String mainWindow = driver.getWindowHandle();
				Set<String> handles = driver.getWindowHandles();  
				for (String handle : handles) {
				    if (!handle.equals(mainWindow)) {
				          driver.switchTo().window(handle);
				          break;
				    }
				}
	}
//	//VALIDATIONS
	@Test(priority=3)
	public void validationFieldsAreBlank() throws IOException {
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		fp.resetPasswordButton().click();		
		if("Password can’t be blank".equals(fp.newPasswordValidation().getText())){
			log.info("New Password validation correct: "+fp.newPasswordValidation().getText());
		}
		else
			log.error("New Password validation is not correct! "+fp.emailValidation().getText());	
		if("Password can’t be blank".equals(fp.confirmPasswordValidation().getText())){
			log.info("Confirm new password validation correct: "+fp.confirmPasswordValidation().getText());
		}
		else
			log.error("Confirm new password validation is not correct! "+fp.confirmPasswordValidation().getText());
	}
	
	@Test(priority=4)
	public void validationEmailWrongFormat() throws IOException {
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		fp.newPassword().clear();
		fp.newPassword().sendKeys(wrongPasswordFormat);
		fp.resetPasswordButton().click();
		if("Password must have at least 6 characters".equals(fp.newPasswordValidation().getText())){
			log.info("New password validation correct: "+fp.newPasswordValidation().getText());
		}
		else
			log.error("New password validation is not correct! "+fp.newPasswordValidation().getText());
	}
	
	@Test(priority=5)
	public void validationPasswordsDontMatch() throws IOException {
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		fp.newPassword().clear();
		fp.newPassword().sendKeys(newPassword);
		fp.confirmNewPassword().clear();
		fp.confirmNewPassword().sendKeys(wrongConfirmPassword);
		fp.resetPasswordButton().click();
		if("Password and confirmation password do not match".equals(fp.confirmPasswordValidation().getText())){
			log.info("Confirm password validation correct: "+fp.confirmPasswordValidation().getText());
		}
		else
			log.error("Confirm password validation is not correct! "+fp.confirmPasswordValidation().getText());
	}
	
	@Test(priority=6)
	public void resetPasswordSuccess() throws IOException {
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		Login login = new Login();
		fp.newPassword().clear();
		fp.newPassword().sendKeys(newPassword);
		fp.confirmNewPassword().clear();
		fp.confirmNewPassword().sendKeys(newPassword);
		fp.resetPasswordButton().click();
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		lp.email().sendKeys(login.email);
		lp.password().sendKeys(login.password);
		lp.loginButton().click();
			try {
				hp.avatar().isDisplayed(); 
				log.info("Korisnik sa emailom "+login.email+ " je uspesno ulogovan!" );
			} catch (Exception e) {
				log.error("Korisnik nije ulogovan");
			}
	log.info("*********************************************************************************************");		
		}	
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}
}