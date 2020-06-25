package Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Common.Connection;

public class LoginPage extends Connection{
	@FindBy(name = "identity")
	WebElement userName;

	@FindBy(name = "password")
	WebElement passWord;
	@FindBy(css = "form#signin button[type=\"submit\"]")
	WebElement btnLogin;

	public LoginPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void Login(String Username, String Password) {
		userName.sendKeys(Username);
		passWord.sendKeys(Password);
		btnLogin.click();
	}
	public String GetErrMessage() {
		String message = driver.findElement(By.cssSelector(".help-block")).getText();
		return message;
	}
}
