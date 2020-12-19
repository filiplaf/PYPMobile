package pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyFavoritesPage {

		public WebDriver driver;
		By favoritesTitle = By.cssSelector("div.col>h1");
		By videoBody = By.xpath("//*[contains(@class, 'col-xxl-4')]");
		By deleteAllButton = By.cssSelector("div.pl-0 > button[type=\"button\"]");
		By deleteButton = By.cssSelector("div > button.btn.btn-primary");
		By exploreTemplateButton = By.cssSelector("div.no-favorites.ng-star-inserted > button");
		By searchBar = By.cssSelector("div > input");
		By searchResult = By.cssSelector("div.row.searched-string.ng-star-inserted > div > h3");
		By video = By.id("video-1");
		
		public MyFavoritesPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
		}

		public WebElement favoritesTitle() {
			return driver.findElement(favoritesTitle);
		}
		public List<WebElement> videoBody() {
			return driver.findElements(videoBody);
		}
		public WebElement deleteAllButton() {
			return driver.findElement(deleteAllButton);
		}
		public WebElement deleteButton() {
			return driver.findElement(deleteButton);
		}
		public WebElement exploreTemplateButton() {
			return driver.findElement(exploreTemplateButton);
		}
		public WebElement searchBar() {
			return driver.findElement(searchBar);
		}
		public WebElement searchResult() {
			return driver.findElement(searchResult);
		}
		public WebElement video() {
			return driver.findElement(video);
		}
}
