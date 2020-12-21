package pyp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.GetInspiredPage;
import resources.Base;


public class GetInspiredNewestAndPopularFilter extends Base{
	public static Logger log = LogManager.getLogger(GetInspiredNewestAndPopularFilter.class.getName());
	
	@Test(priority=1)
	public void getInspiredNewestAndPopular() throws IOException {
	navigateMobileTab("Get Inspired");
	wait_time(2);
	GetInspiredPage gp = new GetInspiredPage(driver);
	log.info("Na stranici je prikazano " +gp.videoBody().size()+ " template-a dok je Newest selektovan");
	gp.NewPopular().click();
	gp.PopularOption().get(1).click();
	try {
		gp.noResultsFound().isDisplayed();
		log.info("No results after selecting Popular option ");
	}
	catch(Exception e)
	 {
		int size = gp.videoBody().size();
		log.info("After clicking Popular option " +size+ " videos are displayed");
}
	log.info("*********************************************************************************************");
}
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}
}