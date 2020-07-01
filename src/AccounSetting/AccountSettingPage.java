package AccounSetting;

import Common.CommonLink;
import Login.LoginPage;
import Newsfeed.NewsfeedPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.StringTokenizer;

import static java.lang.Thread.sleep;

public class AccountSettingPage {
    WebDriver driver;
    public AccountSettingPage( WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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
    @FindBy (css = "div#js_body_username i")
    WebElement btnUpdateUserName;

    public void AccountGeneralSetting(){
        LoginPage login = new LoginPage(driver);
        NewsfeedPage newsfeed = new NewsfeedPage(driver);
        login.Login("balo_04@mailinator.com","123456");
        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        newsfeed.ChangeLanguagetoVI();
        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        menuHeaderSetting.click();
        accSet.click();

    }

    // Element của chức năng đổi tên tài hiển thị tài khoản
    String fullName;
    String fName;
    String lName;
    String midName;

    @FindBy (name = "firstName")
    WebElement txtFirstName;
    @FindBy (name = "middleName")
    WebElement txtMidName;
    @FindBy (name = "lastName")
    WebElement txtLastName;
    @FindBy (css = "div#setting_general form > div:nth-child(6) > button[type=\"submit\"].btn.btn-primary")
    WebElement btnSaveChange;
    @FindBy (id= "js-result")
    WebElement msgFullName;

    public String getMsgEditFullName() {
        String msg_validation_FullName = msgFullName.getText();
        return msg_validation_FullName;
    }

    public String GetFullNameDisplayAfterUpdate(){
        return  driver.findElement(By.cssSelector("div#setting_general div:nth-child(1) > div > div.col > div")).getText();
    }

    public String ValidateLenghtOfFullname(){
        String mesValidation = "";
        int maxName = fullName.length();
        if(maxName>76) {
            return "Giới hạn tối đa của Họ và tên là 75 kí tự";
        }
        return mesValidation;
    }

    public String ValidatecountWord(){
        String mesValidation = "";
        StringTokenizer tokens = new StringTokenizer(fullName);
        int n =  tokens.countTokens();
        if(n>=6){
            return "Họ và tên không lớn hơn 5 từ.";
        }
        return mesValidation;
    }

    public String ValidationWhitespace(){
        String mesValidation = "";
        int whitespaceFirstName = countWhitespace(fName.trim());
        int whitespaceLastName = countWhitespace(lName.trim());
        int whitespaceMiddleName = countWhitespace(midName.trim());
        if(whitespaceFirstName>=2) {
            return "Tên không được nhập quá 2 kí tự trắng.";
        }
        else if(whitespaceLastName>=2){
            return "Họ không được nhập quá 2 kí tự trắng.";
        }
        else if(whitespaceMiddleName>=2){
            return "Chữ lót không được nhập quá 2 kí tự trắng.";
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
        last = last.trim();
        middle = middle.trim();
        first = first.trim();

        if(last== ""){
            return middle+" "+first;
        }
        else if(first== ""){
            return last+" "+ middle;
        }
        else if(middle == ""){
            return last+" "+ first;
        }
        return last.trim()+" "+ middle.trim()+ " " + first.trim();

    }

    public void UpdateFullName(String first, String last, String middle) {
        System.out.println(driver);
        AccountGeneralSetting();
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
    }

    // Element của chức năng đổi tên định danh người dùng
    @FindBy (css = "div#setting_general div:nth-child(1) > input")
    WebElement txtUserName;
    @FindBy (id = "js_btn_save_username")
    WebElement btnSaveUserName;
    @FindBy (id ="jsLoadMsg")
    WebElement msgUserName;
    @FindBy (id ="js_body_username")
    WebElement urlUserNameDisplay;

    String personalURL;
    String username;
    public String getMsgEditUserName(){
        String msg_validation_username = msgUserName.getText();
        return msg_validation_username;
    }
    public String getUrlUserName(String username){
        personalURL  = CommonLink.URL_PERSONAL_COMMON+ username;
        return  personalURL;
    }
    public String getUrlUserNameDisplay(){
        return  urlUserNameDisplay.getText();
    }
    // Cập nhật tên người dùng
    public void UpdateUsername(String userName){
        AccountGeneralSetting();
        tabGeneral.click();
        btnUpdateUserName.click();
        txtUserName.clear();
        txtUserName.sendKeys(userName);
        username =userName;
        btnSaveUserName.click();
    }

    // Element tại form Nhập mật khẩu xác nhận
    @FindBy (name= "confirmPwd")
    WebElement confirmPass;
    @FindBy (id="act-confirm-pwd")
    WebElement btnConfirmPass;
    @FindBy (css = "div#modalConfirmPw button[type=\"button\"].btn.btn-dark")
    WebElement btnCancel;

    public boolean CheckDisplayConfirmPopup(){
        return !driver.findElement(By.cssSelector("div#modalConfirmPw div.modal-header.bg-faded-light.rounded-top.py-2 > span")).isDisplayed();
    }

    // Hàm thực thị thao tác trong xác nhận mật khẩu
    public void ConfirmPassPopup(String confirmPassWord){
        confirmPass.sendKeys(confirmPassWord);
        btnConfirmPass.click();
    }

    // Chức năng Đăng xuất tài khoản
    public void LogoutPage(){
        menuHeaderSetting.click();
        menuLogout.click();
    }
}
