package pyp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.TemplatesPage;
import resources.Base;


public class TemplatesDurationFilter extends Base{
	public static Logger log = LogManager.getLogger(TemplatesDurationFilter.class.getName());
	
	@Test(priority=1)
	public void durationFilter() throws IOException {
	TemplatesPage tp = new TemplatesPage(driver);
	int videoSize = tp.videoBody().size();
	wait_time(1);
	log.info("Before clicking on duration filter we have " +videoSize+ " displayed videos");
	tp.threeDotsMenu().click();
	wait_time(2);
	tp.duration().click();
	tp.durationOption().get(0).click();
	wait_time(2);
	try {
		tp.noResultMessage().isDisplayed();
		log.info("No results after selecting first option 'Short <15s' ");
		jsClick(tp.clearFilter(), driver);
		tp.duration().click();
	}
	catch(Exception e)
	 {
		tp.duration().click();
		int size = tp.videoBody().size();
		log.info("After clicking Short <15 option " +size+ " videos are displayed");
		jsClick(tp.clearFilter(), driver);
	}
	wait_time(1);
	tp.duration().click();
	tp.durationOption().get(1).click();
	wait_time(2);
	try {
		tp.noResultMessage().isDisplayed();
		log.info("No results after selecting second option 'Medium 15-30s' ");
		jsClick(tp.clearFilter(), driver);
		tp.duration().click();
	}
	catch (Exception e) {
		tp.duration().click();
		int size = tp.videoBody().size();
		log.info("After clicking Medium 15-30s option " +size+ " videos are displayed");
		tp.clearFilter().click();
	}
	wait_time(1);
	tp.duration().click();
	tp.durationOption().get(2).click();
	wait_time(2);
	try {
		tp.noResultMessage().isDisplayed();
		log.info("No results after selecting third option 'Long >30s' ");
		jsClick(tp.clearFilter(), driver);
		tp.duration().click();
	}
	catch (Exception e) {
		tp.duration().click();
		int size = tp.videoBody().size();
		log.info("After clicking Long >30s option " +size+ " videos are displayed");
		jsClick(tp.clearFilter(), driver);
	}
	tp.threeDotsMenu().click();
	log.info("*********************************************************************");
}
	
}