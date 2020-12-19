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


public class MyFavoritesPreview extends Base{
	public static Logger log = LogManager.getLogger(MyFavoritesPreview.class.getName());
	
	@Test(priority=1)
	public void myFavoritesPreview() throws IOException {
		TemplatesPage tp = new TemplatesPage(driver);
		MyFavoritesPage fp = new MyFavoritesPage(driver);
		Actions action = new Actions(driver);
		//Hover na video
		action.moveToElement(tp.video()).perform();
		tp.favoriteMark().get(0).click();
		navigateTab("My Favorites");
		log.info("Na Favorite stranici je prikazano " +fp.videoBody().size()+ " media");
		log.info(fp.favoritesTitle().getText());
		navigateTab("Templates");
		wait_time(1);
		action.moveToElement(tp.video1()).perform();
		tp.favoriteMark().get(1).click();
		navigateTab("My Favorites");
		log.info("Na Favorite stranici je prikazano " +fp.videoBody().size()+ " media");
		log.info(fp.favoritesTitle().getText());
	}
	
	@Test(priority=2)
	public void deleteAllFavorites() throws IOException {
		MyFavoritesPage fp = new MyFavoritesPage(driver);
		fp.deleteAllButton().click();
		fp.deleteButton().click();
		try {
			if(fp.exploreTemplateButton().isDisplayed()) {
				log.info("All favorite media are deleted");
			}
		} catch (Exception e) {
			log.error("Something went wrong");
		}
	}
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}	
}
