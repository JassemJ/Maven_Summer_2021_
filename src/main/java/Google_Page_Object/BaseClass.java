package Google_Page_Object;

import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass extends Reuseable_Annotations_Class_HTML_Report { // allows page object class to be static reference
    ExtentTest logger; // empty
    public BaseClass(WebDriver driver) { // driver empty
        PageFactory.initElements(driver, this); // driver = driver from annotations class
        // driver initialized for all elements
    }

        // create static reference for google home page
        public static HomePage homePage(){ // static reference of page object class HomePage
            HomePage homePage = new HomePage(driver);
            return homePage;
        } // homePage will be used in test case homePage.search ...
    // static -> inheritance

    public static SearchResultPage searchResultPage(){ // static reference of page object class HomePage
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        return searchResultPage;
    } // name of reference is searchResultPage it points to SearchResultPage therefore we can do
    // searchResultPage. alias???
    // rather than SearchResultPage. (members private by default)
} // static name pointing to page object class
// make page object method
