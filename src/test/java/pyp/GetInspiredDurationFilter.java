package pyp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.GetInspiredPage;
import resources.Base;


public class GetInspiredDurationFilter extends Base{
	public static Logger log = LogManager.getLogger(GetInspiredDurationFilter.class.getName());
	
	@Test(priority=1)
	public void durationFilter() throws IOException {
	navigateTab("Get Inspired"); 
	wait_time(2);
	GetInspiredPage gp = new GetInspiredPage(driver);
	int videoSize = gp.videoBody().size();
	log.info("Before clicking on duration filter we have " +videoSize+ " displayed videos");
	gp.threeDotsMenu().click();
	wait_time(2);
	gp.duration().click();
	gp.durationOption().get(0).click();
	wait_time(2);
	try {
		gp.noResultsFound().isDisplayed();
		log.info("No results after selecting first option 'Short <15s' ");
		jsClick(gp.clearAll(), driver);
		gp.duration().click();
	}
	catch(Exception e)
	 {
		gp.duration().click();
		int size = gp.videoBody().size();
		log.info("After clicking Short <15 option " +size+ " videos are displayed");
		jsClick(gp.clearAll(), driver);
	}
	wait_time(1);
	gp.duration().click();
	gp.durationOption().get(1).click();
	wait_time(2);
	try {
		gp.noResultsFound().isDisplayed();
		log.info("No results after selecting second option 'Medium 15-30s' ");
		jsClick(gp.clearAll(), driver);
		gp.duration().click();
	}
	catch (Exception e) {
		gp.duration().click();
		int size = gp.videoBody().size();
		log.info("After clicking Medium 15-30s option " +size+ " videos are displayed");
		jsClick(gp.clearAll(), driver);
	}
	wait_time(1);
	gp.duration().click();
	gp.durationOption().get(2).click();
	wait_time(2);
	try {
		gp.noResultsFound().isDisplayed();
		log.info("No results after selecting third option 'Long >30s' ");
		jsClick(gp.clearAll(), driver);
		gp.duration().click();
	}
	catch (Exception e) {
		gp.duration().click();
		int size = gp.videoBody().size();
		log.info("After clicking Long >30s option " +size+ " videos are displayed");
		jsClick(gp.clearAll(), driver);
	}
	gp.threeDotsMenu().click();
	log.info("*********************************************************************");
}
	}