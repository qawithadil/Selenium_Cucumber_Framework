package pageObjectRepoLib;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLib.Constants;
import genericLib.Driver;
import genericLib.Excellib;
import genericLib.WebDriverCommonLib;

public class Login {

	WebDriver driver;
	WebDriverCommonLib WMTH = new WebDriverCommonLib(driver);

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "name")
	private WebElement txt_userName;

	@FindBy(id = "password")
	private WebElement txt_password;

	@FindBy(id = "login")
	private WebElement btn_login;

	@FindBy(id = "logout")
	private WebElement btn_logout;

	@FindBy(id = "greetings")
	private WebElement actual_text;

	@FindBy(xpath = "//small[@id='passwordHelp']/following-sibling::div")
	private WebElement errorText;

	@FindBy(xpath = "//small[@id='greetings']")
	private WebElement errorWeb;

	public void loginToApp(String userName, String password) throws IOException {

		txt_userName.clear();
		txt_userName.sendKeys(userName);
		txt_password.clear();
		txt_password.sendKeys(password);

	}

	public void clickLogin() {
		btn_login.click();
	}

	public String welcomeMsg() {

		String actualText = actual_text.getText().toString();
		return actualText;

	}

	public String errorMsg() {
		String error_text = errorText.getText().toString();
		return error_text;

	}

	public void logoutApp() {
		btn_logout.click();

	}

	public void errorWeb() {
		errorWeb.click();

	}
	public void closeBrowser() {
		driver.close();
	}
	public boolean verifyLogoutButton() {
		
		boolean result=btn_logout.isDisplayed();
		return result;
		
	}

}
