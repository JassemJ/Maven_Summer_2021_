package Twitter_API_Page_Object;

import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TwitterLogout extends Reuseable_Annotations_Class_HTML_Report {
    public TwitterLogout(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//*[@id='layers']/div[2]/div/div/div/div/div/div[2]/div[2]/div[2]/div[2]/div/span/span")
    WebElement logoutButton;

    public void clickLogOut(){
        Reusable_Methods_With_Logger.clickMethod(driver,logoutButton,"Logout",logger);
    }
}
