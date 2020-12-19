package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyProfilePage {

		public WebDriver driver;
		By titleMyProfile = By.cssSelector("div > div > div > h1");
		By name = By.id("name");
		By saveChanges = By.xpath("/html/body/app-root/perfect-scrollbar/div/div[1]/app-my-profile/div/div/div/tabset/div/tab[1]/app-account/div[1]/form/div[3]/button");
		By uploadPicture = By.id("avatarInput");
		By messageAlert = By.cssSelector("app-alert > div > div");
		By cropImageTest = By.cssSelector("app-image-cropper > div > div > h1");
		By doneCroping = By.cssSelector("div > div.buttons > button.btn.btn-primary");
		By passwordTab = By.cssSelector("li:nth-child(2) > a");
		By oldPassword = By.id("password");
		By newPassword = By.id("newPassword");
		By confirmNewPassword = By.id("confirmNewPassword");
		By changesPasswordButton = By.cssSelector("app-password > form > button");
		By oldPasswordValidation = By.cssSelector("div:nth-child(1) > div > span");
		By newPasswordValidation = By.cssSelector("div:nth-child(2) > div > span");
		By confirmNewPasswordValidation = By.cssSelector("div:nth-child(3) > div > span");
		By emailNotificationTab = By.cssSelector("li:nth-child(4) > a");
		By emailWhenPuchase = By.cssSelector("form > section:nth-child(1) > div.body > label:nth-child(1) > span");
		By emailWhenVideoDoneRendering = By.cssSelector("section:nth-child(1) > div.body > label:nth-child(2) > span");
		By subscribeLatestNews = By.cssSelector("section.last > div.body > label:nth-child(1) > span");
		By subscribeSpecialOffers= By.cssSelector("section.last > div.body > label:nth-child(2) > span");
		By updateEnailNotificationButton = By.cssSelector("form > button[type=\"submit\"]");
		By deleteAccountButton = By.cssSelector("div.buttons > div > a");
		By deleteAccountPopUpMessage = By.cssSelector("div > h2");
		By deleteButton = By.cssSelector("div.modal.fade.in.show > div > div > div > button.btn.btn-light");
		By deleteAvatarPictureButton = By.cssSelector("div.ng-star-inserted > div > button");
		
		public MyProfilePage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver = driver;
		}
		public WebElement titleMyProfile() {
			return driver.findElement(titleMyProfile);
		}
		public WebElement name() {
			return driver.findElement(name);
		}
		public WebElement saveChanges() {
			return driver.findElement(saveChanges);
		}
		public WebElement uploadPicture() {
			return driver.findElement(uploadPicture);
		}
		public WebElement messageAlert() {
			return driver.findElement(messageAlert);
		}
		public WebElement cropImageTest() {
			return driver.findElement(cropImageTest);
		}
		public WebElement doneCroping() {
			return driver.findElement(doneCroping);
		}
		public WebElement passwordTab() {
			return driver.findElement(passwordTab);
		}
		public WebElement oldPassword() {
			return driver.findElement(oldPassword);
		}
		public WebElement newPassword() {
			return driver.findElement(newPassword);
		}
		public WebElement confirmNewPassword() {
			return driver.findElement(confirmNewPassword);
		}
		public WebElement changesPasswordButton() {
			return driver.findElement(changesPasswordButton);
		}
		public WebElement oldPasswordValidation() {
			return driver.findElement(oldPasswordValidation);
		}
		public WebElement newPasswordValidation() {
			return driver.findElement(newPasswordValidation);
		}
		public WebElement confirmNewPasswordValidation() {
			return driver.findElement(confirmNewPasswordValidation);
		}
		public WebElement emailNotificationTab() {
			return driver.findElement(emailNotificationTab);
		}
		public WebElement emailWhenPuchase() {
			return driver.findElement(emailWhenPuchase);
		}
		public WebElement emailWhenVideoDoneRendering() {
			return driver.findElement(emailWhenVideoDoneRendering);
		}
		public WebElement subscribeLatestNews() {
			return driver.findElement(subscribeLatestNews);
		}
		public WebElement subscribeSpecialOffers() {
			return driver.findElement(subscribeSpecialOffers);
		}
		public WebElement updateEnailNotificationButton() {
			return driver.findElement(updateEnailNotificationButton);
		}
		public WebElement deleteAccountButton() {
			return driver.findElement(deleteAccountButton);
		}
		public WebElement deleteAccountPopUpMessage() {
			return driver.findElement(deleteAccountPopUpMessage);
		}
		public WebElement deleteButton() {
			return driver.findElement(deleteButton);
		}
		public WebElement deleteAvatarPictureButton() {
			return driver.findElement(deleteAvatarPictureButton);
		}
		
}
