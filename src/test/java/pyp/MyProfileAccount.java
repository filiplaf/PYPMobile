package pyp;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.MyProfilePage;
import resources.Base;


public class MyProfileAccount extends Base{
	public static Logger log = LogManager.getLogger(MyProfileAccount.class.getName());
	private String name="FilipTest";
	
	@Test
	public void myProfile() throws IOException {
		//FileUtils.forceDelete(new File("Screenshots/"));
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
	 
	@Test(priority=1)
	public void updateName() throws IOException {
		MyProfilePage mp = new MyProfilePage(driver);
		mp.name().clear();
		mp.name().sendKeys(name);
		jsClick(mp.saveChanges(), driver);
		if(mp.messageAlert().isDisplayed()){
			log.info(mp.messageAlert().getText());
		}
		else
			log.error("Something went wrong");
	}
	
	@Test(priority=2)
	public void uploadPicture() throws Exception {
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		MyProfilePage mp = new MyProfilePage(driver);
	    mp.uploadPicture().sendKeys(upload());
	    if("Crop Image".equals(mp.cropImageTest().getText())){
	    	wait_time(1);
	    	log.info("Crop Image successfully opened");
		}
		else {
			log.error("Crop Image is not opened");}
	    mp.doneCroping().click();
	    captureScreen(name);
	}
	
	@Test(priority=3)
	public void deleteAvatarPicture() throws Exception {
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		MyProfilePage mp = new MyProfilePage(driver);
	    mp.deleteAvatarPictureButton().click();
	    wait_time(2);
	    try{
	    	mp.deleteAvatarPictureButton().isDisplayed();
	    	log.error("Avatar picture isnt deleted");
	    }
	    catch (Exception e) {
	    log.info("Avatar picture successfully deleted");} 
	    captureScreen(name);
	}
	
	
	@Test(priority=3)
	public void uploadPicture1() throws Exception {
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		MyProfilePage mp = new MyProfilePage(driver);
	    mp.uploadPicture().sendKeys(upload1());
	    if("Crop Image".equals(mp.cropImageTest().getText())){
	    	log.info("Crop Image successfully opened");
		}
		else {
			log.error("Crop Image is not opened");}
	    mp.doneCroping().click();
	    captureScreen(name);
	    log.info("*********************************************************************************************");
	}
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}	
}
