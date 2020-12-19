package pyp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.TemplatesPage;
import resources.Base;


public class TemplatesMoodFilter extends Base{
	public static Logger log = LogManager.getLogger(TemplatesMoodFilter.class.getName());
	
	@Test(priority=1)
	public void moodFilter() throws IOException {
	TemplatesPage tp = new TemplatesPage(driver);
	int videoSize = tp.videoBody().size();
	wait_time(1);
	log.info("Before clicking on mood filter we have " +videoSize+ " displayed videos");
	tp.threeDotsMenu().click();
	wait_time(2);
	tp.mood().click();
	tp.moodOption().get(0).click();
	wait_time(2);
	try {
		tp.noResultMessage().isDisplayed();
		log.info("No results after selecting mood option " + tp.moodOption().get(0).getText());
		jsClick(tp.clearFilter(), driver);
		tp.mood().click();
	}
	catch(Exception e)
	 {
		String moodOption = tp.moodOption().get(0).getText();
		tp.mood().click();
		int size = tp.videoBody().size();
		log.info("After clicking " + moodOption + " option " +size+ " videos are displayed");
		jsClick(tp.clearFilter(), driver);
	}
	wait_time(1);
	tp.mood().click();
	tp.moodOption().get(1).click();
	wait_time(2);
	try {
		tp.noResultMessage().isDisplayed();
		log.info("No results after selecting option " + tp.moodOption().get(1).getText());
		jsClick(tp.clearFilter(), driver);
		tp.mood().click();
	}
	catch (Exception e) {
		String moodOption = tp.moodOption().get(1).getText();
		tp.mood().click();
		int size = tp.videoBody().size();
		log.info("After clicking " + moodOption+ " option " +size+ " videos are displayed");
		jsClick(tp.clearFilter(), driver);
	}
	wait_time(1);
	tp.mood().click();
	tp.moodOption().get(2).click();
	wait_time(2);
	try {
		tp.noResultMessage().isDisplayed();
		log.info("No results after selecting option " + tp.moodOption().get(2).getText());
		jsClick(tp.clearFilter(), driver);
		tp.mood().click();
	}
	catch (Exception e) {
		String moodOption = tp.moodOption().get(2).getText();
		tp.mood().click();
		int size = tp.videoBody().size();
		log.info("After clicking " + moodOption + " option " +size+ " videos are displayed");
		jsClick(tp.clearFilter(), driver);
	}
	tp.threeDotsMenu().click();
	log.info("*********************************************************************");
}
	
}