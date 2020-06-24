package Login;
import Common.Dummy;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import Common.Connection;

public class LoginTestcase extends Connection{
	Dummy dummy = new Dummy();
	String email = dummy.RamdomVirtualMail();
	LoginPage loginPage;

	@Test
	public void LoginWithBlankUsername() {
		loginPage = new LoginPage(driver);
		loginPage.Login("","P@ssword");
		Assertions.assertEquals(loginPage.GetErrMessage(),"Tài khoản là bắt buộc.");
	}
	@Test
	public void LoginWithBlankPass() {
		loginPage = new LoginPage(driver);
		loginPage.Login("huyho1210@gmail.com","");
		Assertions.assertEquals(loginPage.GetErrMessage(),"Mật khẩu là bắt buộc.");
	}
	@Test
	public void LoginWithBlankInfo() {
		loginPage = new LoginPage(driver);
		loginPage.Login("","");
		Assertions.assertEquals(loginPage.GetErrMessage(),"Tài khoản là bắt buộc.");
	}
	@Test
	public void LoginIncorrectPasswordOrUsername(){
		loginPage = new LoginPage(driver);
		loginPage.Login("huyho1210@gmail.com","P@ssword1");
		Assertions.assertEquals(loginPage.GetErrMessage(),"Tên tài khoản hoặc mật khẩu sai");
	}
	@Test
	public void LoginWithValidEmail() {
		loginPage = new LoginPage(driver);
		loginPage.Login("huyho1210@gmail.com","P@ssword");
	}
	@Test
	public void LoginWithVirtualEmail() {
		loginPage = new LoginPage(driver);
		loginPage.Login("balo_04@mailinator.com","123456");
	}
	@Test
	public void LoginWitEmailContainsWhitespaceOnFirst() {
		loginPage = new LoginPage(driver);
		loginPage.Login(" huyho1210@gmail.com","P@ssword");
		Assertions.assertEquals(loginPage.GetErrMessage(),"Tài khoản không hợp lệ.");
	}
	@Test
	public void LoginWithEmailContainsWhitespaceOnBetween(){
		loginPage.Login("huyh o1210@gmail.com","P@ssword");
		Assertions.assertEquals(loginPage.GetErrMessage(),"Tài khoản không hợp lệ.");
	}
	@Test
	public void LoginWithEmailContainsWhitespaceOnEnd() {
		loginPage.Login("huyho1210@gmail.com ", "P@ssword");
		Assertions.assertEquals(loginPage.GetErrMessage(), "Tài khoản không hợp lệ.");
	}
	@Test
	public void LoginWithEmailContainsUpperCase(){
		loginPage.Login("Huyho1210@gmail.com", "P@ssword");
	}
	@Test
	public void LoginWithValidPhone(){
		loginPage.Login("0936709449","123456a");
	}
	@Test
	public void LoginWithInvalidPhoneFormat(){
		loginPage.Login("0936709","123456a");
		Assertions.assertEquals(loginPage.GetErrMessage(),"Tài khoản không hợp lệ.");
	}
	@Test
	public void LoginWithPhoneContainsWhiteSpace(){
		loginPage.Login("0936709449 ","123456a`");
		Assertions.assertEquals(loginPage.GetErrMessage(),"Tài khoản không hợp lệ.");
	}
	@Ignore
	public void LoginWithPhoneContainAreaPhoneCode(){
		loginPage.Login("84936709449","123456a");
	}
	@Ignore
	public void LoginWithPhoneNotContainsAreaPhoneCode(){
		loginPage.Login("936709449","123456a");
	}
	@Test
	public void LoginWithPasswordLessThan6Chars() {
		loginPage = new LoginPage(driver);
		loginPage.Login("huyho1210@gmail.com",dummy.RandomString(5));
		Assertions.assertEquals(loginPage.GetErrMessage(),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");
	}
	@Test
	public void LoginWithPasswordExcced128Chars() {
		loginPage = new LoginPage(driver);
		loginPage.Login("huyho1210@gmail.com", dummy.RandomString(129));
		Assertions.assertEquals(loginPage.GetErrMessage(), "Giới hạn tối đa của Mật khẩu là 128 kí tự");
	}
	@Test
	public void LoginWithPasswordContainsWhitespace() {
		loginPage = new LoginPage(driver);
		loginPage.Login("huyho1210@gmail.com","123 456");
		Assertions.assertEquals(loginPage.GetErrMessage(),"Mật khẩu không chứa kí tự trắng.");
	}
}
