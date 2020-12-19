package pyp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import resources.Base;

public class LoginPageLinksCheck extends Base{
	public static Logger log = LogManager.getLogger(LoginPageLinksCheck.class.getName());
	
	@Test
	public void linksCheck() throws IOException {
		driver = initializeDriver();
		driver.get("https://pyp.stage.ggstud.io");
	    //get all links into a list
		//get the URL from list, then check if the URL response is 200
		List<WebElement> elementList = driver.findElements(By.tagName("a"));
		log.info("Total number of WebPage links present on webpage is " +elementList.size());
		List<WebElement> imageList = driver.findElements(By.tagName("img"));
		log.info("Total number of Image links present on webpage is " +imageList.size());
		//Total number of links present
		elementList.addAll(imageList);
		
		HttpURLConnection con = null;
		for(WebElement element:elementList) {
			String url = element.getAttribute("href");
			if(url!=null&&!url.contains("javascript")) {
				con =(HttpURLConnection)(new URL(url)).openConnection();
				con.connect();
				con.setConnectTimeout(3000);
				int respCode = con.getResponseCode();
				log.info("Connection Status for URL " +url+ " is " +respCode);
				if(respCode==500) {
					log.error("BROKEN LINK ****** " + url);
				}
			}
		}
		con.disconnect();
		log.info("*********************************************************************************************");
	}
	
	@AfterTest(alwaysRun = true)
	public void teardown() {
		driver.close();
		driver.quit();
	}
	
}
