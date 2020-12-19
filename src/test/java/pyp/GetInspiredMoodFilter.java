package pyp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.GetInspiredPage;
import resources.Base;


public class GetInspiredMoodFilter extends Base{
	public static Logger log = LogManager.getLogger(GetInspiredMoodFilter.class.getName());
	
	@Test(priority=1)
	public void moodFilter() throws IOException {
	GetInspiredPage gp = new GetInspiredPage(driver);
	int videoSize = gp.videoBody().size();
	wait_time(1);
	log.info("Before clicking on mood filter we have " +videoSize+ " displayed videos");
	gp.threeDotsMenu().click();
	wait_time(2);
	gp.mood().click();
	gp.moodOption().get(0).click();
	wait_time(2);
	try {
		gp.noResultsFound().isDisplayed();
		log.info("No results after selecting first mood option " + gp.moodOption().get(0).getText());
		jsClick(gp.clearAll(), driver);
		gp.mood().click();
	}
	catch(Exception e)
	 {
		String moodOption = gp.moodOption().get(0).getText();
		gp.mood().click();
		int size = gp.videoBody().size();
		log.info("After clicking " +moodOption+ " option " +size+ " videos are displayed");
		jsClick(gp.clearAll(), driver);
	}
	wait_time(1);
	gp.mood().click();
	gp.moodOption().get(1).click();
	wait_time(2);
	try {
		gp.noResultsFound().isDisplayed();
		log.info("No results after selecting second option " + gp.moodOption().get(1).getText());
		jsClick(gp.clearAll(), driver);
		gp.mood().click();
	}
	catch (Exception e) {
		String moodOption = gp.moodOption().get(1).getText();
		gp.mood().click();
		int size = gp.videoBody().size();
		log.info("After clicking " + moodOption + " option " +size+ " videos are displayed");
		jsClick(gp.clearAll(), driver);
	}
	wait_time(1);
	gp.mood().click();
	gp.moodOption().get(6).click();
	wait_time(2);
	try {
		gp.noResultsFound().isDisplayed();
		log.info("No results after selecting third option " + gp.moodOption().get(6).getText());
		jsClick(gp.clearAll(), driver);
		gp.mood().click();
	}
	catch (Exception e) {
		String moodOption = gp.moodOption().get(6).getText();
		gp.mood().click();
		int size = gp.videoBody().size();
		log.info("After clicking " + moodOption + " option " +size+ " videos are displayed");
		jsClick(gp.clearAll(), driver);
	}
	gp.threeDotsMenu().click();
	log.info("*********************************************************************");
}
	
}