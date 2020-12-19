package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

		public WebDriver driver;
		By signUp = By.cssSelector("div > div > div > a");
		By email = By.id("email");
		By password = By.id("password");
		By loginButton = By.cssSelector("div.col-6.pl-0 > button[type=\"submit\"]");
		By forgotPassword = By.cssSelector("div.col-6.pr-0.text-right.align-self-center > a");
		By emailValidation = By.cssSelector("div:nth-child(4) > div > span");
		By passwordValidation = By.cssSelector("div.input-group.form-group.form-group-lg > div.invalid-feedback.ng-star-inserted > span");
		By unathorizedMessage = By.cssSelector("form > div.alert.alert-danger.ng-star-inserted");
		
		public LoginPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
		}

		public WebElement signUp() {
			return driver.findElement(signUp);
		}
		public WebElement email() {
			return driver.findElement(email);
		}
		public WebElement password() {
			return driver.findElement(password);
		}
		public WebElement loginButton() {
			return driver.findElement(loginButton);
		}
		public WebElement forgotPassword() {
			return driver.findElement(forgotPassword);
		}
		public WebElement emailValidation() {
			return driver.findElement(emailValidation);
		}
		public WebElement passwordValidation() {
			return driver.findElement(passwordValidation);
		}
		public WebElement unathorizedMessage() {
			return driver.findElement(unathorizedMessage);
		}
}
