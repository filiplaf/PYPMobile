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


public class MyProfileEmailNotification extends Base{
	public static Logger log = LogManager.getLogger(MyProfileEmailNotification.class.getName());
	
	@Test(priority=1)
	public void myProfile() throws IOException {
		HomePage hp = new HomePage(driver);
		MyProfilePage mp = new MyProfilePage(driver);
		Actions action = new Actions(driver);
		action.moveToElement(hp.avatar()).build().perform();
		hp.myProfile().click();
		if("My Profile".equals(mp.titleMyProfile().getText())){
			log.info("My Profile Page successfully opened");
		}
		else
			log.error("My Profile Page is not opened");
	}
	 
	@Test(priority=2)
	public void emailNotification() throws IOException {
		MyProfilePage mp = new MyProfilePage(driver);
		mp.emailNotificationTab().click();
		scrollIntoView(mp.emailWhenPuchase());
		mp.emailWhenPuchase().click();
		mp.emailWhenVideoDoneRendering().click();
		mp.subscribeLatestNews().click();
		mp.subscribeSpecialOffers().click();
		mp.updateEnailNotificationButton().click();
		scrollIntoView(mp.messageAlert());
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