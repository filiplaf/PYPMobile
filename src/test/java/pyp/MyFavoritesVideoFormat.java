package pyp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.MyFavoritesPage;
import pageObjects.TemplatesPage;
import resources.Base;


public class MyFavoritesVideoFormat extends Base{
	public static Logger log = LogManager.getLogger(MyFavoritesVideoFormat.class.getName());
	
	@Test(priority=1)
	public void checkMediaOnPage() throws IOException {
		TemplatesPage tp = new TemplatesPage(driver);
		MyFavoritesPage fp = new MyFavoritesPage(driver);
		navigateTab("My Favorites");
		try {
			if(fp.exploreTemplateButton().isDisplayed()) {
				log.info("There is no favorite media on page, need to select on template page");
				navigateTab("Templates");
				Actions action = new Actions(driver);
				//Hover na video
				action.moveToElement(tp.video()).perform();
				tp.favoriteMark().get(0).click();
				action.moveToElement(tp.video()).perform();
				tp.favoriteMark().get(1).click();
				navigateTab("My Favorites");
				wait_time(1);
				log.info("After selection on template page there is " +fp.videoBody().size()+ " media");
			}
		} catch (Exception e) {
			log.error("There is " +fp.videoBody().size()+ " media on page");
		}
	}
	
	@Test(priority=2)
	public void checkVideoFormat() throws Exception {
		MyFavoritesPage fp = new MyFavoritesPage(driver);
		int Height169 = fp.video().getSize().getHeight();
		int Width169 = fp.video().getSize().getWidth();
		log.info("Video is in format 16:9 with Height: "+Height169+ " and Width: "+Width169);
		checkFormat("1:1");
		wait_time(2);
		int Height11 = fp.video().getSize().getHeight();
		int Width11 = fp.video().getSize().getWidth();
		log.info("Video is in format 1:1 with Height: "+Height11+ " and Width: "+Width11);
		if(Height169!=Height11 && Width169!=Width11) {
			log.info("Video changed format to 1:1 successfully");
		}
		else log.info("Video format is not correct!");
		checkFormat("9:16");
		wait_time(2);
		int Height916 = fp.video().getSize().getHeight();
		int Width916 = fp.video().getSize().getWidth();
		log.info("Video is in format 9:16 with Height: "+Height916+ " and Width: "+Width916);
		if(Height169!=Height916 && Width169!=Width916) {
			log.info("Video changed format to 9:16 successfully");
		}
		else {log.info("Video format is not correct!");}
		log.info("*********************************************************************************************");
	}
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}
}