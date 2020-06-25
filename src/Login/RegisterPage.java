package Login;

import Common.Connection;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class RegisterPage extends Connection {
    protected  String Code;
    @FindBy (name = "nv104")
    WebElement Firstname;
    @FindBy (name = "nv103")
    WebElement Lastname;
    @FindBy (name = "nv108")
    WebElement Username;
    @FindBy (name = "nv109")
    WebElement Password;
    @FindBy (name = "repeatPassword")
    WebElement Confirmpass;

    @FindBy (id = "signUpButton")
    WebElement btnSignUp;

    // Màn hình xác minh
    @FindBy (css = "input[name=\"code\"]")
    WebElement verifyCode;

    @FindBy (css ="div#app button[type=\"submit\"]" )
    WebElement btnSendVerify;

    // Màn hình Mailinator.com
    @FindBy (id = "addOverlay")
    WebElement formSearchMail;

    @FindBy (id = "go-to-public")
    WebElement btnSearchEmail;

    @FindBy (css = "div#inboxpane a")
    WebElement verifyEmail;

//    @FindBy (css= ".help-block")
//    WebElement errMessage;

    public RegisterPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }
    public void RegisterWithEmail(String firstName, String lastName, String email, String pass, String confirmPass){
        System.out.println(driver);
        Firstname.sendKeys(firstName);
        Lastname.sendKeys(lastName);
        Username.sendKeys(email);
        Password.sendKeys(pass);
        Confirmpass.sendKeys(confirmPass);
        btnSignUp.click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String t = driver.getCurrentUrl();
        if(t.equals("https://test-newsfeed.hahalolo.com/auth/active?redirect=https://test-newsfeed.hahalolo.com/auth/signin")){ verifyCode.sendKeys(GetVerificationCode(email));
          btnSendVerify.click();
        }
    }
    public void RegisterWithPhone(String firstName, String lastName, String phone, String pass, String confirmPass){
        Firstname.sendKeys(firstName);
        Lastname.sendKeys(lastName);
        Username.sendKeys(phone);
        Password.sendKeys(pass);
        Confirmpass.sendKeys(confirmPass);
        btnSignUp.click();
    }
    public String GetErrMessage() {
        String message = driver.findElement(By.className("help-block")).getText();
        return message;
    }
    public String GetVerificationCode(String email){
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.mailinator.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        formSearchMail.sendKeys(email);
        btnSearchEmail.click();
        verifyEmail.click();
        driver.switchTo().frame(0);
        Code = driver.findElement(By.cssSelector("table:nth-child(1) tbody:nth-child(1) tr:nth-child(1) td:nth-child(1) > h2:nth-child(4)")).getText();
        driver.switchTo().window(tabs.get(0));
        return Code;
    }
}
