package Transamerica_LifeInsurance_Page_Object;

import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class represents the page for agents to create
 * an account to have their clients receive coverage
 */
public class TransamericaSecureAccount extends Reuseable_Annotations_Class_HTML_Report {
    /**
     * Implement Page Object Model
     * @param driver A WebDriver
     */
    public TransamericaSecureAccount(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//*[@id='registrationForm']/fieldset/div[1]/div/div/div[1]/div/label/div")
    WebElement financialProfessional;

    @FindBy (xpath = "//*[@id='registrationForm']/fieldset/div[1]/div/div/div[2]/div/label/div")
    WebElement financialCorporation;

    @FindBy (xpath = "//*[@id='last']")
    WebElement lastName; // business name

    @FindBy (xpath = "//*[@id='dob']")
    WebElement dateOfBirth;

    @FindBy (xpath = "//*[@id='advisorNumber']")
    WebElement advisorNumber;

    @FindBy (xpath = "//*[@id='primaryButton']")
    WebElement nextButton;

    @FindBy (xpath = "//*[@id='ssnMasked']")
    WebElement taxIdentificationNumber;

    @FindBy (xpath = "//*[@id='main-error']/div/div[2]/strong")
    WebElement error;

    /**
     * Click 'Financial Professional'
     */
    public void clickFinancialProfessional(){
        Reusable_Methods_With_Logger.clickMethod(driver,financialProfessional,"Financial Professional", logger);
    }

    /**
     * Click 'Financial Corporation'
     */
    public void clickFinancialCorporation(){
        Reusable_Methods_With_Logger.clickMethod(driver,financialCorporation,"Financial Corporation",logger);
    }

    /**
     * Sends text to 'Last Name'
     * @param lName the last name
     */
    public void sendLastName(String lName){
        Reusable_Methods_With_Logger.sendKeysMethod(driver,lastName,lName,"Last Name",logger);
    }

    /**
     * Sends text to 'Business Name'
     * @param businessName the name of the business
     */
    public void sendBusinessName(String businessName){
        Reusable_Methods_With_Logger.sendKeysMethod(driver,lastName,businessName,"Business Name",logger);
    }

    /**
     * Send text to 'Tax Identification Number'
     * @param TIN 9 digit number 000-00-0000
     */
    public void sendTIN(String TIN){
        Reusable_Methods_With_Logger.sendKeysMethod(driver,taxIdentificationNumber,TIN,"Business Name",logger);
    }

    /**
     * Send text to 'Date of Birth'
     * @param dob Date of Birth MM/DD/YYYY
     */
    public void sendDOB(String dob){
        Reusable_Methods_With_Logger.sendKeysMethod(driver,dateOfBirth,dob,"Date of Birth",logger);
    }

    /**
     * Send text to 'Advisor Number'
     * @param advisorNum digit associated with advisor
     */
    public void sendAdvisorNumber(String advisorNum){
        Reusable_Methods_With_Logger.sendKeysMethod(driver,advisorNumber,advisorNum,"Advisor Number", logger);
    }

    /**
     * Scroll on Secure Account Page
     * @param num the amount to scroll
     */
    public void scrollAccount(int num){
        Reusable_Methods_With_Logger.scrollUpDown(driver,num,logger);
    }

    /**
     * Clicks 'NEXT'
     * @throws InterruptedException
     */
    public void hitNext() throws InterruptedException {
        Thread.sleep(7000); // Delay to enter CAPTCHA
        Reusable_Methods_With_Logger.clickMethod(driver,nextButton,"Next", logger);
    }

    /**
     * Takes screenshot of Error message visible in report
     */
    public void captureErrorMessage(){
        Reusable_Methods_With_Logger.getScreenShot(driver,"Error",logger, true);
        Reusable_Methods_With_Logger.getText(driver,error,"Error message",logger);
    }

}
