package day11_8_21_2021;

import Reuseable_Classes_.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class googlesearch_testNG {
    WebDriver driver=null;

    @BeforeSuite
    public void setTheChromeDriver() throws IOException {
        driver = Reusable_Methods.setDriver();
    }//end of before suite

    @Test(priority = 1)
    public void searchForCar() throws InterruptedException {
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        Reusable_Methods.sendKeysMethod(driver,"//*[@name='q']","cars","Search Field");
        Reusable_Methods.submitMethod(driver,"//*[@name='btnK']","Search Button");
        Thread.sleep(2500);
    }//end of test 1

    @Test(dependsOnMethods = "searchForCar")
    public void captureTheSearchNumber(){
        //capture the search result content
        String result = Reusable_Methods.getText(driver,"//*[@id='result-stats']","Search Result");
        String[] arrayResult = result.split(" ");
        System.out.println("Search number is " + arrayResult[1]);
    }//end of test 2

    @AfterSuite
    public void closeTheDriver() {
        driver.quit();
    }
}


