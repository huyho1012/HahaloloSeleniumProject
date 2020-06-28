package AccounSetting;

import Common.Connection;
import Common.Dummy;
import Login.LoginPage;
import org.junit.Assert;
import org.junit.Test;
public class GeneralAccountSetting extends Connection {
    AccountSettingPage setAcc;
    LoginPage login;
    Dummy dummy = new Dummy();

    @Test
    public void UpdateWithValidInfo() {
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy" ,"Hồ", "Doãn Quốc");
    }
    @Test
    public void UpdateWithblankFirstName() {
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("" ,"Hồ", "Doãn Quốc");
    }
    @Test
    public void UpdateWithFirstNameContainsWhitespace() {
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy " ,"Hồ", "Doãn Quốc");
    }
    @Test
    public void UpdateWithFirstNameContainsSpecialChar() {
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy @@" ,"Hồ", "Doãn Quốc");
    }
    @Test
    public void UpdateWithFirstNameContainsNumber() {
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy 12" ,"Hồ", "Doãn Quốc");
    }
    @Test
    public void UpdateWithFirstNameContainsScriptCode() {
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName(dummy.SCRIPTCODE ,"Hồ", "Doãn Quốc");
    }
    @Test
    public void UpdateWithFirstNameContainsHTML() {
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName(dummy.HTMLCODE ,"Hồ", "Doãn Quốc");
    }
    @Test
    public void UpdateExxcedLimtChar() {
        setAcc = new AccountSettingPage(driver);
        login = new LoginPage(driver);
        setAcc.UpdateFullName( dummy.DummyText(75),"Hồ", "Doãn Quốc");
        Assert.assertEquals("The maxiumun limit of Full name is 75 characters", login.GetErrMessage() );
        System.out.println("hello");

    }
}
