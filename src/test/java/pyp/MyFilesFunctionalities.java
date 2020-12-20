package pyp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.MyFilesPage;
import resources.Base;


public class MyFilesFunctionalities extends Base{
	public static Logger log = LogManager.getLogger(MyFilesFunctionalities.class.getName());
	private String renameText = "aaa.png";
	private String renameText1 = "bbb.png";
	
	@Test(priority=1)
	public void viewMediaOption() throws Exception {
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		navigateTab("My Files");
		wait_time(2);
		MyFilesPage mf = new MyFilesPage(driver);
		if("My Files".equals(mf.titleMyFiles().getText())){
			log.info("My Files Page successfully opened");
		}
		else
			log.error("My Files Page is not opened");
		mf.mediaBody().get(0).click();
		mf.threeDotsOnMedia().click();
		mf.threeDotsMenuOption().get(0).click();
		wait_time(1);
		log.info("Media " +mf.mediaName().getText()+ " je u view modu");
		captureScreen(name);
		mf.closeButton().click();
		mf.viewIcon().click();
		log.info("Media " +mf.mediaName().getText()+ " je u view modu");
		mf.closeButton().click();
		mf.mediaBody().get(0).click();
	}
	
	@Test(priority=2)
	public void renameMediaOption() throws Exception {
		MyFilesPage mf = new MyFilesPage(driver);
		mf.mediaBody().get(0).click();
		mf.threeDotsOnMedia().click();
		mf.threeDotsMenuOption().get(1).click();
		wait_time(1);
		scrollIntoView((mf.textMedia().get(0)));
		log.info("Media sa imenom " +mf.textMedia().get(0).getText()+ " je u rename modu");
		mf.renameField().clear();
		mf.renameField().sendKeys(renameText);
		mf.saveRenameButton().click();
		wait_time(2);
		log.info("Ime promenjenog media je " +mf.textMedia().get(0).getText());
		jsClick(mf.renameIcon(), driver);
		scrollIntoView(mf.renameField());
		mf.renameField().sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		mf.renameField().sendKeys(renameText1);
		mf.saveRenameButton().click();
		wait_time(1);
		scrollIntoView((mf.textMedia().get(0)));
		log.info("Ime promenjenog media je " +mf.textMedia().get(0).getText());
		jsClick(mf.mediaBody().get(0), driver);
	}
	
	@Test(priority=3)
	public void downloadMediaOption() throws Exception {
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		MyFilesPage mf = new MyFilesPage(driver);
		scrollIntoView((mf.mediaBody().get(0)));
		jsClick(mf.mediaBody().get(0), driver);
		jsClick(mf.threeDotsOnMedia(), driver);
		jsClick(mf.threeDotsMenuOption().get(2), driver);
		scrollIntoView(mf.downloadIcon());
		mf.downloadIcon().click();
		jsClick(mf.mediaBody().get(0),driver);
		captureFullScreen(name);
	}
	
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}
}
