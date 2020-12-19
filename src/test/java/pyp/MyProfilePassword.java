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

public class MyProfilePassword extends Base{
	public static Logger log = LogManager.getLogger(MyProfilePassword.class.getName());
	private String newPassword = "123456";
	private String confirmPassword = "123456";
	
	@Test(priority=1)
	public void myProfileNewPassword() throws IOException {
		Login login = new Login();
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
		mp.oldPassword().sendKeys(login.password);
		mp.newPassword().sendKeys(newPassword);
		scrollIntoView(mp.confirmNewPassword());
		mp.confirmNewPassword().sendKeys(confirmPassword);
		jsClick(mp.changesPasswordButton(), driver);
		if(mp.messageAlert().isDisplayed()){
			log.info(mp.messageAlert().getText());
		}
		else
			log.error("Something went wrong");
	}
	
	@Test(priority=2)
	public void myProfileBackPasswordAndLogin() throws IOException {
		Login login = new Login();
		MyProfilePage mp = new MyProfilePage(driver);
		mp.oldPassword().clear();
		mp.oldPassword().sendKeys(newPassword);
		mp.newPassword().clear();
		mp.newPassword().sendKeys(login.password);
		mp.confirmNewPassword().clear();
		mp.confirmNewPassword().sendKeys(login.password);
		jsClick(mp.changesPasswordButton(), driver);
		if(mp.messageAlert().isDisplayed()){
			log.info("Passwor return to old "+mp.messageAlert().getText());
		}
		else
			{log.error("Something went wrong");
			}
		log.info("*********************************************************************************************");
	}
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}
		
}
