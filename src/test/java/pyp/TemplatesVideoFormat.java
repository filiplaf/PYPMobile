package pyp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.TemplatesPage;
import resources.Base;


public class TemplatesVideoFormat extends Base{
	public static Logger log = LogManager.getLogger(TemplatesVideoFormat.class.getName());
	
	@Test
	public void checkVideoFormat() throws Exception {
		TemplatesPage tp = new TemplatesPage(driver);
		navigateTab("Templates");
		int Height169 = tp.video().getSize().getHeight();
		int Width169 = tp.video().getSize().getWidth();
		log.info("Video is in format 16:9 with Height: "+Height169+ " and Width: "+Width169);
		checkFormat("1:1");
		wait_time(2);
		int Height11 = tp.video().getSize().getHeight();
		int Width11 = tp.video().getSize().getWidth();
		log.info("Video is in format 1:1 with Height: "+Height11+ " and Width: "+Width11);
		if(Height169!=Height11 && Width169!=Width11) {
			log.info("Video changed format to 1:1 successfully");
		}
		else log.info("Video format is not correct!");
		checkFormat("9:16");
		wait_time(2);
		int Height916 = tp.video().getSize().getHeight();
		int Width916 = tp.video().getSize().getWidth();
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