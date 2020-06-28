package AccounSetting;

import Login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSettingPage {
    WebDriver driver;
    Actions act;
    @FindBy (css = "div.topnav > div:nth-child(7) > div > span")
    WebElement menuHeaderSetting;
    @FindBy (css = "div.topnav > div:nth-child(7) > div > div > a:nth-child(8) > span:nth-child(2)")
    WebElement menuLogout;
    @FindBy (css = "div.topnav > div:nth-child(7) > div > div > a:nth-child(6) > span:nth-child(2)")
    WebElement accSet;

    @FindBy( css = "section#main-content a.nav-link.setting_general_nav")
    WebElement tabGeneral;
    @FindBy (css = "#setting_general > div > div.list-group > div:nth-child(1) > div > div.col-auto > button > i")
    WebElement btnEditFullName;
    @FindBy (name = "firstName")
    WebElement firstName;
    @FindBy (name = "middleName")
    WebElement middleName;
    @FindBy (name = "lastName")
    WebElement lastName;
    @FindBy (css = "#setting_general > div > div.list-group > div:nth-child(1) > form > div:nth-child(6) > button.btn.btn-primary")
    WebElement btnSaveChange;

    @FindBy (name ="confirmPwd")
    WebElement confirmPass;
    @FindBy (id = "act-confirm-pwd")
    WebElement btnConfirmPass;

    String fName ="";
    String midName="";
    String lName="";
    public AccountSettingPage( WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void LoginNewsfeed(){
        LoginPage login = new LoginPage(driver);
        login.Login("balo_04@mailinator.com","123456");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void LogoutPage(){
        menuHeaderSetting.click();
        menuLogout.click();
    }
    public void AcccounSetting(){
        LoginNewsfeed();
        menuHeaderSetting.click();
        accSet.click();
    }

    public void formConfirmPass(String confirmPass){
    }
    public void UpdateFullName(String first, String last, String middle){
        AcccounSetting();
        tabGeneral.click();
        btnEditFullName.click();
        firstName.clear();
        firstName.sendKeys(first);
        middleName.clear();
        middleName.sendKeys(middle);
        lastName.clear();
        lastName.sendKeys(last);
        if(ValidateLenghtOfFullname()==false) {
            btnSaveChange.click();
            confirmPass.sendKeys("123456");
            btnConfirmPass.click();
        }
        else {
            btnSaveChange.click();}
    }
    public boolean ValidateLenghtOfFullname(){
        int maxLengFullname = fName.length()+ fName.length() + midName.length();
        if(maxLengFullname>76) return false;
        return  true;
    }
}