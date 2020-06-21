package Common;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Connection {
	protected WebDriver driver;
	
	public static final String URL_LOGIN = "https://test-newsfeed.hahalolo.com/auth/signin";
	public static final String URL_PERSONAL = "https://test-newsfeed.hahalolo.com/u/tester";
	@BeforeEach
	public void Connection() {
		System.setProperty("webdriver.gecko.driver", "lib//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(URL_LOGIN);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
//	@AfterEach
//	public void ClosePage() {
//		driver.close();
//	}
}
