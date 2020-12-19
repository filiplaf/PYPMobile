package pyp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import resources.Base;

public class LoginValidationChecks extends Base {
	public static Logger log = LogManager.getLogger(LoginValidationChecks.class.getName());
	private String wrongEmailFormat = "aaa";
	private String email="filip@yopmail.com";
	private String password = "123456";
	private String wrongPasswordLengt="123";
	
	@Test(priority=1)
	public void navigateToRegistrationPage() throws IOException {
		driver = initializeDriver();
		driver.get("https://pyp.stage.ggstud.io/");
	}
	
	@Test(priority=2)
	public void validationAllFieldsBlank() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.loginButton().click();
		if("Email address can't be blank".equals(lp.emailValidation().getText())){
			log.info("Email validation correct: "+lp.emailValidation().getText());
		}
		else
			log.error("Email validation is not correct! "+lp.emailValidation().getText());
		
		if("Password can’t be blank".equals(lp.passwordValidation().getText())){
			log.info("Password validation correct: "+lp.passwordValidation().getText());
		}
		else
			log.error("Password validation is not correct! "+lp.passwordValidation().getText());
	}
	
	@Test(priority=3)
	public void validationEmailWrongFormat() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.email().clear();
		lp.email().sendKeys(wrongEmailFormat);
		lp.password().clear();
		lp.password().sendKeys(password);
		lp.loginButton().click();
		if("Email must be a valid email address.".equals(lp.emailValidation().getText())){
			log.info("Email validation correct: "+lp.emailValidation().getText());
		}
		else
			log.error("Email validation is not correct! "+lp.emailValidation().getText());
	}
	@Test(priority=4)
	public void validationPasswordLenght() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.email().clear();
		lp.email().sendKeys(email);
		lp.password().clear();
		lp.password().sendKeys(wrongPasswordLengt);
		lp.loginButton().click();
		if("Password must have at least 6 characters".equals(lp.passwordValidation().getText())){
			log.info("Password validation correct: "+lp.passwordValidation().getText());
		}
		else
			log.error("Password validation is not correct! "+lp.passwordValidation().getText());
	}
	
	@Test(priority=5)
	public void validationWrongCredetials() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.email().clear();
		lp.email().sendKeys(email);
		lp.password().clear();
		lp.password().sendKeys(password);
		lp.loginButton().click();
		if(lp.unathorizedMessage().isDisplayed()) {
			log.info(lp.unathorizedMessage().getText());	
		}
		log.info("*********************************************************************************************");
	}
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}
	
}