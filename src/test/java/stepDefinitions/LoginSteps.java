package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import genericLib.Constants;
import genericLib.Driver;
import genericLib.Excellib;
import genericLib.WebDriverCommonLib;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjectRepoLib.Login;

public class LoginSteps {

	public static WebDriver driver = null;
	Login LG;
	WebDriverCommonLib wcmb;

	@Given("User is on the login page")
	public void user_is_on_the_app_login_page() {
		System.out.println("Under User on Login Page...");
		driver = Driver.getBrowser();
		driver.get(Constants.baseURL);
		WebDriverCommonLib.pageMaximize();
		WebDriverCommonLib.waitForPageLoad();
	}

	@When("User enters username and password")
	public void user_enters_username_and_password() throws IOException {
		LG = new Login(driver);
		LG.loginToApp(Constants.userName, Constants.password);

	}

	@And("Clicks on Login button")
	public void clicks_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		LG.clickLogin();
	}

	@Then("User is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws IOException {

		LG.logoutApp();
		WebDriverCommonLib.closeBrowser();

	}

}
