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

    @FindBy (css="div#sidebar-right div.widget-header__title")
    WebElement titleHoteExp;
    @FindBy (css=" div#sidebar-right div.widget.js-widget-lang-curr > div > div:nth-child(1) > div > span:nth-child(1)")
    WebElement languageVI;
    @FindBy (css="div#sidebar-right div.widget.js-widget-lang-curr > div > div:nth-child(1) > div > span:nth-child(2)")
    WebElement languageEng;
    public NewsfeedPage(WebDriver driver){
       this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public boolean checkNewsfeedDisplay(){
        return tabNewsfeed.isDisplayed();
    }
    public boolean checkLanguageNF() {
      String text= titleHoteExp.getText();
      if(text.equals("Hot Experience")) return true;
         return false;
    }
    public void ChangeLanguagetoVI(){
        if (checkLanguageNF() == true) {
            languageVI.click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
