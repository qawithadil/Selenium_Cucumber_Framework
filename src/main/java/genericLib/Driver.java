package genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver implements Constants {
	public static WebDriver driver;
	
	/*
	 * This method is used to invoke the browser and it returns the driver
	 * @return driver
	 */

	public static WebDriver getBrowser() {

		if (Constants.browser.equalsIgnoreCase("chrome")) {

			/*
			 * Chrome Browser Setup
			 */

			System.setProperty("webdriver.chrome.driver", Constants.chrome_path);
			driver = new ChromeDriver();
		} else if (Constants.browser.equalsIgnoreCase("firefox")) {

			/*
			 * Firefox Browser Setup
			 */

			System.setProperty("webdriver.gecko.driver", Constants.firefox_path);
			driver = new FirefoxDriver();

		}

		else if (Constants.browser.equalsIgnoreCase("edge")) {
			
			/*
			 * Edge  Browser Setup
			 */

			System.setProperty("webdriver.edge.driver", Constants.edge_path);
			driver=new EdgeDriver();
		} else {
			System.out.println(" ** Sorry, Please configure your browser  **");
		}

		return driver;

	}

}
