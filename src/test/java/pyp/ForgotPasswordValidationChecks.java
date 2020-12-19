package pyp;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pageObjects.ForgotPasswordPage;
import pageObjects.LoginPage;
import resources.Base;


public class ForgotPasswordValidationChecks extends Base{
	public static Logger log = LogManager.getLogger(ForgotPasswordValidationChecks.class.getName());
	private String wrongEmailFormat= "aaa";
	private String emailDontExist = "aaa@aaa";
	
	@Test(priority=1)
	public void forgotPasswordNavigation() throws IOException {
	driver = initializeDriver();
	driver.get("https://pyp.stage.ggstud.io/");
	LoginPage lp = new LoginPage(driver);
	ForgotPasswordPage fp = new ForgotPasswordPage(driver);
	lp.forgotPassword().click();
	if("Forgot Password".equals(fp.forgotPasswordText().getText())) {
		log.info("Forgot password page is opened");
	}
	else {
		log.error("Error opening Forgot Password page");
	}
  }
	@Test(priority=2)
	public void validationEmailFieldBlank() throws IOException {
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		fp.sendResetInstructionButton().click();		
		if("Email address can't be blank".equals(fp.emailValidation().getText())){
			log.info("Email validation correct: "+fp.emailValidation().getText());
		}
		else
			log.error("Email validation is not correct! "+fp.emailValidation().getText());	
	}
	
	@Test(priority=3)
	public void validationEmailWrongFormat() throws IOException {
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		fp.email().clear();
		fp.email().sendKeys(wrongEmailFormat);
		fp.sendResetInstructionButton().click();
		if("Email must be a valid email address.".equals(fp.emailValidation().getText())){
			log.info("Email validation correct: "+fp.emailValidation().getText());
		}
		else
			log.error("Email validation is not correct! "+fp.emailValidation().getText());
	}
	
	@Test(priority=4)
	public void validationEmailDontExist() throws IOException {
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		fp.email().clear();
		fp.email().sendKeys(emailDontExist);
		fp.sendResetInstructionButton().click();
		log.info(fp.invalidDataMessage().getText());
		log.info("*********************************************************************************************");	
	}
	
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}
}