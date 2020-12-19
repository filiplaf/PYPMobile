package pyp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import resources.Base;

public class RegistrationValidationChecks extends Base {
	public static Logger log = LogManager.getLogger(RegistrationValidationChecks.class.getName());
	private String name = "Test";
	private String wrongEmailFormat = "aaa";
	private String email="filip@yahoo.com";
	private String emailExist = "filip@yopmail.com";
	private String password = "123456";
	private String wrongPasswordLengt="123";
	private String confirmPassword = "123456";
	
	@Test(priority=1)
	public void navigateToRegistrationPage() throws IOException {
		driver = initializeDriver();
		driver.get("https://pyp.stage.ggstud.io/");
		LoginPage lp = new LoginPage(driver);
		RegistrationPage rp = new RegistrationPage(driver);
		lp.signUp().click();
		if("Sign up to Pyp".equals(rp.titleSignUp().getText())){
			log.info("SignUp Page successfully opened");
		}
		else
			log.error("SignUp Page is not opened");
	}
	
	@Test(priority=2)
	public void validationAllFieldsBlank() throws IOException {
		RegistrationPage rp = new RegistrationPage(driver);
		rp.createAccount().click();
		if("Name can't be blank".equals(rp.nameValidation().getText())){
			log.info("Name validation correct: "+rp.nameValidation().getText());
		}
		else
			log.error("Name validation is not correct! "+rp.nameValidation().getText());
		
		if("Email address can’t be blank".equals(rp.emailValidation().getText())){
			log.info("Email validation correct: "+rp.emailValidation().getText());
		}
		else
			log.error("Email validation is not correct! "+rp.emailValidation().getText());
		
		if("Password can’t be blank".equals(rp.passwordValidation().getText())){
			log.info("Password validation correct: "+rp.passwordValidation().getText());
		}
		else
			log.error("Password validation is not correct! "+rp.passwordValidation().getText());
		
		if("Password can’t be blank".equals(rp.confirmPasswordValidation().getText())){
			log.info("Confirm password validation correct: "+rp.confirmPasswordValidation().getText());
		}
		else
			log.error("Confirm password validation is not correct! "+rp.confirmPasswordValidation().getText());
	}
	
	@Test(priority=3)
	public void validationEmailWrongFormat() throws IOException {
		RegistrationPage rp = new RegistrationPage(driver);
		rp.name().clear();
		rp.name().sendKeys(name);
		rp.email().clear();
		rp.email().sendKeys(wrongEmailFormat);
		rp.password().clear();
		rp.password().sendKeys(password);
		rp.confirmPassword().clear();
		rp.confirmPassword().sendKeys(confirmPassword);
		rp.createAccount().click();
		if("Email must be a valid email address.".equals(rp.emailValidation().getText())){
			log.info("Email validation correct: "+rp.emailValidation().getText());
		}
		else
			log.error("Email validation is not correct! "+rp.emailValidation().getText());
	}
	
	@Test(priority=4)
	public void validationPasswordLenght() throws IOException {
		RegistrationPage rp = new RegistrationPage(driver);
		rp.name().clear();
		rp.name().sendKeys(name);
		rp.email().clear();
		rp.email().sendKeys(email);
		rp.password().clear();
		rp.password().sendKeys(wrongPasswordLengt);
		rp.confirmPassword().clear();
		rp.confirmPassword().sendKeys(wrongPasswordLengt);
		rp.createAccount().click();
		if("Password must have at least 6 characters".equals(rp.passwordValidation().getText())){
			log.info("Password validation is correct "+rp.passwordValidation().getText());
		}
		else
			log.error("Password validation is not correct! "+rp.passwordValidation().getText());
	}
	@Test(priority=5)
	public void validationPasswordDoesntMatch() throws IOException {
		RegistrationPage rp = new RegistrationPage(driver);
		rp.name().clear();
		rp.name().sendKeys(name);
		rp.email().clear();
		rp.email().sendKeys(email);
		rp.password().clear();
		rp.password().sendKeys(password);
		rp.confirmPassword().clear();
		rp.confirmPassword().sendKeys(wrongPasswordLengt);
		rp.createAccount().click();
		if("Password and confirmation password do not match".equals(rp.confirmPasswordValidation().getText())){
			log.info("ConfirmPassword validation is correct: "+rp.confirmPasswordValidation().getText());
		}
		else
			log.error("Password validation is not correct! "+rp.confirmPasswordValidation().getText());
	}
	@Test(priority=6)
	public void validationWhereUserExist() throws IOException {
		RegistrationPage rp = new RegistrationPage(driver);
		rp.name().clear();
		rp.name().sendKeys(name);
		rp.email().clear();
		rp.email().sendKeys(emailExist);
		rp.password().clear();
		rp.password().sendKeys(password);
		rp.confirmPassword().clear();
		rp.confirmPassword().sendKeys(confirmPassword);
		rp.createAccount().click();
		if("The email has already been taken.".equals(rp.emailExistValidation().getText())){
			log.info("Email validation is correct: "+rp.emailExistValidation().getText());
		}
		else
			{log.error("Email validation is not correct! "+rp.emailExistValidation().getText());}
		log.info("*********************************************************************************************");
	}
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}
	
}
