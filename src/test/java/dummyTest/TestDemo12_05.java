package dummyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import genericLib.Constants;
import genericLib.Driver;
import genericLib.WebDriverCommonLib;

public class TestDemo12_05 {
	
	public static WebDriver driver = null;

	public static void main(String[] args) {
		
		driver = Driver.getBrowser();
		driver.get(Constants.baseURL);
		WebDriverCommonLib.pageMaximize();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
		driver.findElement(By.xpath("//button[@id='login']")).click();
		

	}

}
