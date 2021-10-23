package Transamerica_LifeInsurance_Page_Object;

import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

/**
 * This class represents Transamerica Final Expense Life Insurance Page
 */
public class TransamericaFELifeInsurance extends Reuseable_Annotations_Class_HTML_Report {
    /**
     * Implement Page Object Model
     * @param driver A WebDriver
     */
    public TransamericaFELifeInsurance(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    ArrayList<String> tabs = null;

    @FindBy(xpath = "//*[@id='block-themekit-content']/div/div[6]/div/div/div/div[3]/div/div/a")
    WebElement runAQuote;

    @FindBy(xpath = "//*[@id='block-themekit-content']/div/div[7]/div/div/div/div[2]/div/div/a")
    WebElement learnMore;

    /**
     * Scroll to 'RUN A QUOTE'
     */
    public void zoomToRunAQuote(){
        Reusable_Methods_With_Logger.zoomTo(driver,runAQuote,logger);
    }

    /**
     * Zoom to 'LEARN MORE' button
     */
    public void zoomToLearnMore(){
        Reusable_Methods_With_Logger.zoomTo(driver,learnMore,logger);
    }

    /**
     * Click 'RUN A QUOTE'
     */
    public void clickRunAQuote(){
        Reusable_Methods_With_Logger.clickMethod(driver,runAQuote,"RUN A QUOTE",logger);
    }


    /**
     * Switch to the new tab opened 'myTransware Final Expense - Solution'
     * @throws InterruptedException
     */
    public void changeToRunAQuote() throws InterruptedException {
        tabs = new ArrayList<>(driver.getWindowHandles()); // store tabs in array current tabs 2
        driver.switchTo().window(tabs.get(1)); // switch control to second tab
        Thread.sleep(500);
    }

    /**
     * Close the current tab
     * Switch control to 'Final Expense Life Insurance' tab
     * @throws InterruptedException
     */
    public void closeRunAQuote() throws InterruptedException {
        tabs = null;
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close(); // close current tab which is second
        Thread.sleep(500);
        driver.switchTo().window(tabs.get(0)); // switch control to first tab
    }

    /**
     * Click 'LEARN MORE'
     */
    public void clickLearnMore(){
        Reusable_Methods_With_Logger.clickMethod(driver,learnMore,"Learn More", logger);
    }


    /**
     * This functions allows to scroll up and down on TransAmerica Final Expense page
     * @param num the amount we want to scroll
     */
    public void scrollWholeLifeInsurance(int num){
        Reusable_Methods_With_Logger.scrollUpDown(driver,num,logger);
    }
}
