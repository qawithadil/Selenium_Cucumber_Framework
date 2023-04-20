package dummyTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import genericLib.Constants;
import genericLib.Driver;
import genericLib.WebDriverCommonLib;

public class BrowserCall {
	public static WebDriver driver;
	

	public static void main(String[] args) throws IOException {

		System.out.println(" **** Browser Running Start ***");
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://google.com");
//        driver.close();
//        System.out.println("*** Browser Running End ***");
		driver = Driver.getBrowser();
		driver.get(Constants.baseURL);
		WebDriverCommonLib.waitForPageLoad();
		WebDriverCommonLib.pageMaximize();
		WebDriverCommonLib.closeBrowser();

	}

}
