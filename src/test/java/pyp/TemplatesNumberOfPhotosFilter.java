package pyp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.TemplatesPage;
import resources.Base;


public class TemplatesNumberOfPhotosFilter extends Base{
	public static Logger log = LogManager.getLogger(TemplatesNumberOfPhotosFilter.class.getName());
	
	@Test(priority=1)
	public void numberOfPhotosFilter() throws IOException {
	TemplatesPage tp = new TemplatesPage(driver);
	int videoSize = tp.videoBody().size();
	wait_time(1);
	log.info("Before clicking on number of photos filter we have " +videoSize+ " displayed videos");
	tp.threeDotsMenu().click();
	wait_time(2);
	tp.numberOfPhotos().click();
	tp.numberOfPhotosOption().get(0).click();
	wait_time(2);
	try {
		tp.noResultMessage().isDisplayed();
		log.info("No results after selecting first option '<10' ");
		jsClick(tp.clearFilter(), driver);
		tp.numberOfPhotos().click();
	}
	catch(Exception e)
	 {
		tp.numberOfPhotos().click();
		int size = tp.videoBody().size();
		log.info("After clicking <10 option " +size+ " videos are displayed");
		jsClick(tp.clearFilter(), driver);
	}
	wait_time(1);
	tp.numberOfPhotos().click();
	tp.numberOfPhotosOption().get(1).click();
	wait_time(2);
	try {
		tp.noResultMessage().isDisplayed();
		log.info("No results after selecting second option '10-20' ");
		jsClick(tp.clearFilter(), driver);
		tp.numberOfPhotos().click();
	}
	catch (Exception e) {
		tp.numberOfPhotos().click();
		int size = tp.videoBody().size();
		log.info("After clicking 10-20 option " +size+ " videos are displayed");
		jsClick(tp.clearFilter(), driver);
	}
	wait_time(1);
	tp.numberOfPhotos().click();
	tp.numberOfPhotosOption().get(2).click();
	wait_time(2);
	try {
		tp.noResultMessage().isDisplayed();
		log.info("No results after selecting third option '>20' ");
		jsClick(tp.clearFilter(), driver);
		tp.numberOfPhotos().click();
	}
	catch (Exception e) {
		tp.numberOfPhotos().click();
		int size = tp.videoBody().size();
		log.info("After clicking >20 option " +size+ " videos are displayed");
		jsClick(tp.clearFilter(), driver);
	}
	tp.threeDotsMenu().click();
	log.info("*********************************************************************");
}
	
}