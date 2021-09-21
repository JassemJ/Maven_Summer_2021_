package Google_Page_Object;

import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Reuseable_Annotations_Class_HTML_Report { // page object class

    ExtentTest logger; // empty
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this); // driver = driver from annotations class
        // driver initialized for all elements
        this.logger= Reuseable_Annotations_Class_HTML_Report.logger; // logger (line 12) = logger from html report
    }

    // set up all web elements xpath locators I need for this page
    @FindBy(xpath = "//*[@name='q']") // string
    WebElement searchField; // WebElement defined by above locator

    @FindBy(xpath = "//*[@name='btnK']")
    WebElement googleSearchButton;

    // method to type on search field

    public void searchAKeyWord(String myText){ // these are private   // methods are currently local to page object class
        Reusable_Methods_With_Logger.sendKeysMethod(driver, searchField, myText, "Search Field", logger);
    }

    public void googleSearchSumbit(){
        Reusable_Methods_With_Logger.submitMethod(driver,googleSearchButton,"Google search button",logger);
    }

}
