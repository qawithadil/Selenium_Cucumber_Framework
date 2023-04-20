package genericLib;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class WebDriverCommonLib {
	
	public WebDriverCommonLib(WebDriver driver) {
		this.driver=driver;
	}

	public static WebDriver driver = Driver.driver;
	public static WebDriverCommonLib wdm = new WebDriverCommonLib(driver);
	public static Actions act = null;

	public static void waitForPageLoad() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.globalWait));
	}

	public static void pageMaximize() {
		driver.manage().window().maximize();
	}

	public static void closeBrowser() {

		driver.close();
	}

	public static void quitBrowser() {
		driver.quit();
	}

	public static void pageRefresh() {
		driver.navigate().refresh();
	}

	public static void getScreenshot() throws IOException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");

		Date date = new Date();

		String fileName = Constants.screenshot_file+"error"+ formatter.format(date)+".png";

		// convert webdriver object to takescreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs to create image file

		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(fileName);
		
		// copy file at destinations
		
		FileUtils.copyFile(srcFile, DestFile);
		
		

	}

}
