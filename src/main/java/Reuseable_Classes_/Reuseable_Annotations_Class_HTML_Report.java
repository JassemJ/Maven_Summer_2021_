package Reuseable_Classes_;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;

public class Reuseable_Annotations_Class_HTML_Report {
    public static WebDriver driver;
    public static ExtentReports reports; // our report for developer add to html report see what passed and failed // name of report where we want to save
    public static ExtentTest logger; // what we want to print
    // logger for report
    @BeforeSuite // before test open what is necessary
    public void setUp() throws IOException { // set driver and report
        driver = Reusable_Methods_With_Logger.setDriver();
        //define the path to the report where you going to save your report
        reports = new ExtentReports("src/main/java/Extent_Report/AutomationReport.html",true); // true means allow to replace
    }//end of before suite


    //before method will take the name of @Test method and store it in the report to track
    @BeforeMethod // run before each @Test method
    public void getTestName(Method testName) {
        logger = reports.startTest(testName.getName()); // get methods under @Test store in report and in log for printing
        // store name to report after function has run
    }//end of before method
// logger same as System.out.print.();

    @AfterMethod // run after each @Test method
    public void finishTest() { // after all methods captured end logger
        reports.endTest(logger); // end log // you can see methods done after a @Test finish rather than wait for entire suite to finish
        // try refreshing browser
    }//end of before method


    @AfterSuite  // test complete close what is necessary
    public void quitSession() {
        reports.flush(); //write back to report
        driver.quit();
    }
    //end of after suite
    // runs after all @test finish
}
