package AccounSetting;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UpdateUsernameTestcase {
    WebDriver driver;
    AccountSettingPage setAcc;

        @Test
    public void Logout(){
        setAcc = new AccountSettingPage(driver);
        setAcc.AccountGeneralSetting();
        setAcc.LogoutPage();
    }
    @Test
    public void UpdateUserNameSuccess(){
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateUsername("tester@hahalolo");
        if(setAcc.getMsgEditUserName().equals("Tên người dùng khả dụng")){
            setAcc.btnUpdateUserName.click();
        }
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(setAcc.getUrlUserNameDisplay(), setAcc.getUrlUserName(setAcc.username));
    }
}
