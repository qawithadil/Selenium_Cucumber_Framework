package testCases;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLib.Constants;
import genericLib.Driver;
import genericLib.Excellib;
import genericLib.WebDriverCommonLib;
import pageObjectRepoLib.Login;

@Listeners(genericLib.TestListeners.class)

public class SC001_Login {

	public static WebDriver driver;
	public static Login LG;

	@BeforeClass // (groups = {"smoke"})
	public void setUp() {
		driver = Driver.getBrowser();
		driver.get(Constants.baseURL);
		WebDriverCommonLib.pageMaximize();
		WebDriverCommonLib.waitForPageLoad();
		LG = PageFactory.initElements(driver, Login.class);
	}

	@AfterClass
	public void close() {
		WebDriverCommonLib.quitBrowser();
	}

	@Test
	public void TC001() throws IOException {
		/*
		 * TC001: Verify user should logged In into the App by correct userName and
		 * correct password
		 */

		LG.loginToApp(Excellib.readSingleCellData("Sheet1", 5, 0), Excellib.readSingleCellData("Sheet1", 5, 1));
		LG.clickLogin();
		String expected_result = "Hello " + Excellib.readSingleCellData("Sheet1", 5, 0) + ","
				+ " let's complete the test form:";
		String actual_result = LG.welcomeMsg();
		Assert.assertEquals(actual_result, expected_result);
		LG.logoutApp();

	}

	@Test
	public void TC002() throws IOException {
		/*
		 * TC002: Verify correct userName and wrong password
		 */
		LG.loginToApp(Excellib.readSingleCellData("Sheet1", 1, 0), Excellib.readSingleCellData("Sheet1", 1, 1));
		String extected_result = "Password is invalid";
		String actual_result = LG.errorMsg();
		Assert.assertEquals(actual_result, extected_result);

	}

	@Test
	public void TC003() throws IOException {

		/*
		 * TC003: Verify wrong userName and correct password
		 */
		WebDriverCommonLib.pageRefresh();
		LG.loginToApp(Excellib.readSingleCellData("Sheet1", 2, 0), Excellib.readSingleCellData("Sheet1", 2, 1));
		String extected_result = "Password is invalid";
		String actual_result = LG.errorMsg();
		Assert.assertEquals(actual_result, extected_result);

	}

	@Test
	public void TC004() throws IOException {
		/*
		 * TC004: Verify wrong userName and wrong password
		 */
		WebDriverCommonLib.pageRefresh();
		LG.loginToApp(Excellib.readSingleCellData("Sheet1", 3, 0), Excellib.readSingleCellData("Sheet1", 3, 1));
		String extected_result = "Password is invalid";
		String actual_result = LG.errorMsg();
		Assert.assertEquals(actual_result, extected_result);

	}
	
	
	@Test
	public void TC005() {
		LG.errorWeb();
		
	}

	/*
	 * Calling DataProvider
	 */
	@Test(dataProvider = "Authentication", groups = { "smoke" })
	public void testLogin(String userName, String password) throws IOException {
		System.out.println("Under data provider function....");
		System.out.println("userName=" + userName + "password=" + password);
		LG.loginToApp(userName, password);
	}

	@DataProvider(name = "Authentication")
	public static Object[][] credentials() throws IOException {
		Object[][] loginObjArray = Excellib.getLoginCreds(Constants.login_file, Constants.sheet_name);
		return loginObjArray;

	}

}
