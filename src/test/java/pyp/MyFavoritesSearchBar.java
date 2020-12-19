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


public class MyFavoritesSearchBar extends Base{
	public static Logger log = LogManager.getLogger(MyFavoritesSearchBar.class.getName());
	private String search ="logo";
	private String wrongSearch = "abcd";
	
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
	public void searchMedia() throws IOException {
		MyFavoritesPage fp = new MyFavoritesPage(driver);
		fp.searchBar().sendKeys(search);
		log.info("After searching " +search+ " there is " +fp.videoBody().size()+ " media");
		log.info(fp.searchResult().getText());
		fp.searchBar().clear();
	}
	
	@Test(priority=2)
	public void wrongSearchMedia() throws IOException {
		MyFavoritesPage fp = new MyFavoritesPage(driver);
		fp.searchBar().sendKeys(wrongSearch);
		log.info("After searching " +wrongSearch+ " there is " +fp.videoBody().size()+ " media");
		log.info(fp.searchResult().getText());
	}
	
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}	
}
