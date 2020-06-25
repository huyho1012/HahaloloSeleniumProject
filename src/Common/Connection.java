package Common;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Connection {
	protected WebDriver driver;
	
	@Before
	public void Connection() {
		System.setProperty("webdriver.chrome.driver", "lib//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		driver = new ChromeDriver(options);
//		driver = new ChromeDriver();
		driver.get(CommonLink.URL_LOGIN);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}
//	@After
//	public void ClosePage() {
//		driver.close();
//	}
}
