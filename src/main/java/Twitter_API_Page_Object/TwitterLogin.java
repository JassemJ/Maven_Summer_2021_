package Twitter_API_Page_Object;

import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TwitterLogin extends Reuseable_Annotations_Class_HTML_Report {
    public TwitterLogin(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//*[@id='react-root']/div/div/div/main/div/div/div/div[1]/div/div[3]/div[4]/span/span")
    WebElement signIn;

    @FindBy (xpath = "//*[@id='react-root']/div/div/div/main/div/div/div/div[1]/div/div[3]/a/div/span/span")
    WebElement usePhoneUserEmail;

    public void clickSignIn(){
        Reusable_Methods_With_Logger.clickMethod(driver,signIn,"Sign In",logger);
    }

    public void clickUsePhoneUserEmail() throws InterruptedException {
        Reusable_Methods_With_Logger.clickMethod(driver,usePhoneUserEmail,"Use phone, email or username",logger);
        Thread.sleep(10000); // time to sign in
    }

}
