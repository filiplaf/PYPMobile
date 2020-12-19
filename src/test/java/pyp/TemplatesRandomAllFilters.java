package pyp;

import java.io.IOException;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.TemplatesPage;
import resources.Base;


public class TemplatesRandomAllFilters extends Base{
	public static Logger log = LogManager.getLogger(TemplatesRandomAllFilters.class.getName());
	
	@Test(priority=1)
	public void RandomFilters() throws IOException {
	TemplatesPage tp = new TemplatesPage(driver);
	int videoSize = tp.videoBody().size();
	wait_time(1);
	log.info("Before clicking on duration filter we have " +videoSize+ " displayed videos");
	tp.threeDotsMenu().click();
	wait_time(2);
	tp.duration().click();
	int random = new Random().nextInt(3);
	log.info(tp.durationOption().get(random).getText()+ " opcija je izabrana");
	tp.durationOption().get(random).click();
	tp.numberOfPhotos().click();
	int random1 = new Random().nextInt(3);
	log.info(tp.numberOfPhotosOption().get(random1).getText()+ " opcija je izabrana");
	tp.numberOfPhotosOption().get(random1).click();
	tp.mood().click();
	int random2 = new Random().nextInt(21);
	log.info(tp.moodOption().get(random2).getText()+ " opcija je izabrana");
	tp.moodOption().get(random2).click();
	tp.speeds().click();
	int random3 = new Random().nextInt(3);
	log.info(tp.speedsOption().get(random3).getText()+ " opcija je izabrana");
	tp.speedsOption().get(random3).click();
	try {
		tp.noResultMessage().isDisplayed();
		log.info("No results after selecting this filters");
	}
	catch(Exception e)
	 {
		int size = tp.videoBody().size();
		log.info("After selecting this filters " +size+ " videos are displayed");
	}
	log.info("******************************************************************************************");	
}
	}