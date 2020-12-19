package pyp;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.MyFilesPage;
import resources.Base;


public class MyFilesAddFilesFromStock extends Base{
	public static Logger log = LogManager.getLogger(MyFilesAddFilesFromStock.class.getName());
	
	@Test
	public void uploadStock() throws Exception {
		navigateTab("My Files");
		wait_time(2);
		MyFilesPage mf = new MyFilesPage(driver);
		if("My Files".equals(mf.titleMyFiles().getText())){
			log.info("My Files Page successfully opened");
		}
		else
			log.error("My Files Page is not opened");
		log.info("Pre stock upload-a ima " +mf.mediaBody().size()+ " media");
		mf.addFilesButton().click();
		wait_time(1);
		mf.uploadOption().get(6).click();
		wait_time(5);
		int random = new Random().nextInt(5);
		mf.stockMedia().get(random).click();
		mf.addFilesButton1().click();
		wait_time(5);
		try {
			mf.uploadFilesButton1().isDisplayed();
			log.error("Upload is not passed");
		} catch (Exception e) {
			log.info("Media is uploaded");
		}
		driver.navigate().refresh();
		wait_time(2);
		log.info("Nakon stock upload-a na " +mf.allFilesTab().getText()+ "ima " +mf.mediaBody().size()+ " media");
		log.info("Trenutno zauzece prostora je: " +mf.storageInfo().getText());
		log.info("*************************************************************************");
	}
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
