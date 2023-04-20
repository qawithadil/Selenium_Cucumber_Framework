//package testCases;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import genericLib.Constants;
//import genericLib.Driver;
//import genericLib.WebDriverCommonLib;
//import webElements.Login;
//
//public class Login_Simple_Java_Run {
//	public static WebDriver driver;
//
//	public static void main(String[] args) throws InterruptedException {
//
//		driver = Driver.getBrowser();
//		driver.get(Constants.baseURL);
//		WebDriverCommonLib.pageMaximize();
//		WebDriverCommonLib.waitForPageLoad();
//
//		Login_Simple_Java_Run LSJR = new Login_Simple_Java_Run();
//
//		LSJR.TC001("Test", "12345");
//		LSJR.TC002("Test1", "123");
//		LSJR.TC003("Test", "12");
//		LSJR.TC004("Test", "11111");
//
//		/*
//		 * Test Cases Executions
//		 */
//
//	}
//
//	/*
//	 * Verify correct userName and correct Password
//	 */
//	public void TC001(String userName, String password) {
//
//		System.out.println("TC001: Verify correct userName and correct Password");
//		WebElement txt_username = driver.findElement(By.id(Login.id_txt_userName));
//		txt_username.sendKeys(userName);
//		WebElement pass = driver.findElement(By.id(Login.id_txt_password));
//		pass.sendKeys(password);
//		driver.findElement(By.id(Login.id_btn_login)).click();
//		WebDriverCommonLib.waitForPageLoad();
//		String welcome_text = driver.findElement(By.id("greetings")).getText();
//		if (welcome_text.equalsIgnoreCase("Hello " + userName + ", let's complete the test form:")) {
//
//			System.out.println("PASS");
//			driver.findElement(By.id(Login.id_btn_logout)).click();
//		} else {
//			System.out.println("FAILED");
//		}
//
//	}
//
//	/*
//	 * Verify correct userName and wrong Password
//	 */
//
//	public void TC002(String userName, String password) {
//
//		System.out.println("TC002: Verify correct userName and wrong Password");
//		WebElement txt_username = driver.findElement(By.id(Login.id_txt_userName));
//		txt_username.sendKeys(userName);
//		WebElement pass = driver.findElement(By.id(Login.id_txt_password));
//		pass.sendKeys(password);
//		driver.findElement(By.id(Login.id_btn_login)).click();
//		WebDriverCommonLib.waitForPageLoad();
//		String error_text = driver.findElement(By.xpath("//small[@id='passwordHelp']/following-sibling::div"))
//				.getText();
//		if (error_text.equalsIgnoreCase("Password is invalid")) {
//
//			System.out.println("PASS");
//
//		} else {
//			System.out.println("FAILED");
//		}
//		driver.navigate().refresh();
//
//	}
//
//	/*
//	 * Verify wrong userName and wrong Password
//	 */
//
//	public void TC003(String userName, String password) throws InterruptedException {
//		System.out.println("TC003: Verify wrong userName and wrong Password");
//		WebElement txt_username = driver.findElement(By.id(Login.id_txt_userName));
//		txt_username.sendKeys(userName);
//		WebElement pass = driver.findElement(By.id(Login.id_txt_password));
//		pass.sendKeys(password);
//		driver.findElement(By.id(Login.id_btn_login)).click();
//		WebDriverCommonLib.waitForPageLoad();
//		String error_text = driver.findElement(By.xpath("//small[@id='passwordHelp']/following-sibling::div"))
//				.getText();
//		if (error_text.equalsIgnoreCase("Password is invalid")) {
//
//			System.out.println("TestCase = Pass");
//
//		} else {
//			System.out.println("TestCase  = Fail");
//		}
//		driver.navigate().refresh();
//
//	}
//
//	/*
//	 * Verify wrong userName and correct Password
//	 */
//
//	public void TC004(String userName, String password) {
//		System.out.println("TC004: Verify wrong userName and correct Password ");
//		WebElement txt_username = driver.findElement(By.id(Login.id_txt_userName));
//		txt_username.sendKeys(userName);
//		WebElement pass = driver.findElement(By.id(Login.id_txt_password));
//		pass.sendKeys(password);
//		driver.findElement(By.id(Login.id_btn_login)).click();
//		String error_text = driver.findElement(By.xpath("//small[@id='passwordHelp']/following-sibling::div"))
//				.getText();
//		if (error_text.equalsIgnoreCase("Password is invalid")) {
//
//			System.out.println("TestCase = Pass");
//
//		} else {
//			System.out.println("TestCase  = Fail");
//		}
//
//	}
//
//}
