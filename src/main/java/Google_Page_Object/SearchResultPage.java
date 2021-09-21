package Google_Page_Object;

import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage extends Reuseable_Annotations_Class_HTML_Report {

    ExtentTest logger; // empty
    public SearchResultPage(WebDriver driver){
        PageFactory.initElements(driver, this); // driver = driver from annotations class
        // driver initialized for all elements
        this.logger= Reuseable_Annotations_Class_HTML_Report.logger; // logger (line 12) = logger from html report
    }

    // set up all web elements xpath locators I need for this page
    @FindBy(xpath = "//*[@id='result-stats']") // string
            WebElement searchResultText; // WebElement defined by above locator


    public void getSearchNumber(){ // these are private   // methods are currently local to page object class
        //Reuse 2:42:51
        String results = Reusable_Methods_With_Logger.getText(driver, searchResultText, "Search Result", logger);
        String[] arrayResults = results.split(" ");
        System.out.println("My search number is "+arrayResults[1]);
        logger.log(LogStatus.INFO,"My search number is "+arrayResults[1] );

    }

}
