package pyp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.GetInspiredPage;
import resources.Base;


public class GetInspiredSearchBar extends Base{
	public static Logger log = LogManager.getLogger(GetInspiredSearchBar.class.getName());
	private String search = "test";
	private String badSearch ="aaa";
	
	@Test(priority=1)
	public void getInspiredBadSearch() throws IOException {
	navigateMobileTab("Get Inspired");
	wait_time(2);
	GetInspiredPage gp = new GetInspiredPage(driver);
	log.info("Na stranici je prikazano " +gp.videoBody().size()+ " template-a pre search-a");
	gp.searchBar().sendKeys(badSearch);
	wait_time(2);
	log.info("Nakon unosa "+badSearch+ " u search bar: " + gp.noResultsFound().getText());
}
	
	@Test(priority=2)
	public void getInspiredSearch() throws IOException {
	GetInspiredPage gp = new GetInspiredPage(driver);
	gp.clearSearchBar().click();
	wait_time(2);
	gp.searchBar().sendKeys(search);
	log.info("Nakon unosa "+search+ " u search bar, filtirano je: " +gp.results().getText()+ " , dok je na stranici prikazano " +gp.videoBody().size()+ " template-a");	
}
	
	@Test(priority=3)
	public void loadMoreTemplates() throws IOException {
		GetInspiredPage gp = new GetInspiredPage(driver);
		//gp.clearSearchBar().click();
		wait_time(5);
		log.info("Na stranici je prikazano " +gp.videoBody().size()+ " template-a pre load more templates");
	try{
		scrollIntoView(gp.loadMoreTemplates());
		while(gp.loadMoreTemplates().isDisplayed()){
		jsClick(gp.loadMoreTemplates(), driver);
		wait_time(3);
		log.info("Na stranici je prikazano " +gp.videoBody().size()+ " template-a nakon load more templates");
		scrollIntoView(gp.loadMoreTemplates());
		}
	}
	catch (Exception e) {
		log.info("No more load templates button");
	}
	log.info("*********************************************************************************************");
	}
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}
}