package Common;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Connection {
	protected WebDriver driver;
	
	public static final String URL_LOGIN = "https://test-newsfeed.hahalolo.com/auth/signin";
	public static final String URL_PERSONAL = "https://test-newsfeed.hahalolo.com/u/tester";
	@Before
	public void Connection() {
		System.setProperty("webdriver.chrome.driver", "lib//chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(URL_LOGIN);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
//	@After
//	public void ClosePage() {
//		driver.close();
//	}
}
