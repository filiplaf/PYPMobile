package pyp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import resources.Base;


public class Login extends Base{
	public static Logger log = LogManager.getLogger(Login.class.getName());
	public String email = "filip@mailinator.com";
	public String password = "f12345";
	
	@Test
	public void login() throws IOException {
	driver = initializeDriver();
	driver.get("https://pyp.stage.ggstud.io/");
	LoginPage lp = new LoginPage(driver);
	HomePage hp = new HomePage(driver);
	lp.email().sendKeys(email);
	lp.password().sendKeys(password);
	jsClick(lp.loginButton(), driver);
		try {
			hp.avatar().isDisplayed(); 
				log.info("Korisnik sa emailom "+email+ " je uspesno ulogovan!" );
		} catch (Exception e) {
			log.error("Korisnik nije ulogovan");
		}
	}
	 
}