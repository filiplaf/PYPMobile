package pyp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Base;


public class Login_logout extends Base{
	public static Logger log = LogManager.getLogger(Login_logout.class.getName());
	
	@Test
	public void loginAndLogout() throws IOException {
	driver = initializeDriver();
	driver.get("https://pyp.stage.ggstud.io/");
	LoginPage lp = new LoginPage(driver);
	HomePage hp = new HomePage(driver);
	Login login = new Login();
	Actions action = new Actions(driver);
	lp.email().sendKeys(login.email);
	lp.password().sendKeys(login.password);
	lp.loginButton().click();
		try {
			hp.avatar().isDisplayed(); 
				log.info("Korisnik sa emailom "+login.email+ " je uspesno ulogovan!" );
		} catch (Exception e) {
			log.error("Korisnik nije ulogovan");
		}
		action.moveToElement(hp.avatar()).build().perform();
		hp.logout().click();
		if("Log in to Pyp".equals(hp.logInToPypText().getText())) {
			log.info("Successfully logged out and login page is displayed");
		}
		else
			log.error("Something went wrong");
		log.info("*********************************************************************************************");
	}
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}
}