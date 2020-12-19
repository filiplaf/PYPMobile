package pyp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.MyFilesPage;
import resources.Base;


public class MyFilesSearchBar extends Base{
	public static Logger log = LogManager.getLogger(MyFilesSearchBar.class.getName());
	private String search ="a";
	private String wrongSearch = "abcd";
	
	
	@Test(priority=1)
	public void searchMedia() throws Exception {
		navigateTab("My Files");
		wait_time(2);
		MyFilesPage mf = new MyFilesPage(driver);
		if("My Files".equals(mf.titleMyFiles().getText())){
			log.info("My Files Page successfully opened");
		}
		else
			log.error("My Files Page is not opened");
		log.info("Pre search-a ima " +mf.mediaBody().size()+ " media");
		try {
			mf.searchBar().sendKeys(search);
			wait_time(2);
			log.info("Nakon unosa "+search+ " prikazano je " +mf.mediaBody().size()+ " media");
		} catch (Exception e) {
			log.info("Treba obraditi ovaj slucaj");
		}
	}
			
	@Test(priority=2)
	public void wrongSearchMedia() throws Exception {
		MyFilesPage mf = new MyFilesPage(driver);
		mf.searchBarClear().click();
		wait_time(2);
		log.info("Pre search-a ima " +mf.mediaBody().size()+ " media");
		try {
			mf.searchBar().sendKeys(wrongSearch);
			log.info("Nakon unosa "+wrongSearch+ " prikazano je " +mf.mediaBody().size()+ " media");
		} catch (Exception e) {
			log.info("Treba obraditi ovaj slucaj");
		}
		log.info("**********************************************************************************");
	}
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}
}