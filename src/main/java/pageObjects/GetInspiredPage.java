package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetInspiredPage {

		public WebDriver driver;
		By videoBody = By.xpath("//*[contains(@class, 'masonry-item')]");
		By searchBar = By.cssSelector("div.search.m-auto.col-xxl-6.col-xl-5.col-lg-5.p-0 > div > input");
		By clearSearchBar = By.cssSelector(".remove.ng-star-inserted");
		By results = By.cssSelector("div > h3");
		By loadMoreTemplates = By.cssSelector("div.container-fluid.cards > div > button");
		By noResultsFound = By.cssSelector("div.container-fluid.cards > div:nth-child(3) > div");
		By threeDotsMenu = By.cssSelector("div.pl-0 > button[type=\"button\"]");
		By duration = By.cssSelector("div#collapseFilters div:nth-child(1) > ng-select > div > div > div.ng-input");
		By durationOption = By.cssSelector("div#collapseFilters div.ng-option.ng-star-inserted.ng-option");
		By clearAll = By.cssSelector("div > span.clear-all");
		By numberOfPhotos = By.cssSelector("div#collapseFilters div:nth-child(2) > ng-select > div > div > div.ng-input");
		By numberOfPhotosOption = By.cssSelector("div#collapseFilters div.ng-option");
		By mood = By.cssSelector("div#collapseFilters div:nth-child(3) > ng-select > div > div > div.ng-input");
		By moodOption = By.cssSelector("div#collapseFilters div.ng-option.ng-star-inserted.ng-option");
		By speeds = By.cssSelector("div#collapseFilters div:nth-child(4) > ng-select > div > div > div.ng-input");
		By speedsOption = By.cssSelector("div#collapseFilters div.ng-option.ng-star-inserted");
		By NewPopular = By.cssSelector("div.category > ng-select > div");
		By PopularOption = By.cssSelector("ng-dropdown-panel > div>div>div");
				
		public GetInspiredPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
		}

		public List<WebElement> videoBody() {
			return driver.findElements(videoBody);
		}
		public WebElement searchBar() {
			return driver.findElement(searchBar);
		}
		public WebElement clearSearchBar() {
			return driver.findElement(clearSearchBar);
		}
		public WebElement results() {
			return driver.findElement(results);
		}
		public WebElement loadMoreTemplates() {
			return driver.findElement(loadMoreTemplates);
		}
		public WebElement noResultsFound() {
			return driver.findElement(noResultsFound);
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
		public WebElement clearAll() {
			return driver.findElement(clearAll);
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
		public WebElement NewPopular() {
			return driver.findElement(NewPopular);
		}
		public List<WebElement> PopularOption() {
			return driver.findElements(PopularOption);
		}
}
