package pyp;

import java.io.IOException;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.TemplatesPage;
import resources.Base;


public class TemplatesCategories extends Base{
	public static Logger log = LogManager.getLogger(TemplatesCategories.class.getName());
	
	@Test(priority=1)
	public void categories() throws IOException {
	TemplatesPage tp = new TemplatesPage(driver);
	int size = tp.videoBody().size();
	log.info("Before clicking on categories we have " +size+ " displayed videos");
	tp.categories().click();
	tp.categoryOption().get(1).click();
	String name = tp.categoryOption().get(1).getText();
	wait_time(2);
	int size1 = tp.videoBody().size();
	log.info("After selecting option " +name+ " we have " +size1+ " displayed videos");
	int random = new Random().nextInt(11);
	tp.categoryOption().get(random).click();
	wait_time(2);
	int size2 = tp.videoBody().size();
	log.info("After selecting " +tp.categoryOption().get(random).getText()+ " options we have " +size2+ " displayed videos");
	tp.clearFilter().click();
	wait_time(2);
	int size3 = tp.videoBody().size();
	log.info("After clearing filter we have " +size3+ " displayed videos");
	}
	
	@Test(priority=2)
	public void categoriesWithFilterNotFound() throws IOException {
	TemplatesPage tp = new TemplatesPage(driver);
	int size = tp.videoBody().size();
	log.info("Before clicking on categories we have " +size+ " displayed videos");
	tp.categories().click();
	tp.categoryOption().get(4).click();
	String name = tp.categoryOption().get(4).getText();
	wait_time(2);
	int size1 = tp.videoBody().size();
	log.info("After selecting option " +name+ " we have " +size1+ " displayed videos");
	log.info(tp.noResultMessage().getText());
	jsClick(tp.clearFilter(), driver);
	wait_time(2);
	int size2 = tp.videoBody().size();
	log.info("After clicking on clear filter button we have " +size2+ " displayed videos");
	log.info("*********************************************************************************************");
	}
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
