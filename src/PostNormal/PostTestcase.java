package PostNormal;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import Common.Connection;
import Common.Dummy;
import Login.LoginPage;

public class PostTestcase extends Connection {
	Dummy dum = new Dummy();
	LoginPage loginPage;
	PostPage postPage;

//	public void CreatePost() {
//		loginPage = new LoginPage(driver);
//		loginPage.Login("balo_04@mailinator.com", "123456");
//		postPage = new PostPage(driver);
//		postPage.CreatePost(dum.RandomString(200));
//	}
	
}
