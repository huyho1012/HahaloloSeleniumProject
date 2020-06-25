package Newsfeed;

import Common.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewsfeedPage extends Connection {
    @FindBy (css="nav#menu-primary a:nth-child(1)")
    WebElement tabNewsfeed;
    @FindBy (css="nav#menu-primary a:nth-child(2)")
    WebElement tabExperience;
    @FindBy (css="nav#menu-primary a:nth-child(3)")
    WebElement tabTour;
    @FindBy (css="nav#menu-primary a:nth-child(4)")
    WebElement tabHotel;
    @FindBy (css="nav#menu-primary a:nth-child(5)")
    WebElement tabShopping;
    @FindBy (css="nav#menu-primary a:nth-child(6)")
    WebElement tabFightTicket;

    public NewsfeedPage(WebDriver driver){
       this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public boolean checkNewsfeedDisplay(){
        if(tabNewsfeed.isDisplayed()) return true;
        return false;
    }

}
