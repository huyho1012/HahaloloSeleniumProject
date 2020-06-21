package PersonalWall;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import Common.Connection;
import Common.Dummy;
import Login.LoginPage;
import PostNormal.PostPage;

public class Personal_Timeline extends Connection{
	Dummy dum = new Dummy();
	String postDummy = dum.RandomString(300);
	LoginPage login;
	PostPage postNormal;
	PersonalPage perWall;
	@Test
	public void GotoPersonal() {
		login = new LoginPage(driver);
		login.Login("balo_04@mailinator.com", "123456");
		postNormal = new PostPage(driver);
		postNormal.CreatePost("cc");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		perWall.userLink.click();
		if (perWall.contentPost.getText().equals(postDummy)){
			perWall.menuPostAction.click();
			perWall.delelePost.click();
			perWall.btnConfirm.click();
		}
	}
}
