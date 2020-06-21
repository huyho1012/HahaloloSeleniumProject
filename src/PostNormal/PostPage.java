package PostNormal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostPage {
	WebDriver driver;
	@FindBy (css = "a#act-nav-single")
	WebElement createPostFunction;
	@FindBy (css = "div#create_post div.note-editable")
	WebElement formPostNormal;
	@FindBy (css = "button#btn-save-post")
	WebElement btnCreatePost;
	
	
	public PostPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void CreatePost(String Content) {
		createPostFunction.click();
		formPostNormal.sendKeys(Content);
		btnCreatePost.click();
btnCreatePost.click();
	}
}
