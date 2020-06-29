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
        setAcc.UpdateFullName("Huy  " ,"Hồ  ", " Quốc Doãn ");
        setAcc.ConfirmPassPopup("123456");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      Assert.assertEquals(setAcc.Fullname,(driver.findElement(By.cssSelector("div#setting_general div:nth-child(1) > div > div.col > div")).getText()));
        System.out.println("Kịnh");
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
    @Test
    public void UpdateWithNoMidleName(){
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", "Hồ", "");
    }
    @Test
    public void UpdateWithMidNameContainsWhiteSpace(){
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", "Hồ", " Doãn  Quốc  ");
    }
    @Test
    public void UpdateWithMidNameContainSpecialChar(){
    }
    @Test
    public void UpdateWithMidNameContainNumberic(){
    }
    @Test
    public void UpdateWithMidNameContainsScriptCode() {
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName(dummy.SCRIPTCODE ,"Hồ", "Doãn Quốc");
    }
    @Test
    public void UpdateWithMidNameContainsHTML() {
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName(dummy.HTMLCODE ,"Hồ", "Doãn Quốc");
    }
    @Test
    public void UpdateWithLastnameBlank(){
        setAcc = new AccountSettingPage(driver);
        setAcc.UpdateFullName("Huy", "", "Doãn Quốc");
    }
    @Test
    public void UpdateWithLastnameContainsMoreWhiteSpace(){
    }
    @Test
    public void UpdateWithLastnameContainsNumberic(){
    }
    @Test
    public void UpdateWithLastnameContainsScriptCode(){
    }
    public void UpdateWithLastNameContainHTMLCode(){
    }
    public void makeConfirmPasswordBlank(){

    }
    public void makeConfirmPasswordContainsWhitepace(){

    }
    public void makeInvalidConfirmPass(){

    }
    public void  makeConfirmPasswordLessThan2Char(){

    }
    public void makeConfirmPasswordExceedThan128Char(){

    }
    public void checkActionClickCancelButtonWhenUpdateName(){

    }
    public void checkActionClickCancelonConfirmPasswordPopup(){

    }


}
