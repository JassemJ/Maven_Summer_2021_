package Twitter_API_Page_Object;

import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TwitterHome extends Reuseable_Annotations_Class_HTML_Report {
    public TwitterHome(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='css-901oao r-1fmj7o5 r-37j5jr r-a023e6 r-16dba41 r-rjixqe r-bcqeeo r-bnwqim r-qvutc0']/span")
    WebElement recentText;

    @FindBy(xpath = "//*[@id='react-root']/div/div/div[2]/header/div/div/div/div[2]/div/div/div[2]")
    WebElement nameIcon;

    @FindBy(xpath = "//*[@id='layers']/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/div/a[2]")
    WebElement logout;


    public String getRecentText() throws InterruptedException {
        return Reusable_Methods_With_Logger.getText(driver,recentText,"Latest Tweet",logger);
        //Thread.sleep(5000);
        //return recentText.getText();

    }

    public void clickNameIcon(){
        Reusable_Methods_With_Logger.clickMethod(driver,nameIcon,"Name Icon",logger);
    }

    public void clickLogOut(){
        Reusable_Methods_With_Logger.clickMethod(driver,logout,"Logout",logger);
    }
}
