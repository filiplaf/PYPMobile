package pyp;

import java.io.IOException;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.GetInspiredPage;
import resources.Base;


public class GetInspiredRandomAllFilters extends Base{
	public static Logger log = LogManager.getLogger(GetInspiredRandomAllFilters.class.getName());
	
	@Test(priority=1)
	public void RandomFilters() throws IOException {
	GetInspiredPage gp = new GetInspiredPage(driver);
	int videoSize = gp.videoBody().size();
	wait_time(1);
	log.info("Before clicking on filters we have: " +videoSize+ " videos");
	gp.threeDotsMenu().click();
	wait_time(2);
	gp.duration().click();
	int random = new Random().nextInt(3);
	log.info(gp.durationOption().get(random).getText()+ " opcija je izabrana");
	gp.durationOption().get(random).click();
	gp.numberOfPhotos().click();
	int random1 = new Random().nextInt(3);
	log.info(gp.numberOfPhotosOption().get(random1).getText()+ " opcija je izabrana");
	gp.numberOfPhotosOption().get(random1).click();
	gp.mood().click();
	int random2 = new Random().nextInt(20);
	log.info(gp.moodOption().get(random2).getText()+ " opcija je izabrana");
	gp.moodOption().get(random2).click();
	gp.speeds().click();
	int random3 = new Random().nextInt(3);
	log.info(gp.speedsOption().get(random3).getText()+ " opcija je izabrana");
	gp.speedsOption().get(random3).click();
	try {
		gp.noResultsFound().isDisplayed();
		log.info("No results after selecting this filters");
	}
	catch(Exception e)
	 {
		int size = gp.videoBody().size();
		log.info("After selecting this filters " +size+ " videos are displayed");
	}
	log.info("******************************************************************************************");	
}
	}