package pyp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.GetInspiredPage;
import resources.Base;


public class GetInspiredSpeedsFilter extends Base{
	public static Logger log = LogManager.getLogger(GetInspiredSpeedsFilter.class.getName());
	
	@Test(priority=1)
	public void speedsFilter() throws IOException {
	GetInspiredPage gp = new GetInspiredPage(driver);
	int videoSize = gp.videoBody().size();
	wait_time(1);
	log.info("Before clicking on speeds filter we have " +videoSize+ " displayed videos");
	gp.threeDotsMenu().click();
	wait_time(2);
	gp.speeds().click();
	gp.speedsOption().get(0).click();
	wait_time(2);
	try {
		gp.noResultsFound().isDisplayed();
		log.info("No results after selecting first speeds option 'Fast' ");
		jsClick(gp.clearAll(), driver);
		gp.speeds().click();
	}
	catch(Exception e)
	 {
		gp.speeds().click();
		int size = gp.videoBody().size();
		log.info("After clicking Fast option " +size+ " videos are displayed");
		jsClick(gp.clearAll(), driver);
	}
	wait_time(1);
	gp.speeds().click();
	gp.speedsOption().get(1).click();
	wait_time(2);
	try {
		gp.noResultsFound().isDisplayed();
		log.info("No results after selecting second option 'Normal' ");
		jsClick(gp.clearAll(), driver);
		gp.speeds().click();
	}
	catch (Exception e) {
		gp.speeds().click();
		int size = gp.videoBody().size();
		log.info("After clicking Normal option " +size+ " videos are displayed");
		jsClick(gp.clearAll(), driver);
	}
	wait_time(1);
	gp.speeds().click();
	gp.speedsOption().get(2).click();
	wait_time(2);
	try {
		gp.noResultsFound().isDisplayed();
		log.info("No results after selecting third option 'Slow' ");
		jsClick(gp.clearAll(), driver);
		gp.speeds().click();
	}
	catch (Exception e) {
		gp.speeds().click();
		int size = gp.videoBody().size();
		log.info("After clicking Slow option " +size+ " videos are displayed");
		jsClick(gp.clearAll(), driver);
	}
	gp.threeDotsMenu().click();
	log.info("*******************************************");
}
}