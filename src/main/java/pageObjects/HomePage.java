package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

		public WebDriver driver;
		By pypLogo = By.cssSelector(".logo");
		By avatar = By.cssSelector("button[type=\"button\"] > div");
		By myProfile = By.cssSelector("div.btn-group.header-dropdown.account-dropdown.ng-star-inserted > ul > li:nth-child(1) > span");
		By logout = By.cssSelector("li:nth-child(3) > span");
		By logInToPypText = By.cssSelector("form > h1");
		
		public HomePage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
		}

		public WebElement pypLogo() {
			return driver.findElement(pypLogo);
		}
		public WebElement avatar() {
			return driver.findElement(avatar);
		}
		public WebElement myProfile() {
			return driver.findElement(myProfile);
		}
		public WebElement logout() {
			return driver.findElement(logout);
		}
		public WebElement logInToPypText() {
			return driver.findElement(logInToPypText);
		}
}
