package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyFilesPage {

		public WebDriver driver;
		By titleMyFiles = By.cssSelector("div:nth-child(1) > h1");
		By titleNoMediaUpload = By.cssSelector("div.no-uploaded-files.ng-star-inserted > h2");
		By searchBar = By.cssSelector("div.col-auto.right > div > input");
		By searchBarClear = By.cssSelector(".search>span");
		By uploadFilesButton = By.cssSelector("div.no-uploaded-files.ng-star-inserted > button");
		By addFilesButton = By.cssSelector("div.col-auto.right > button[type=\"button\"]");
		By uploadOption = By.cssSelector("div.col-xl-2.col-lg-3.col-md-3.sidebar-nav>ul>li");
		By uploadMedia = By.id("file");
		By uploadFilesButton1 = By.cssSelector("div.body.ng-star-inserted > div > div > label > div");
		By addFilesButton1 = By.cssSelector("div > button.btn.btn-primary.ng-star-inserted");
		By mediaBody = By.cssSelector("div.image-container");
		By storageInfo = By.cssSelector("li.nav-item.ng-star-inserted.storage > a");
		By allFilesTab = By.cssSelector("li:nth-child(1) > a");
		By imageTab = By.cssSelector("li:nth-child(2) > a");
		By musicTab = By.cssSelector("li:nth-child(3) > a");
		By deleteIcon = By.cssSelector(".options.ng-star-inserted>li:nth-child(4)");
		By viewIcon = By.cssSelector(".options.ng-star-inserted>li:nth-child(1)");
		By renameIcon= By.cssSelector("div.col.d-flex.justify-content-end>ul>li.ng-star-inserted");
		By downloadIcon = By.cssSelector(".options.ng-star-inserted>li:nth-child(3)");
		By deleteButton = By.cssSelector("app-delete-file > div > div > div > div > button.btn.btn-primary");
		By threeDotsOnMedia = By.cssSelector("div.col-xxl-2.col-20.col-lg-3.col-md-3.file-card.ng-star-inserted.selected > div > app-action-dropdown > div > button#button-basic");
		By threeDotsMenuOption = By.cssSelector(".dropdown-menu.show.ng-star-inserted>li");
		By mediaName = By.cssSelector(".item.active>div>div>div>div>h2");
		By closeButton = By.cssSelector(".close");
		By renameField = By.cssSelector("app-rename-file > div > div > div > input");
		By saveRenameButton = By.cssSelector("div > div > div > div > button.btn.btn-primary");
		By textMedia = By.cssSelector("div.col-xxl-2.col-20.col-lg-3.col-md-3.file-card.ng-star-inserted>p");
		By sizeMedia = By.cssSelector("div.col-xxl-2.col-20.col-lg-3.col-md-3.file-card.ng-star-inserted>span");
		By sortName = By.cssSelector("div.row.align-content-between.sub-header > div:nth-child(1) > ul > li:nth-child(2) > span");
		By sortDate = By.cssSelector("div.row.align-content-between.sub-header > div:nth-child(1) > ul > li:nth-child(3) > span");
		By sortSize = By.cssSelector("div.row.align-content-between.sub-header > div:nth-child(1) > ul > li:nth-child(4) > span");
		By stockMedia = By.cssSelector("div.ps-content>ul>li");
		By loadMoreFiles = By.cssSelector("div.load-more-box.ng-star-inserted > button");
		
		public MyFilesPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
		}

		public WebElement titleMyFiles() {
			return driver.findElement(titleMyFiles);
		}
		public WebElement titleNoMediaUpload() {
			return driver.findElement(titleNoMediaUpload);
		}
		public WebElement searchBar() {
			return driver.findElement(searchBar);
		}
		public WebElement searchBarClear() {
			return driver.findElement(searchBarClear);
		}
		public List<WebElement> uploadOption() {
			return driver.findElements(uploadOption);
		}
		public WebElement uploadFilesButton() {
			return driver.findElement(uploadFilesButton);
		}
		public WebElement addFilesButton() {
			return driver.findElement(addFilesButton);
		}
		public WebElement uploadMedia() {
			return driver.findElement(uploadMedia);
		}
		public WebElement uploadFilesButton1() {
			return driver.findElement(uploadFilesButton1);
		}
		public WebElement addFilesButton1() {
			return driver.findElement(addFilesButton1);
		}
		public List<WebElement> mediaBody() {
			return driver.findElements(mediaBody);
		}
		public WebElement storageInfo() {
			return driver.findElement(storageInfo);
		}
		public WebElement allFilesTab() {
			return driver.findElement(allFilesTab);
		}
		public WebElement imageTab() {
			return driver.findElement(imageTab);
		}
		public WebElement musicTab() {
			return driver.findElement(musicTab);
		}
		public WebElement deleteIcon() {
			return driver.findElement(deleteIcon);
		}
		public WebElement viewIcon() {
			return driver.findElement(viewIcon);
		}
		public WebElement renameIcon() {
			return driver.findElement(renameIcon);
		}
		public WebElement downloadIcon() {
			return driver.findElement(downloadIcon);
		}
		public WebElement deleteButton() {
			return driver.findElement(deleteButton);
		}
		public WebElement threeDotsOnMedia() {
			return driver.findElement(threeDotsOnMedia);
		}
		public List<WebElement> threeDotsMenuOption() {
			return driver.findElements(threeDotsMenuOption);
		}
		public WebElement mediaName() {
			return driver.findElement(mediaName);
		}
		public WebElement closeButton() {
			return driver.findElement(closeButton);
		}
		public WebElement renameField() {
			return driver.findElement(renameField);
		}
		public WebElement saveRenameButton() {
			return driver.findElement(saveRenameButton);
		}
		public List<WebElement> textMedia() {
			return driver.findElements(textMedia);
		}
		public List<WebElement> sizeMedia() {
			return driver.findElements(sizeMedia);
		}
		public WebElement sortName() {
			return driver.findElement(sortName);
		}
		public WebElement sortDate() {
			return driver.findElement(sortDate);
		}
		public WebElement sortSize() {
			return driver.findElement(sortSize);
		}
		public List<WebElement> stockMedia() {
			return driver.findElements(stockMedia);
		}
		public WebElement loadMoreFiles() {
			return driver.findElement(loadMoreFiles);
		}
}