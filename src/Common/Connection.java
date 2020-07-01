package Common;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
//	@After
//	public void ClosePage() {
//		driver.close();
//	}
}
