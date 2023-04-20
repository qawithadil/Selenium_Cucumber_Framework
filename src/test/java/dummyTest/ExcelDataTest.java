package dummyTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import genericLib.Constants;
import genericLib.Driver;
import genericLib.Excellib;
import genericLib.WebDriverCommonLib;

public class ExcelDataTest {

	public static WebDriver driver;

	public static void main(String[] args) throws IOException {

		System.out.println(" **** Browser Running Start ***");
		driver = Driver.getBrowser();
		driver.get(Constants.baseURL);
		WebDriverCommonLib.waitForPageLoad();
		WebDriverCommonLib.pageMaximize();
		String cell_value = Excellib.readSingleCellData("Sheet1", 5, 1);
		System.out.println("Cell Value=" + cell_value);
		//Excellib.setSingleCellData("Sheet1", 5, 0, "test5");
	//	Excellib.getSignleColumnData("Sheet1", 1);
	//	Excellib.setSingleColumnData("Sheet1", 5, 2);
		WebDriverCommonLib.closeBrowser();
		driver.close();

	}

}
