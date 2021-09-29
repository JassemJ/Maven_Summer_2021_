package Express_Page_Object;

import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpressHome extends Reuseable_Annotations_Class_HTML_Report {
    //ExtentTest logger;
    public ExpressHome(WebDriver driver){
        PageFactory.initElements(driver, this);
        //this.logger = Reuseable_Annotations_Class_HTML_Report.logger;
    }

    @FindBy (xpath = "//*[@id='closeModal']")
    WebElement popUp;

    @FindBy (xpath = "//a[text()='Men']")
    WebElement mensTab;

    @FindBy (xpath = "//a[text()='Polos']")
    WebElement polos;

    public void closePopUp(){
        Reusable_Methods_With_Logger.clickIfPopupExist(driver,popUp,"Pop up", logger);
    }

    public void clickMensTab(){
        Reusable_Methods_With_Logger.mouseHover(driver,mensTab,"Men Tab", logger);
    }

    public void clickPolos(){
        Reusable_Methods_With_Logger.clickMethod(driver,polos, "Polos", logger);
    }
}
