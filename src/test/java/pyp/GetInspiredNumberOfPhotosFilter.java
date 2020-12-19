package pyp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.GetInspiredPage;
import resources.Base;


public class GetInspiredNumberOfPhotosFilter extends Base{
	public static Logger log = LogManager.getLogger(GetInspiredNumberOfPhotosFilter.class.getName());
	
	@Test(priority=1)
	public void numberOfPhotosFilter() throws IOException {
	GetInspiredPage gp = new GetInspiredPage(driver);
	int videoSize = gp.videoBody().size();
	wait_time(1);
	log.info("Before clicking on number of photos filter we have " +videoSize+ " displayed videos");
	gp.threeDotsMenu().click();
	wait_time(2);
	gp.numberOfPhotos().click();
	gp.numberOfPhotosOption().get(0).click();
	wait_time(2);
	try {
		gp.noResultsFound().isDisplayed();
		log.info("No results after selecting first option '<10' ");
		jsClick(gp.clearAll(), driver);
		gp.numberOfPhotos().click();
	}
	catch(Exception e)
	 {
		gp.numberOfPhotos().click();
		int size = gp.videoBody().size();
		log.info("After clicking <10 option " +size+ " videos are displayed");
		jsClick(gp.clearAll(), driver);
	}
	wait_time(1);
	gp.numberOfPhotos().click();
	gp.numberOfPhotosOption().get(1).click();
	wait_time(2);
	try {
		gp.noResultsFound().isDisplayed();
		log.info("No results after selecting second option '10-20' ");
		jsClick(gp.clearAll(), driver);
		gp.numberOfPhotos().click();
	}
	catch (Exception e) {
		gp.numberOfPhotos().click();
		int size = gp.videoBody().size()-1;
		log.info("After clicking 10-20 option " +size+ " videos are displayed");
		jsClick(gp.clearAll(), driver);
	}
	wait_time(1);
	gp.numberOfPhotos().click();
	gp.numberOfPhotosOption().get(2).click();
	wait_time(2);
	try {
		gp.noResultsFound().isDisplayed();
		log.info("No results after selecting third option '>20' ");
		jsClick(gp.clearAll(), driver);
		gp.numberOfPhotos().click();
	}
	catch (Exception e) {
		gp.numberOfPhotos().click();
		int size = gp.videoBody().size()-1;
		log.info("After clicking >20 option " +size+ " videos are displayed");
		jsClick(gp.clearAll(), driver);
	}
	gp.threeDotsMenu().click();
	log.info("*********************************************************************");
}
	
}