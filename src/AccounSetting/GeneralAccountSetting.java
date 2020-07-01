package AccounSetting;

import Common.Connection;
import Common.Dummy;
import Login.LoginPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class GeneralAccountSetting extends Connection {
    AccountSettingPage setAcc;
    LoginPage login;
    Dummy dummy = new Dummy();

    @Test
    public void UpdateFullNameSuccessful() {
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", "Hồ", " Quốc Doãn ");
        setAcc.ConfirmPassPopup("123456");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(setAcc.fullName, setAcc.GetFullNameDisplayAfterUpdate());
    }

    // validation tổng số lượng ký tự và chữ
    @Test
    public void UpdateExcedLimtChar() {
        setAcc = new AccountSettingPage(driver);
        login = new LoginPage(driver);
        setAcc.UpdateFullName(dummy.DummyText(70), "Hồ", "Doãn Quốc");
        Assert.assertEquals(setAcc.ValidateLenghtOfFullname(), login.GetErrMessage());
    }

    @Test
    public void UpdateWithLimitWord() {
        setAcc = new AccountSettingPage(driver);
        login = new LoginPage(driver);
        setAcc.UpdateFullName("Hùng Huy", "Hồ Lý", "Doãn Quốc");
        Assert.assertEquals(setAcc.ValidatecountWord(), login.GetErrMessage());
    }

    // Validation Tên
    @Test
    public void UpdateWithblankFirstName() {
        setAcc = new AccountSettingPage(driver);
        login = new LoginPage(driver);
        setAcc.UpdateFullName("", "Hồ", "Doãn Quốc");
        Assert.assertEquals("Tên là bắt buộc.", login.GetErrMessage());
    }

    @Test
    public void UpdateWithFirstNameContainWhitespace() {
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy ", "Hồ", "Doãn Quốc");
        setAcc.ConfirmPassPopup("123456");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(driver.findElement(By.cssSelector("div#setting_general div:nth-child(1) > div > div.col > div")).getText());
        Assert.assertEquals(setAcc.fullName, setAcc.GetFullNameDisplayAfterUpdate());
    }

    @Test
    public void UpdateWithFirstNameContainSpecialChar() {
        setAcc = new AccountSettingPage(driver);
        login = new LoginPage(driver);
        setAcc.UpdateFullName("Huy @@", "Hồ", "Doãn Quốc");
        Assert.assertEquals("Tên không chứa ký tự đặc biệt.", login.GetErrMessage());
    }

    @Test
    public void UpdateWithFirstNameContainNumber() {
        setAcc = new AccountSettingPage(driver);
        login = new LoginPage(driver);
        setAcc.UpdateFullName("Huy 12", "Hồ", "Doãn Quốc");
        Assert.assertEquals("Tên không chứa số.", login.GetErrMessage());
    }

    @Test
    public void UpdateWithFirstNameContainScript() {
        setAcc = new AccountSettingPage(driver);
        login = new LoginPage(driver);
        setAcc.UpdateFullName(dummy.SCRIPTCODE, "Hồ", "Doãn Quốc");
        Assert.assertEquals("Tên không chứa ký tự đặc biệt.", login.GetErrMessage());
    }

    @Test
    public void UpdateWithFirstNameContainHTML() {
        setAcc = new AccountSettingPage(driver);
        login = new LoginPage(driver);
        setAcc.UpdateFullName(dummy.HTMLCODE, "Hồ", "Doãn Quốc");
        Assert.assertEquals("Tên không chứa ký tự đặc biệt.", login.GetErrMessage());
    }

    @Test
    public void UpdateWithFirstNameContainMoreWhiteSpaceonBetween() {
        login = new LoginPage(driver);
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy  Quốc", "Hồ", "Doãn Quốc");
        Assert.assertEquals(setAcc.ValidationWhitespace(), login.GetErrMessage());
    }

    // Validation trường hợp tên lót
    @Test
    public void UpdateWithNoMidName() {
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", "Hồ", "");
        setAcc.ConfirmPassPopup("123456");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(setAcc.fullName, setAcc.GetFullNameDisplayAfterUpdate());
    }

    @Test
    public void UpdateWithMidNameContainWhiteSpace() {
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", "Hồ", " Doãn  Quốc  ");
        setAcc.ConfirmPassPopup("123456");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(setAcc.fullName, setAcc.GetFullNameDisplayAfterUpdate());
    }

    @Test
    public void UpdateWithMidNameContainNumberic() {
        setAcc = new AccountSettingPage(driver);
        login = new LoginPage(driver);
        setAcc.UpdateFullName("Huy", "Hồ", "Doãn Quốc 1");
        Assert.assertEquals("Chữ lót không chứa số.", login.GetErrMessage());
    }

    @Test
    public void UpdateWithMidNameContainSpecialChar() {
        setAcc = new AccountSettingPage(driver);
        login = new LoginPage(driver);
        setAcc.UpdateFullName("Huy", "Hồ", "Doãn Quốc @");
        Assert.assertEquals("Chữ lót không chứa ký tự đặc biệt.", login.GetErrMessage());
    }

    @Test
    public void UpdateWithMidNameContainsScriptCode() {
        setAcc = new AccountSettingPage(driver);
        login = new LoginPage(driver);
        setAcc.UpdateFullName("Huy", "Hồ", dummy.SCRIPTCODE);
        Assert.assertEquals("Chữ lót không chứa ký tự đặc biệt.", login.GetErrMessage());
    }

    @Test
    public void UpdateWithMidNameContainsHTML() {
        setAcc = new AccountSettingPage(driver);
        login = new LoginPage(driver);
        setAcc.UpdateFullName("Huy", "Hồ", dummy.HTMLCODE);
        Assert.assertEquals("Chữ lót không chứa ký tự đặc biệt.", login.GetErrMessage());
    }

    @Test
    public void UpdateWithMiddleNameContain2WhiteSpaceBetween() {
        login = new LoginPage(driver);
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", "Hồ", "Doãn   Quốc");
        Assert.assertEquals(setAcc.ValidationWhitespace(), login.GetErrMessage());
    }

    // Validation trường hợp họ
    @Test
    public void UpdateWithLastnameBlank() {
        login = new LoginPage(driver);
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", "", "Doãn Quốc");
        Assert.assertEquals("Họ là bắt buộc.", login.GetErrMessage());
    }

    @Test
    public void UpdateWithLastNameContain2WhiteSpaceBetween() {
        login = new LoginPage(driver);
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", "Hồ  Thái", "Doãn Quốc");
        Assert.assertEquals(setAcc.ValidationWhitespace(), login.GetErrMessage());
    }

    @Test
    public void UpdateWithLastnameContainsMoreWhiteSpace() {
        login = new LoginPage(driver);
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", " Hồ ", "Doãn Quốc");
        setAcc.ConfirmPassPopup("123456");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(setAcc.fullName, setAcc.GetFullNameDisplayAfterUpdate());
    }

    @Test
    public void UpdateWithLastnameContainsNumberic() {
        login = new LoginPage(driver);
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", "Hồ 123", "Doãn Quốc");
        Assert.assertEquals("Họ không chứa số.", login.GetErrMessage());
    }

    @Test
    public void UpdateWithLastnameContainScriptCode() {
        login = new LoginPage(driver);
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", dummy.SCRIPTCODE, "Doãn Quốc");
        Assert.assertEquals("Họ không chứa ký tự đặc biệt.", login.GetErrMessage());
    }

    @Test
    public void UpdateWithLastnameContainSpeicalchar() {
        login = new LoginPage(driver);
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", "huy @@@", "Doãn Quốc");
        Assert.assertEquals("Họ không chứa ký tự đặc biệt.", login.GetErrMessage());
    }

    @Test
    public void UpdateWithLastNameContainHTMLCode() {
        login = new LoginPage(driver);
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", dummy.HTMLCODE, "Doãn Quốc");
        Assert.assertEquals("Họ không chứa ký tự đặc biệt.", login.GetErrMessage());
    }
    @Test
    public void makeConfirmPasswordBlank() {
        login = new LoginPage(driver);
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", "Hồ", "Doãn Quốc");
        setAcc.ConfirmPassPopup("");
        Assert.assertEquals("Mật khẩu là bắt buộc.", login.GetErrMessage());
    }
    @Test
    public void makeConfirmPasswordContainsWhitepace() {
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", "Hồ", "Doãn Quốc");
        setAcc.ConfirmPassPopup("123 456");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(setAcc.getErrConfirmMessage());
        Assert.assertEquals("Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác", setAcc.getErrConfirmMessage());
    }
    @Test
    public void makeInvalidConfirmPass() {
        login = new LoginPage(driver);
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", "Hồ", "Doãn Quốc");
        setAcc.ConfirmPassPopup("123456a");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác", setAcc.getErrConfirmMessage());
    }
    @Test
    public void makeConfirmPasswordLessThan2Char() {
        login = new LoginPage(driver);
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", "Hồ", "Doãn Quốc");
        setAcc.ConfirmPassPopup("12");
        Assert.assertEquals("Giới hạn tối thiểu của Mật khẩu là 6 kí tự", login.GetErrMessage());
    }
    @Test
    public void makeConfirmPasswordExceedThan128Char() {
        login = new LoginPage(driver);
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", "Hồ", "Doãn Quốc");
        setAcc.ConfirmPassPopup(dummy.DummyPass(129));
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Thay đổi tên thất bại. Mật khẩu bạn nhập không chính xác", setAcc.getErrConfirmMessage());
    }

//    @Test
//    public void checkActionClickCancelButtonWhenUpdateName() {
//        login = new LoginPage(driver);
//        setAcc = new AccountSettingPage(driver);
//        setAcc.UpdateFullName("Huy", "Hồ", "Doãn Quốc");
//        setAcc.ConfirmPassPopup("123456");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Assert.assertTrue(setAcc.CheckDisplayConfirmPopup());
//        setAcc.btnCancel.click();
//        System.out.println("đóng rồi");
//    }

    @Test
    public void checkActionClickCancelonConfirmPasswordPopup() {
        login = new LoginPage(driver);
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", "Hồ", "Doãn Quốc");
        setAcc.ConfirmPassPopup("123456");
        setAcc.btnCancel.click();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(setAcc.CheckDisplayConfirmPopup());
        System.out.println("đóng rồi");
    }


}
