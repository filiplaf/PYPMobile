package pyp;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.MyFilesPage;
import resources.Base;


public class MyFilesSortFunctionalities extends Base{
	public static Logger log = LogManager.getLogger(MyFilesSortFunctionalities.class.getName());
	
	@Test(priority=1)
	public void sortNameFunctionality() throws Exception {
		navigateMobileTab("My Files");
		wait_time(2);
		MyFilesPage mf = new MyFilesPage(driver);
		if("My Files".equals(mf.titleMyFiles().getText())){
			log.info("My Files Page successfully opened");
		}
		else
			log.error("My Files Page is not opened");
		for(WebElement e: mf.textMedia())
		{
			scrollIntoView(e);
		    log.info("Redom su ispisana sortirana imena media " +e.getText()); 
	}
		log.info("-----------------------------------------------------------------");
	}
		
		@Test(priority=2)
		public void sortDateFunctionality() throws Exception {
			MyFilesPage mf = new MyFilesPage(driver);
			jsClick(mf.sortName(), driver);
			wait_time(1);
			for(WebElement e: mf.textMedia())
			{
				scrollIntoView(e);
			    log.info("Redom su ispisana sortirana imena media po date-u " +e.getText());   
		}
			 log.info("-----------------------------------------------------------------");
	}
		
		@Test(priority=3)
		public void sortSizeFunctionality() throws Exception {
			MyFilesPage mf = new MyFilesPage(driver);
			jsClick(mf.sortDate(),driver);
			wait_time(1);
			List<String> names = new ArrayList<String>();
			List<String> sizes = new ArrayList<String>();
			for(WebElement e: mf.textMedia()) {
				scrollIntoView(e);
				names.add(e.getText());
			}
			for(WebElement e1: mf.sizeMedia()) {
				scrollIntoView(e1);
				sizes.add(e1.getText());
			}
			    for(int i=0; i<mf.mediaBody().size(); i++) {
			    log.info("Media " + names.get(i) + " and size is  " + sizes.get(i));}
			    log.info("***********************************************************************");
		}
			

	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}
}