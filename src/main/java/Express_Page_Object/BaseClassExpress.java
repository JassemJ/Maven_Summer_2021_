package Express_Page_Object;

import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClassExpress extends Reuseable_Annotations_Class_HTML_Report {
    //ExtentTest logger;

    //public BaseClassExpress(WebDriver driver){
        //PageFactory.initElements(driver,this);
    //}

    public static ExpressHome expressHome(){
        ExpressHome expressHome = new ExpressHome(driver);
        return expressHome;
    }

    public static ExpressMensClothing expressMensClothing(){
        ExpressMensClothing expressMensClothing = new ExpressMensClothing(driver);
        return expressMensClothing;
    }

    public static ExpressSolidPolo expressSolidPolo(){
        ExpressSolidPolo expressSolidPolo = new ExpressSolidPolo(driver);
        return expressSolidPolo;
    }

    public static ExpressBag expressBag(){
        ExpressBag expressBag = new ExpressBag(driver);
        return expressBag;
    }

    public static ExpressContactInfo expressContactInfo(){
        ExpressContactInfo expressContactInfo = new ExpressContactInfo(driver);
        return expressContactInfo;
    }
}
