package genericLib;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("This test scenario: " +result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("This is pass test scenario: " +result.getName());

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("This is failed test scenario: " +result.getName());
		try {
			WebDriverCommonLib.getScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("This test scenario: " +result.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("This test scenario: " +result.getName());
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("This test scenario: " +result.getName());

	}

	public void onStart(ITestContext context) {
		System.out.println("This test scenario: " +context.getName());

	}

	public void onFinish(ITestContext context) {
		System.out.println("This test scenario: " +context.getName());

	}

}
