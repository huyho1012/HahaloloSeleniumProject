package PersonalWall;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Common.Connection;
import Common.Dummy;
import Login.LoginPage;
import PostNormal.PostPage;

public class PersonalPage extends Connection {

	@FindBy (css = "header#menu-top div.uri-name")
	WebElement userLink;
	
	@FindBy (css = "section#main-content div:nth-child(3) > div.post-body > div > div > div")
	WebElement contentPost;
	
	@FindBy (css = "section#main-content div:nth-child(3) > div.post-head > div.post-head__options.dropdown > span")
	WebElement menuPostAction;
	@FindBy (css = "section#main-content div:nth-child(3) > div.post-head > div.post-head__options.dropdown.show > div > div:nth-child(2) > span")
	WebElement delelePost ;
	@FindBy(css = "div#js_editor_delete_post button[type=\"button\"].btn.btn-sm.btn-danger.px-3")
	WebElement btnConfirm;
	public PersonalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
