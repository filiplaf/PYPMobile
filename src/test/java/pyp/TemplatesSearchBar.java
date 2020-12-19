package pyp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.TemplatesPage;
import resources.Base;


public class TemplatesSearchBar extends Base{
	public static Logger log = LogManager.getLogger(TemplatesSearchBar.class.getName());
private String search = "logo";
private String wrongSearch = "logo123";
	
	@Test(priority=1)
	public void searchBarByKeyword() throws Exception {
		TemplatesPage tp = new TemplatesPage(driver);
		tp.searchBar().sendKeys(search);
		int size = tp.videoBody().size();
		log.info("After search by word " +search+ " number of presented videos are: " +size);
		log.info(tp.searchMessage().getText());
	}
	
	@Test(priority=2)
	public void validationIfVideoDontExistAfterSearch() throws Exception {
		TemplatesPage tp = new TemplatesPage(driver);
		tp.searchBar().clear();
		tp.searchBar().sendKeys(wrongSearch);
		if(tp.noResultMessage().isDisplayed()) {
			log.info(tp.noResultMessage().getText() + " after search logo123");
		}
		else {
			{log.info("Video exist after search logo123");}}
		log.info("*********************************************************************************************");
		}
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}	
}
