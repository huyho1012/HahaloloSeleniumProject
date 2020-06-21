package Login;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import Common.Connection;

public class LoginTestcase extends Connection{
	
	LoginPage loginPage;
	public void LoginSuccess() {
		loginPage = new LoginPage(driver);
		loginPage.Login("balo_04@mailinator.com","123456");
	}
	public void LoginWithBlankUsername() {
		loginPage = new LoginPage(driver);
		loginPage.Login("","123456");
		Assertions.assertEquals(loginPage.message.getText(),"Tài khoản là bắt buộc.");

	}
	public void LoginWithBlankPass() {
		loginPage = new LoginPage(driver);
		loginPage.Login("balo_04@mailinator.com","");
		Assertions.assertEquals(loginPage.message.getText(),"Mật khẩu là bắt buộc.");
	}

	public void LoginWithBankInfo() {
		loginPage = new LoginPage(driver);
		loginPage.Login("","");
//		Assertions.assertEquals(expected, actual);
	}

	public void LoginWithBankInfo1() {
		loginPage = new LoginPage(driver);
		loginPage.Login("","");
//		Assertions.assertEquals(expected, actual);
	}
		
	
}
