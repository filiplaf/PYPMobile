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


public class MyProfileDeleteAccount extends Base{
	public static Logger log = LogManager.getLogger(MyProfileDeleteAccount.class.getName());
	
	@Test
	public void myDeleteProfile() throws IOException {
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
		jsClick(mp.deleteAccountButton(), driver);
		wait_time(1);
		if("Delete Your Account".equals(mp.deleteAccountPopUpMessage().getText())){
			log.info("Delete your account pop up successfully opened");
		}
		else {
			log.error("Delete your account pop up is not opened");}
		mp.deleteButton().click();
		if(mp.messageAlert().isDisplayed()){
			log.info(mp.messageAlert().getText());
		}
		else
			{log.error("Something went wrong");
			log.info("*********************************************************************************************");}
	}
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}	
}
