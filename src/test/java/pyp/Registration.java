package pyp;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import resources.Base;

public class Registration extends Base {
public static Logger log = LogManager.getLogger(Registration.class.getName());
private String name = "Filip";
private String email = randomString(5)+"@yopmail.com";
private String password = "f12345";
private String confirmPassword = password;
	
	
	@Test
	public void homepage() throws IOException {
	driver = initializeDriver();
	driver.get("https://pyp.stage.ggstud.io/");
	}
	
	@Test
	public void registration() {
		LoginPage lp = new LoginPage(driver);
		RegistrationPage rp = new RegistrationPage(driver);
		HomePage hp = new HomePage(driver);
		lp.signUp().click();
		if("Sign up to Pyp".equals(rp.titleSignUp().getText())){
			log.info("SignUp Page successfully opened");
		}
		else
			log.error("SignUp Page is not opened");
		//Enter data for registration
		rp.name().sendKeys(name);
		rp.email().sendKeys(email);
		rp.password().sendKeys(password);
		rp.confirmPassword().sendKeys(confirmPassword);
		rp.createAccount().click();
		wait_time(2);
		if(hp.pypLogo().isDisplayed()) {
			log.info("Korisnik "+name+" sa emailom "+email+" je uspesno registrovan!");
		}
		else 
			{log.error("Greska prilikom registracije!");}
		log.info("*********************************************************************************************");	
	}
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}
		
}
