package pyp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.MyProfilePage;
import resources.Base;

public class MyProfilePasswordValidationChecks extends Base{
	public static Logger log = LogManager.getLogger(MyProfilePasswordValidationChecks.class.getName());
	private String oldPasswordWrong = "asd";
	private String newPassword = "123456";
	private String newPasswordWrongLength = "123";
	private String confirmPassword = "123456";
	private String confirmPasswordDoesntMatch = "1234567";
	
	@Test(priority=1)
	public void myProfilePassword() throws IOException {
		HomePage hp = new HomePage(driver);
		MyProfilePage mp = new MyProfilePage(driver);
		Actions action = new Actions(driver);
		action.moveToElement(hp.avatar()).build().perform();
		hp.myProfile().click();
		if("My Profile".equals(mp.titleMyProfile().getText())){
			log.info("My Profile Page successfully opened");
		}
		else {
			log.error("My Profile Page is not opened");}
		mp.passwordTab().click();
	}
	
	@Test(priority=2)
	public void validationAllFieldsBlank() throws IOException {
		MyProfilePage mp = new MyProfilePage(driver);
		jsClick(mp.changesPasswordButton(), driver);
		if("Password can’t be blank".equals(mp.oldPasswordValidation().getText())){
			log.info("Password validation correct: "+mp.oldPasswordValidation().getText());
		}
		else
			log.error("Password validation is not correct! "+mp.oldPasswordValidation().getText());
		scrollIntoView(mp.newPasswordValidation());
		if("New password can’t be blank".equals(mp.newPasswordValidation().getText())){
			log.info("New password validation correct: "+mp.newPasswordValidation().getText());
		}
		else
			log.error("New password validation is not correct! "+mp.newPasswordValidation().getText());
		scrollIntoView(mp.confirmNewPasswordValidation());
		if("Password can’t be blank".equals(mp.confirmNewPasswordValidation().getText())){
			log.info("Confirm password validation correct: "+mp.confirmNewPasswordValidation().getText());
		}
		else
			log.error("Confirm password validation is not correct! "+mp.confirmNewPasswordValidation().getText());
	}
	
	@Test(priority=3)
	public void oldPasswordWrongValidation() throws IOException {
		MyProfilePage mp = new MyProfilePage(driver);
		mp.oldPassword().clear();
		mp.oldPassword().sendKeys(oldPasswordWrong);
		mp.newPassword().clear();
		mp.newPassword().sendKeys(newPassword);
		mp.confirmNewPassword().clear();
		mp.confirmNewPassword().sendKeys(confirmPassword);
		mp.changesPasswordButton().click();
		if("The password is wrong.".equals(mp.oldPasswordValidation().getText())){
			log.info("Old Password validation correct: "+mp.oldPasswordValidation().getText());
		}
		else
			log.error("Old Password validation is not correct! "+mp.oldPasswordValidation().getText());
	}
	
	@Test(priority=4)
	public void newPasswordWrongLenght() throws IOException {
		MyProfilePage mp = new MyProfilePage(driver);
		Login login = new Login();
		mp.oldPassword().clear();
		mp.oldPassword().sendKeys(login.password);
		mp.newPassword().clear();
		mp.newPassword().sendKeys(newPasswordWrongLength);
		mp.confirmNewPassword().clear();
		mp.confirmNewPassword().sendKeys(newPasswordWrongLength);
		mp.changesPasswordButton().click();
		if("New password must have at least 6 characters".equals(mp.newPasswordValidation().getText())){
			log.info("New Password validation correct: "+mp.newPasswordValidation().getText());
		}
		else
			log.error("New Password validation is not correct! "+mp.newPasswordValidation().getText());
	}
	
	@Test(priority=5)
	public void passwordDoesntMatch() throws IOException {
		MyProfilePage mp = new MyProfilePage(driver);
		Login login = new Login();
		mp.oldPassword().clear();
		mp.oldPassword().sendKeys(login.password);
		mp.newPassword().clear();
		mp.newPassword().sendKeys(newPassword);
		mp.confirmNewPassword().clear();
		mp.confirmNewPassword().sendKeys(confirmPasswordDoesntMatch);
		mp.changesPasswordButton().click();
		if("New passwords do not match. Please try again".equals(mp.confirmNewPasswordValidation().getText())){
			log.info("Confirm Password validation correct: "+mp.confirmNewPasswordValidation().getText());
		}
		else {
			log.error("Confirm Password validation is not correct! "+mp.confirmNewPasswordValidation().getText());}
		log.info("*********************************************************************************************");
	}
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}
	
}
