package Transamerica_LifeInsurance_Page_Object;

import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

/**
 * This class represents Transamerica Foreign Nationals page
 */
public class TransamericaForeignNationals extends Reuseable_Annotations_Class_HTML_Report {
    /**
     * Implement Page Object Model
     * @param driver A WebDriver
     */
    public TransamericaForeignNationals(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//*[@id='block-themekit-content']/div/div[5]/div[2]/div[1]/div[2]/div[2]/div/div/a")
    WebElement learnMoreNonRes;

    @FindBy (xpath = "//*[@id='block-themekit-content']/div/div[5]/div[2]/div[2]/div[2]/div[2]/div/div/a")
    WebElement learnMoreRes;

    @FindBy (xpath = "//*[@id='block-themekit-content']/div/div[5]/div[2]/div[3]/div[2]/div[2]/div/div/a")
    WebElement learnMoreEstate;

    @FindBy (xpath = "//*[@id='block-themekit-content']/div/div[6]/div[2]/div[1]/div/div[2]/div/div/a")
    WebElement learnMoreGetToKnowUs;

    @FindBy (xpath = "//*[@id='block-themekit-content']/div/div[6]/div[2]/div[2]/div/div[2]/div/div/a")
    WebElement  learnMoreFinancialStrength;

    @FindBy (xpath = "//*[@id=\"block-themekit-content\"]/div/div[6]/div[2]/div[3]/div/div[2]/div/div/a")
    WebElement learnMoreCredibility;

    ArrayList<String> tabs = null;

    /**
     * Click 'Nonresident underwriting guide'
     */
    public void clickLearnMoreNonRes(){
        Reusable_Methods_With_Logger.clickMethod(driver,learnMoreNonRes,"Nonresident underwriting guide",logger);
    }

    /**
     * Click 'Resident and foreign travel underwriting guide'
     */
    public void clickLearnMoreRes(){
        Reusable_Methods_With_Logger.clickMethod(driver,learnMoreRes,"Resident and foreign travel underwriting guide",logger);
    }

    /**
     * Click 'Estate tax guide for foreign nationals'
     */
    public void clickLearnMoreEstate(){
        Reusable_Methods_With_Logger.clickMethod(driver,learnMoreEstate,"Estate tax guide for foreign nationals",logger);
    }


    /**
     * Switch to the new tab opened
     * @throws InterruptedException
     */
    public void changeToNew() throws InterruptedException {
        tabs = new ArrayList<>(driver.getWindowHandles()); // store tabs in array current tabs 2
        driver.switchTo().window(tabs.get(1)); // switch control to second tab
        Thread.sleep(500);
    }

    /**
     * Close the current tab
     * @throws InterruptedException
     */
    public void closeTab() throws InterruptedException {
        tabs = null;
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close(); // close current tab which is second
        Thread.sleep(500);
        driver.switchTo().window(tabs.get(0)); // switch control to first tab
    }

    /**
     * Click 'Get To Know Us'
     */
    public void clickGetToKnowUs(){
        Reusable_Methods_With_Logger.clickMethod(driver,learnMoreGetToKnowUs,"Get to know us",logger);
    }

    /**
     * Click 'Our Financial Strength'
     */
    public void clickFinancialStrength(){
        Reusable_Methods_With_Logger.clickMethod(driver,learnMoreFinancialStrength,"Our financial strength",logger);
    }

    /**
     * Click 'Our credibility'
     */
    public void clickOurCredibility(){
        Reusable_Methods_With_Logger.clickMethod(driver,learnMoreCredibility,"Our credibility",logger);
    }

    /**
     * Zoom to Get Started
     */
    public void zoomToLearnMore(){
        Reusable_Methods_With_Logger.zoomTo(driver,learnMoreRes,logger);
    }

    /**
     * Zoom to Why TransAmerica
     */
    public void zoomToWhyTransAmerica(){
        Reusable_Methods_With_Logger.zoomTo(driver,learnMoreFinancialStrength,logger);
    }


    /**
     * This functions allows to scroll up and down on TransAmerica Final Expense page
     * @param num the amount we want to scroll
     */
    public void scrollForeignNationals(int num){
        Reusable_Methods_With_Logger.scrollUpDown(driver,num,logger);
    }
}
