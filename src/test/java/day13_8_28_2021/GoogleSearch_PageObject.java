package day13_8_28_2021;

import Google_Page_Object.BaseClass;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.testng.annotations.Test;

public class GoogleSearch_PageObject extends Reuseable_Annotations_Class_HTML_Report {
    // code from Reuseable_Annotations_Class_HTML_Report copied
    // therefore beforesuit, after, ... all will run
    @Test
    public void SearchSomethingGoogleHome() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2500);
        BaseClass.homePage().searchAKeyWord("Cars"); // reuseable from page object class
        // home page         // base class
        BaseClass.homePage().googleSearchSumbit();
    }

    @Test(dependsOnMethods = "SearchSomethingGoogleHome")
    public void GetSearchNumber() throws InterruptedException {
        Thread.sleep(2500);
        BaseClass.searchResultPage().getSearchNumber();
    }

}

// page object makes code more reuseable and manageable all web element defined once if property changes then change 1 value