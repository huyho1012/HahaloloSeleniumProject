package AccounSetting;

import Login.LoginPage;
import Newsfeed.NewsfeedPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.lang.String;
import java.util.StringTokenizer;

public class AccountSettingPage {
    WebDriver driver;
    int count;
    int countWhitespace;
    String confirmPassWord;
    String fullName;
    String fName;
    String lName;
    String midName;
    @FindBy (css = "div.topnav > div:nth-child(7) > div > span")
    WebElement menuHeaderSetting;
    @FindBy (css = "div.topnav > div:nth-child(7) > div > div > a:nth-child(8) > span:nth-child(2)")
    WebElement menuLogout;
    @FindBy (css = "div.topnav > div:nth-child(7) > div > div > a:nth-child(6) > span:nth-child(2)")
    WebElement accSet;

    @FindBy( css = "section#main-content a.nav-link.setting_general_nav")
    WebElement tabGeneral;
    @FindBy (css = "#setting_general > div > div.list-group > div:nth-child(1) > div > div.col-auto > button > i")
    WebElement btnUpdateFullName;
    @FindBy (name = "firstName")
    WebElement txtFirstName;
    @FindBy (name = "middleName")
    WebElement txtMidName;
    @FindBy (name = "lastName")
    WebElement txtLastName;
    @FindBy (css = "div#setting_general form > div:nth-child(6) > button[type=\"submit\"].btn.btn-primary")
    WebElement btnSaveChange;

    @FindBy (name= "confirmPwd")
    WebElement confirmPass;
    @FindBy (id="act-confirm-pwd")
    WebElement btnConfirmPass;
    @FindBy (css = "div#modalConfirmPw button[type=\"button\"].btn.btn-dark")
    WebElement btnCancel;

    // Hàm thực thị thao tác trong xác nhận mật khẩu
    public void ConfirmPassPopup(String confirmPassWord){
        confirmPass.sendKeys(confirmPassWord);
        btnConfirmPass.click();
    }
    public boolean CheckDisplayConfirmPopup(){
        if(!driver.findElement(By.cssSelector("div#modalConfirmPw div.modal-header.bg-faded-light.rounded-top.py-2 > span")).isDisplayed()) return true;
            return false;
    }

    public AccountSettingPage( WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void LoginNewsfeed(){
        LoginPage login = new LoginPage(driver);
        NewsfeedPage newsfeed = new NewsfeedPage(driver);
        login.Login("balo_04@mailinator.com","123456");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        newsfeed.ChangeLanguagetoVI();
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

    public void UpdateFullName(String first, String last, String middle){
        AcccounSetting();
        tabGeneral.click();
        btnUpdateFullName.click();
        txtFirstName.clear();
        txtFirstName.sendKeys(first);
        txtMidName.clear();
        txtMidName.sendKeys(middle);
        txtLastName.clear();
        txtLastName.sendKeys(last);
        btnSaveChange.click();
        fullName = GetFullName(first,last,middle);
        lName = last;
        fName = first;
        midName = middle;
    }
    public String ValidateLenghtOfFullname(){
        String mesValidation = "";
        int maxName = fullName.length();
        if(maxName>76) {
            return "The maxiumun limit of Full name is 75 characters";
        }
        return mesValidation;
    }
    public String ValidatecountWord(){
        String mesValidation = "";
        StringTokenizer tokens = new StringTokenizer(fullName);
        int n =  tokens.countTokens();
        if(n>=6){
            return "Full name not great than 5 word.";
        }
        return mesValidation;
    }
    public String ValidationWhitespace(){
        String mesValidation = "";
        int whitespaceFirstName = countWhitespace(fName.trim());
        int whitespaceLastName = countWhitespace(lName.trim());
        int whitespaceMiddleName = countWhitespace(midName.trim());
        if(whitespaceFirstName>=2) {
            return "First name don't input great than 2 spaces.";
        }
        else if(whitespaceLastName>=2){
            return "Last name don't input great than 2 spaces.";
        }
        else if(whitespaceMiddleName>=2){
            return "Middle name don't input great than 2 spaces.";
        }
        return mesValidation;
    }
    public int countWhitespace(String content){
        int countWhitespace = 0;
        char chars;
        int sizeName = content.length();
        for(int i = 0; i < sizeName-1; i++) {
            chars = content.charAt(i);
            if(Character.isSpaceChar(chars))
                countWhitespace ++;
        }
        return countWhitespace;
    }
    public String GetFullName(String first, String last, String middle){
        return last.trim()+" "+ middle.trim()+" "+first.trim();
    }
    public String GetFullNameDisplayAfterUpdate(){
        return  driver.findElement(By.cssSelector("div#setting_general div:nth-child(1) > div > div.col > div")).getText();
    }

}
