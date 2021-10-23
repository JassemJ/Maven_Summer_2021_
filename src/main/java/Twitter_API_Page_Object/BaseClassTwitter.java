package Twitter_API_Page_Object;

import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClassTwitter extends Reuseable_Annotations_Class_HTML_Report {
    public BaseClassTwitter(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public static TwitterLogin twitterLogin(){
        TwitterLogin twitterLogin = new TwitterLogin(driver);
        return twitterLogin;
    }

    public static TwitterHome twitterHome(){
        TwitterHome twitterHome = new TwitterHome(driver);
        return twitterHome;
    }

    public static TwitterLogout twitterLogout(){
        TwitterLogout twitterLogout = new TwitterLogout(driver);
        return twitterLogout;
    }
}
