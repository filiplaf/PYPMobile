package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

		public WebDriver driver;
		By titleSignUp = By.cssSelector("form > h1");
		By name = By.cssSelector("div:nth-child(4) > input");
		By email = By.cssSelector("div:nth-child(5) > input");
		By password = By.cssSelector("div:nth-child(6) > input");
		By confirmPassword = By.cssSelector("div:nth-child(7) > input");
		By createAccount = By.cssSelector("div > button[type=\"submit\"]");
		By nameValidation = By.cssSelector("div:nth-child(4) > div > span");
		By emailValidation = By.cssSelector("div:nth-child(5) > div > span");
		By emailExistValidation = By.cssSelector("div:nth-child(6) > div > span");
		By passwordValidation = By.cssSelector("div:nth-child(6) > div.invalid-feedback.ng-star-inserted > span");
		By confirmPasswordValidation = By.cssSelector("div:nth-child(7) > div.invalid-feedback.ng-star-inserted > span");
		
		public RegistrationPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
		}

		public WebElement titleSignUp() {
			return driver.findElement(titleSignUp);
		}
		public WebElement name() {
			return driver.findElement(name);
		}
		public WebElement email() {
			return driver.findElement(email);
		}
		public WebElement password() {
			return driver.findElement(password);
		}
		public WebElement confirmPassword() {
			return driver.findElement(confirmPassword);
		}
		public WebElement createAccount() {
			return driver.findElement(createAccount);
		}
		public WebElement nameValidation() {
			return driver.findElement(nameValidation);
		}
		public WebElement emailValidation() {
			return driver.findElement(emailValidation);
		}
		public WebElement emailExistValidation() {
			return driver.findElement(emailExistValidation);
		}
		public WebElement passwordValidation() {
			return driver.findElement(passwordValidation);
		}
		public WebElement confirmPasswordValidation() {
			return driver.findElement(confirmPasswordValidation);
		}
}
