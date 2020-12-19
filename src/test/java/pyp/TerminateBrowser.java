package pyp;

import java.io.IOException;
import org.testng.annotations.Test;
import resources.Base;


public class TerminateBrowser extends Base {


	@Test(alwaysRun = true)
	public void teardown() throws IOException, InterruptedException {
			driver.close();
			driver.quit();
		}
	}
