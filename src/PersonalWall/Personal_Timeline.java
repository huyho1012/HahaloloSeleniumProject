package PersonalWall;

import org.junit.jupiter.api.Test;

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
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		postNormal = new PostPage(driver);
		postNormal.CreatePost(postDummy);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(Connection.URL_PERSONAL);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String text = perWall.contentPost.getText();
//		System.out.println(text);
////		if (perWall.contentPost.getText().equals(postDummy)){
////			perWall.menuPostAction.click();
////			perWall.delelePost.click();
////			perWall.btnConfirm.click();
////		}
	}
}
