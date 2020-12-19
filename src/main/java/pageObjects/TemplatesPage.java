package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TemplatesPage {

		public WebDriver driver;
		By titleSignUp = By.cssSelector("form > h1");
		By video = By.id("video-1");
		By video1 = By.id("video-11");
		By searchBar = By.cssSelector("div.search.m-auto.col-xxl-6.col-xl-5.col-lg-5.p-0 > div > input");
		By videoBody = By.xpath("//*[contains(@class, 'col-xxl-4')]");
		By searchMessage = By.cssSelector("div > h3");
		By noResultMessage = By.cssSelector("div > h2");
		By categories = By.cssSelector("div.category > ng-select > div");
		By categoryOption = By.cssSelector("div.ng-option.ng-star-inserted.ng-option");
		By clearFilter = By.cssSelector("div > span.clear-all");
		By threeDotsMenu = By.cssSelector("div.pl-0 > button[type=\"button\"]");
		By duration = By.cssSelector("div#collapseFilters div:nth-child(1) > ng-select > div > div > div.ng-input");
		By durationOption = By.cssSelector("div#collapseFilters div.ng-option.ng-star-inserted.ng-option");
		By numberOfPhotos = By.cssSelector("div#collapseFilters div:nth-child(2) > ng-select > div > div > div.ng-input");
		By numberOfPhotosOption = By.cssSelector("div#collapseFilters div.ng-option");
		By mood = By.cssSelector("div#collapseFilters div:nth-child(3) > ng-select > div > div > div.ng-input");
		By moodOption = By.cssSelector("div#collapseFilters div.ng-option.ng-star-inserted.ng-option");
		By speeds = By.cssSelector("div#collapseFilters div:nth-child(4) > ng-select > div > div > div.ng-input");
		By speedsOption = By.cssSelector("div#collapseFilters div.ng-option.ng-star-inserted");
		By favoriteMark = By.cssSelector("span.favorite");
		
		public TemplatesPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
		}

		public WebElement titleSignUp() {
			return driver.findElement(titleSignUp);
		}
		public WebElement video() {
			return driver.findElement(video);
		}
		public WebElement video1() {
			return driver.findElement(video1);
		}
		public WebElement searchBar() {
			return driver.findElement(searchBar);
		}
		public List<WebElement> videoBody() {
			return driver.findElements(videoBody);
		}
		public WebElement searchMessage() {
			return driver.findElement(searchMessage);
		}
		public WebElement noResultMessage() {
			return driver.findElement(noResultMessage);
		}
		public WebElement categories() {
			return driver.findElement(categories);
		}
		public List<WebElement> categoryOption() {
			return driver.findElements(categoryOption);
		}
		public WebElement clearFilter() {
			return driver.findElement(clearFilter);
		}
		public WebElement threeDotsMenu() {
			return driver.findElement(threeDotsMenu);
		}
		public WebElement duration() {
			return driver.findElement(duration);
		}
		public List<WebElement> durationOption() {
			return driver.findElements(durationOption);
		}
		public WebElement numberOfPhotos() {
			return driver.findElement(numberOfPhotos);
		}
		public List<WebElement> numberOfPhotosOption() {
			return driver.findElements(numberOfPhotosOption);
		}
		public WebElement mood() {
			return driver.findElement(mood);
		}
		public List<WebElement> moodOption() {
			return driver.findElements(moodOption);
		}
		public WebElement speeds() {
			return driver.findElement(speeds);
		}
		public List<WebElement> speedsOption() {
			return driver.findElements(speedsOption);
		}
		public List<WebElement> favoriteMark() {
			return driver.findElements(favoriteMark);
		}
				
}
