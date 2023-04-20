package stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import genericLib.Driver;
import genericLib.WebDriverCommonLib;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectRepoLib.Login;

public class MultiLogin {

	public static WebDriver driver;
	Login LG;
	WebDriverCommonLib wbcm = new WebDriverCommonLib(driver);

	@Before
	// @Given("User open the browser")
	public void user_open_the_browser() {
		driver = Driver.getBrowser();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();

	}

	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		driver.get("https://example.testproject.io/web");

	}

	@When("^User enter the (.*) and (.*)$")
	public void user_enter_creds(String username, String password) throws IOException {
		LG = new Login(driver);
		LG.loginToApp(username, password);

	}

	@And("User can click login button")
	public void user_can_click_login_button() {
		LG.clickLogin();
	}

	@Then("Verify that homePage is populated")
	public void verify_that_home_page_is_populated() {
		boolean result = LG.verifyLogoutButton();
		Assert.assertEquals(result, true);

	}

	@Then("Verify that erorr message should show")
	public void user_not_login_into_app() {
		String actual_result = LG.errorMsg();
		String expected_result = "Password is invalid";
		Assert.assertEquals(actual_result, expected_result);

	}

	@And("Logout the application")
	public void Logout_the_application() {
		LG.logoutApp();

	}

	@After
	public void closeBrowser() {
		driver.close();
	}

}
