package Transamerica_LifeInsurance_Page_Object;

import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

/**
 * This class represents Transamerica Index Universal Life Insurance page
 */
public class TransamericaIndexUniversalLifeInsurance extends Reuseable_Annotations_Class_HTML_Report {
    /**
     * Implement Page Object Model
     * @param driver A WebDriver
     */
    public TransamericaIndexUniversalLifeInsurance(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//*[@id='block-themekit-content']/div/div[4]/div/div[2]/div/div[2]/div[1]/div/a")
    WebElement consumerBrochure;

    ArrayList<String> tabs = null; // array to hold tabs of browser

    /**
     * Scroll on Index Universal Life Insurance Page
     * @param num the amount to scroll
     */
    public void scrollIndexUniversalLifeInsurance(int num){
        Reusable_Methods_With_Logger.scrollUpDown(driver,num,logger);
    }


    /**
     * Click "CONSUMER BROCHURE"
     */
    public void clickBrochure(){
        Reusable_Methods_With_Logger.clickMethod(driver,consumerBrochure,"Consumer Brochure",logger);
    }

    /**
     * The consumer brochure is opened in a new tab
     * switch control to that tab
     * @throws InterruptedException
     */
    public void changeToBrochureTab() throws InterruptedException {
        tabs = new ArrayList<>(driver.getWindowHandles()); // store tabs in array current tabs 2
        driver.switchTo().window(tabs.get(1)); // switch control to second tab
        Thread.sleep(500);
    }

    /**
     * Close brochure tab
     * Switch control back to Index Universal Life Insurance tab
     * @throws InterruptedException
     */
    public void closeBrochureTab() throws InterruptedException {
        tabs = null;
        tabs = new ArrayList<>(driver.getWindowHandles()); // get the tabs
        driver.close(); // close current tab which is second
        Thread.sleep(500);
        driver.switchTo().window(tabs.get(0)); // switch control to first tab
    }
}
