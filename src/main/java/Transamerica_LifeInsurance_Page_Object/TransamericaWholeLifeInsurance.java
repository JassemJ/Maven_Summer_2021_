package Transamerica_LifeInsurance_Page_Object;

import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

/**
 * This class represents Transamerica Whole Life Insurance page
 */
public class TransamericaWholeLifeInsurance extends Reuseable_Annotations_Class_HTML_Report {
    /**
     * Implement Page Object Model
     * @param driver A WebDriver
     */
    public TransamericaWholeLifeInsurance(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id='overview']/div/div[2]/div/div[2]/div/div/button")
    WebElement watchNow;

    @FindBy(xpath = "//*[@id='kv-video-player-1']/button/div/img")
    WebElement popUpPlayButton;

    @FindBy (xpath = "//*[@id='video-modal-10761']/div/div/button")
    WebElement XButton;

    @FindBy (xpath = "//*[@id='apply']/div/div/div/div[3]/div/div/a")
    WebElement registerNow;

    ArrayList<String> tabs = null;

    /**
     * Clicks 'WATCH NOW'
     */
    public void clickWatchNow(){
        Reusable_Methods_With_Logger.clickMethod(driver,watchNow,"Watch Now",logger);
    }

    /**
     * Click triangle play button on pop up video
     */
    public void popUpClickPlay(){
        driver.switchTo().frame(0); // iframe video not in original frame
        Reusable_Methods_With_Logger.clickMethod(driver, popUpPlayButton, "Pop Up Play Button",logger);
        driver.switchTo().defaultContent(); // go back to original
    }

    /**
     * Close pop up video
     */
    public void closePopUp(){
        Reusable_Methods_With_Logger.clickMethod(driver,XButton,"Pop Up Video X Button", logger);
    }

    /**
     * Click 'REGISTER NOW'
     */
    public void clickRegisterNow(){
        Reusable_Methods_With_Logger.clickMethod(driver,registerNow,"Register Now",logger);
    }

    /**
     * Switch to the 'Create Account 'tab opened with 'REGISTER NOW'
     * @throws InterruptedException
     */
    public void changeToRegisterTab() throws InterruptedException {
        tabs = new ArrayList<>(driver.getWindowHandles()); // store tabs in array current tabs 2
        driver.switchTo().window(tabs.get(1)); // switch control to second tab
        Thread.sleep(500);
    }

    /**
     * Close the 'Create Account' tab
     * Switch control to 'Whole Life Insurance' tab
     * @throws InterruptedException
     */
    public void closeRegisterTab() throws InterruptedException {
        tabs = null;
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close(); // close current tab which is second
        Thread.sleep(500);
        driver.switchTo().window(tabs.get(0)); // switch control to first tab
    }


    /**
     * Scroll on Whole Life insurance page
     * @param num the amount to scroll
     */
    public void scrollWholeLifeInsurance(int num){
        Reusable_Methods_With_Logger.scrollUpDown(driver,num,logger);
    }


}
