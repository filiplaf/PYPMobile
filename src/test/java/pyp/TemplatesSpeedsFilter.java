package pyp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.TemplatesPage;
import resources.Base;


public class TemplatesSpeedsFilter extends Base{
	public static Logger log = LogManager.getLogger(TemplatesSpeedsFilter.class.getName());
	
	@Test(priority=1)
	public void speedsFilter() throws IOException {
	TemplatesPage tp = new TemplatesPage(driver);
	int videoSize = tp.videoBody().size();
	wait_time(1);
	log.info("Before clicking on speeds filter we have " +videoSize+ " displayed videos");
	tp.threeDotsMenu().click();
	wait_time(2);
	tp.speeds().click();
	tp.speedsOption().get(0).click();
	wait_time(2);
	try {
		tp.noResultMessage().isDisplayed();
		log.info("No results after selecting first speeds option 'Fast' ");
		jsClick(tp.clearFilter(), driver);
		tp.speeds().click();
	}
	catch(Exception e)
	 {
		tp.speeds().click();
		int size = tp.videoBody().size();
		log.info("After clicking Fast option " +size+ " videos are displayed");
		jsClick(tp.clearFilter(), driver);
	}
	wait_time(1);
	tp.speeds().click();
	tp.speedsOption().get(1).click();
	wait_time(2);
	try {
		tp.noResultMessage().isDisplayed();
		log.info("No results after selecting second option 'Normal' ");
		jsClick(tp.clearFilter(), driver);
		tp.speeds().click();
	}
	catch (Exception e) {
		tp.speeds().click();
		int size = tp.videoBody().size();
		log.info("After clicking Normal option " +size+ " videos are displayed");
		jsClick(tp.clearFilter(), driver);
	}
	wait_time(1);
	tp.speeds().click();
	tp.speedsOption().get(2).click();
	wait_time(2);
	try {
		tp.noResultMessage().isDisplayed();
		log.info("No results after selecting third option 'Slow' ");
		jsClick(tp.clearFilter(), driver);
		tp.speeds().click();
	}
	catch (Exception e) {
		tp.speeds().click();
		int size = tp.videoBody().size();
		log.info("After clicking Slow option " +size+ " videos are displayed");
		jsClick(tp.clearFilter(), driver);
	}
	tp.threeDotsMenu().click();
	log.info("*********************************************************************");
}
	
}