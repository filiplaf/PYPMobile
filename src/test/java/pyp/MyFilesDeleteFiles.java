package pyp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.MyFilesPage;
import resources.Base;


public class MyFilesDeleteFiles extends Base{
	public static Logger log = LogManager.getLogger(MyFilesDeleteFiles.class.getName());
	
	@Test(priority=1)
	public void deleteFilesOnIcon() throws Exception {
		navigateMobileTab("My Files");
		wait_time(2);
		MyFilesPage mf = new MyFilesPage(driver);
		if("My Files".equals(mf.titleMyFiles().getText())){
			log.info("My Files Page successfully opened");
		}
		else
			log.error("My Files Page is not opened");
		log.info("Pre brisanja ima " +mf.mediaBody().size()+ " fajlova");
		log.info(mf.allFilesTab().getText());
		mf.mediaBody().get(0).click();
		mf.deleteIcon().click();
		mf.deleteButton().click();
		wait_time(2);
		log.info("Nakon brisanja fajla ima " +mf.mediaBody().size()+ " fajlova na strani");
		log.info(mf.allFilesTab().getText());
	}
	
	@Test(priority=1)
	public void deleteFilesOnMedia() throws Exception {
		//String name = new Object(){}.getClass().getEnclosingMethod().getName();
		MyFilesPage mf = new MyFilesPage(driver);
		if("My Files".equals(mf.titleMyFiles().getText())){
			log.info("My Files Page successfully opened");
		}
		else
			log.error("My Files Page is not opened");
		log.info("Pre brisanja ima " +mf.mediaBody().size()+ " fajlova na strani");
		log.info(mf.allFilesTab().getText());
		mf.mediaBody().get(0).click();
		mf.threeDotsOnMedia().click();
		mf.threeDotsMenuOption().get(3).click();
		scrollIntoView(mf.deleteButton());
		mf.deleteButton().click();
		wait_time(2);
		log.info("Nakon brisanja fajla ima " +mf.mediaBody().size()+ " fajlova");
		log.info(mf.allFilesTab().getText());
		log.info("********************************************************************************");
	}
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
