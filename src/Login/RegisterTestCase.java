package Login;

import Common.CommonLink;
import Common.Connection;
import Common.Dummy;
import Newsfeed.NewsfeedPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class RegisterTestCase extends Connection {
    Dummy dummy = new Dummy();
    NewsfeedPage feed;
    protected String ranDomEmail = dummy.RamdomVirtualMail();
    RegisterPage reg;

    @Test
    public void CreateSuccessEmail(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ", ranDomEmail, "123456", "123456");
        feed = new NewsfeedPage(driver);
        Assert.assertTrue(feed.checkNewsfeedDisplay());
    }
    @Test
    public void RegisterWithBlankFirstName(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("","Hồ", ranDomEmail, "123456", "123456");
        Assert.assertEquals(reg.GetErrMessage(),"Tên là bắt buộc.");
    }
    @Test
    public void RegisterWithBlankLastName(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","", ranDomEmail, "123456", "123456");
        Assert.assertEquals(reg.GetErrMessage(),"Họ là bắt buộc.");
    }
    @Test
    public void RegisterWithBlankEmail(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Quốc", "", "123456", "123456");
        Assert.assertEquals(reg.GetErrMessage(),"Tài khoản là bắt buộc.");
    }
    @Test
    public void RegisterWithBlankPassWord(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Quốc", ranDomEmail, "", "123456");
        Assert.assertEquals(reg.GetErrMessage(),"Mật khẩu là bắt buộc.");
    }
    @Test
    public void RegisterWithBlankConfirmPass(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Quốc", ranDomEmail, "123456", "");
        Assert.assertEquals(reg.GetErrMessage(),"Mật khẩu xác nhận là bắt buộc.");
    }

    // Check validation của ô Tên
    @Test
    public void RegisterWithFistNameContainNumberic(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy 1","Hồ Doãn Quốc", ranDomEmail, "123456", "123456");
        Assert.assertEquals(reg.GetErrMessage(),"Tên không chứa số.");
    }
    @Test
    public void RegisterWithFistNameContainSpecialChartacter(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy @@@","Hồ Doãn Quốc", ranDomEmail, "123456", "123456");
        Assert.assertEquals(reg.GetErrMessage(),"Tên không chứa ký tự đặc biệt.");
    }
    @Test
    public void RegisterWithFistNameContainScript(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail(dummy.SCRIPTCODE,"Hồ Doãn Quốc", ranDomEmail, "123456", "123456");
        Assert.assertEquals(reg.GetErrMessage(),"Tên không chứa ký tự đặc biệt.");
    }
    @Test
    public void RegisterWithFistNameContainHTML(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail(dummy.HTMLCODE,"Hồ Doãn Quốc", ranDomEmail, "123456", "123456");
        Assert.assertEquals(reg.GetErrMessage(),"Tên không chứa ký tự đặc biệt.");
    }

    // Check validation của ô Họ và tên lót
    @Test
    public void RegisterWithLastNameContainNumberic(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Quốc 1", ranDomEmail, "123456", "123456");
        Assert.assertEquals(reg.GetErrMessage(),"Họ không chứa số.");
    }
    @Test
    public void RegisterWithLastNameContainSpecialChartacter(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Qu@c", ranDomEmail, "123456", "123456");
        Assert.assertEquals(reg.GetErrMessage(),"Họ không chứa ký tự đặc biệt.");
    }
    @Test
    public void RegisterWithLastNameContainScript(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy",dummy.SCRIPTCODE, ranDomEmail, "123456", "123456");
        Assert.assertEquals(reg.GetErrMessage(),"Họ không chứa ký tự đặc biệt.");
    }
    @Test
    public void RegisterWithLastNameContainHTML(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy",dummy.HTMLCODE, ranDomEmail, "123456", "123456");

        Assert.assertEquals(reg.GetErrMessage(),"Họ không chứa ký tự đặc biệt.");
    }
    // Check validation của ô Password
    @Test
    public void RegisterWithPasswordLessThan6Character(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Quốc", ranDomEmail, "123", "123");
        Assert.assertEquals(reg.GetErrMessage(),"Giới hạn tối thiểu của Mật khẩu là 6 kí tự");
    }
    @Test
    public void RegisterWithPasswordExceedThan128Character(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Quốc", ranDomEmail, dummy.DummyPass(129), dummy.DummyPass(129));
        Assert.assertEquals(reg.GetErrMessage(),"Giới hạn tối đa của Mật khẩu là 128 kí tự");
    }
    @Test
    public void RegisterWithPasswordContainWhiteSpace(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Quốc", ranDomEmail, "123 456", "123 456");
        Assert.assertEquals(reg.GetErrMessage(),"Mật khẩu không chứa kí tự trắng.");
    }
    @Test
    public void RegisterWithPasswordNotSame(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Quốc", ranDomEmail, "123456", "1234567");
        Assert.assertEquals(reg.GetErrMessage(),"Mật khẩu xác nhận phải trùng với Mật khẩu");
    }
    // Check validation của ô ConfirmPassword
    @Test
    public void RegisterWithConfirmPasswordLessThan6Character(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Quốc", ranDomEmail, "123456", "123");
        Assert.assertEquals(reg.GetErrMessage(),"Mật khẩu xác nhận phải trùng với Mật khẩu");
    }
    @Test
    public void RegisterWithConfirmPasswordExceedThan128Character(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Quốc", ranDomEmail, "123456", dummy.DummyPass(129));
        Assert.assertEquals(reg.GetErrMessage(),"Mật khẩu xác nhận phải trùng với Mật khẩu");
    }
    @Test
    public void RegisterWithConfirmPasswordContainWhiteSpace(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Quốc", ranDomEmail, "123456", "123 456");
        Assert.assertEquals(reg.GetErrMessage(),"Mật khẩu xác nhận không chứa kí tự trắng.");
    }
    // Validate khi nhập email
    @Test
    public void RegisterWithInvalidEmail() {
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Quốc", "huyho1210@mailinator.", "123456", "123456");
        Assert.assertEquals(reg.GetErrMessage(),"Tài khoản không hợp lệ.");
    }
    @Test
    public void RegisterWithEmailContainsMoreSpecialChar() {
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Quốc", "huyh$1210@mailinator.com", "123456", "123456");
        Assert.assertEquals(reg.GetErrMessage(),"Tài khoản không hợp lệ.");
    }
    @Test
    public void RegisterWithEmailContainsWhiteSpaceOnFirst() {
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Quốc", " huyho1210@mailinator.com", "123456", "123456");
        Assert.assertEquals(reg.GetErrMessage(),"Tài khoản không hợp lệ.");
    }
    @Test
    public void RegisterWithEmailContainsWhiteSpaceOnBetween() {
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Quốc", "huyho 1210@mailinator.com", "123456", "123456");
        Assert.assertEquals(reg.GetErrMessage(),"Tài khoản không hợp lệ.");
    }
    @Test
    public void RegisterWithEmailContainsDashCharacter(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Quốc", "huyho-1210@mailinator.com", "123456", "123456");
        feed = new NewsfeedPage(driver);
        Assert.assertTrue(feed.checkNewsfeedDisplay());
    }
    @Test
    public void RegisterWithEmailContainsUnderlineCharacter(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Quốc", "huyho_1210@mailinator.com", "123456", "123456");
        feed = new NewsfeedPage(driver);
        Assert.assertTrue(feed.checkNewsfeedDisplay());
    }
    @Test
    public void RegisterWithEmailContainsMoreThan2DotsCharacter(){
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy","Hồ Doãn Quốc", "huyho.1210@mailinator.com", "123456", "123456");
        feed = new NewsfeedPage(driver);
        Assert.assertTrue(feed.checkNewsfeedDisplay());
    }
    @Test
    public void RegisterWithEmailExsitedonHahalolo() {
        reg = new RegisterPage(driver);
        reg.RegisterWithEmail("Huy", "Hồ Doãn Quốc", "balo_04@mailinator.com", "123456", "123456");
        feed = new NewsfeedPage(driver);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(reg.GetErrMessage(), "Tài khoản đã tồn tại trên hệ thống Hahalolo.");
    }

}
