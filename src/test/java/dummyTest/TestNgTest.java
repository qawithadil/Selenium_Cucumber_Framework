package dummyTest;

import org.testng.annotations.Test;

public class TestNgTest {

	@Test(groups = {"smoke", "regression"} )
	public void TC001() {
		System.out.println("This is TC001");
	}

	@Test(groups = {"smoke"} )
	public void TC002() {
		System.out.println("This is TC002");
	}

	@Test(groups = {"smoke"} )
	public void TC003() {
		System.out.println("This is TC003");
	}

	@Test(groups = {"Regression"} )
	public void TC004() {
		System.out.println("This is TC004");
	}
	@Test(groups = {"smoke"} )
	public void TC005() {
		System.out.println("This is TC005");
	}

}
