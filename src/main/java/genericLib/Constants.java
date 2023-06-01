package genericLib;

import java.io.File;

public interface Constants {

	String baseURL = "https://example.testproject.io/web/";
	String browser = "edge";
	int globalWait = 20;
	String chrome_path = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
	String firefox_path = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe";
	String edge_path = System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\msedgedriver.exe";
	static File file_path = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\data\\UserLogin.xlsx");
	static File login_file= new File(System.getProperty("user.dir")+"\\src\\test\\resources\\data\\UserLogin.xlsx");
	static String sheet_name = "Sheet1";
	static String screenshot_file=System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\";
	static String userName = "Test1";
	static String password = "12345";
	 String abc="122";

}
