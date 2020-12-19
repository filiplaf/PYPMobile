package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {

		public WebDriver driver;
		By forgotPasswordText = By.cssSelector("form > h1");
		By email = By.cssSelector("div.form-group.form-group-lg > input");
		By sendResetInstructionButton = By.cssSelector("div > button[type=\"submit\"]");
		By instructionSent = By.cssSelector("div > h1");
		By resetMessage = By.cssSelector("div.form-group-lg > p");
		By emailValidation = By.cssSelector("div > span");
		By newPassword = By.cssSelector("div.input-group.form-group > input");
		By confirmNewPassword = By.cssSelector("div.input-group.form-group-lg > input");
		By newPasswordValidation = By.cssSelector("div.input-group.form-group > div.invalid-feedback.ng-star-inserted > span");
		By confirmPasswordValidation = By.cssSelector("div.input-group.form-group-lg > div.invalid-feedback.ng-star-inserted > span");
		By resetPasswordButton = By.cssSelector("div > button[type=\"submit\"]");
		By invalidDataMessage = By.cssSelector("form > div.alert.alert-danger.ng-star-inserted");
		
		public ForgotPasswordPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
		}

		public WebElement forgotPasswordText() {
			return driver.findElement(forgotPasswordText);
		}
		public WebElement email() {
			return driver.findElement(email);
		}
		public WebElement sendResetInstructionButton() {
			return driver.findElement(sendResetInstructionButton);
		}
		public WebElement instructionSent() {
			return driver.findElement(instructionSent);
		}
		public WebElement resetMessage() {
			return driver.findElement(resetMessage);
		}
		public WebElement emailValidation() {
			return driver.findElement(emailValidation);
		}
		public WebElement newPassword() {
			return driver.findElement(newPassword);
		}
		public WebElement confirmNewPassword() {
			return driver.findElement(confirmNewPassword);
		}
		public WebElement newPasswordValidation() {
			return driver.findElement(newPasswordValidation);
		}
		public WebElement confirmPasswordValidation() {
			return driver.findElement(confirmPasswordValidation);
		}
		public WebElement resetPasswordButton() {
			return driver.findElement(resetPasswordButton);
		}
		public WebElement invalidDataMessage() {
			return driver.findElement(invalidDataMessage);
		}
}
