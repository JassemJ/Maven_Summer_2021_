package Reuseable_Classes_;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class Reuseable_Annotations_Class {
    public static WebDriver driver;

    @BeforeSuite
    public void setTheDriver() throws IOException {
        driver = Reusable_Methods.setDriver();
    }//end of before suite

    @AfterSuite
    public void quitSession(){
        driver.quit();
    }//end of after suite

}
