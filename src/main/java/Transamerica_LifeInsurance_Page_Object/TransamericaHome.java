package Transamerica_LifeInsurance_Page_Object;

import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class represents the Transamerica home page
 */
public class TransamericaHome extends Reuseable_Annotations_Class_HTML_Report {
    public TransamericaHome(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//a[text()='Insurance']")
    WebElement insuranceTab;

    @FindBy (xpath = "//a[text()='Life Insurance']")
    WebElement lifeInsurance;

    @FindBy (xpath = "//span[text()='Close [x]']")
    WebElement popUp;

    @FindBy (xpath = "//a[text()='Term Life Insurance']")
    WebElement termLifeInsurance;

    @FindBy (xpath = "//a[text()='Index Universal Life Insurance']")
    WebElement indexUniversalLifeInsurance;

    @FindBy (xpath = "//a[text()='Whole Life Insurance']")
    WebElement wholeLifeInsurance;

    @FindBy (xpath = "//a[text()='Final Expense Life Insurance']")
    WebElement finalExpenseLifeInsurance;

    @FindBy (xpath = "//a[text()='Foreign Nationals']")
    WebElement foreignNationals;

    /**
     * This closes the pop up on the website which may or may not appear
     */
    public void closePopUp(){
        Reusable_Methods_With_Logger.clickIfPopupExist(driver, popUp,"PopUp",logger);
    }

    /**
     * This allows to click 'Insurance' which opens a dropdown of insurance options
     */
    public void clickInsurance(){
        Reusable_Methods_With_Logger.clickMethod(driver, insuranceTab,"Insurance",logger);
    }

    /**
     * This clicks 'LIFE INSURANCE' option
     */
    public void clickLifeInsurance(){
        Reusable_Methods_With_Logger.clickMethod(driver, lifeInsurance,"Life Insurance",logger);
    }

    /**
     * This clicks 'Term Life Insurance'
     */
    public void clickTLI(){
        Reusable_Methods_With_Logger.clickMethod(driver,termLifeInsurance,"Term Life Insurance",logger);
    }

    /**
     * This clicks 'Index Universal Life Insurance'
     */
    public void clickIULI(){
        Reusable_Methods_With_Logger.clickMethod(driver,indexUniversalLifeInsurance,"Index Universal Life Insurance",logger);
    }

    /**
     * This clicks 'Whole Life Insurance'
     */
    public void clickWLI(){
        Reusable_Methods_With_Logger.clickMethod(driver,wholeLifeInsurance,"Whole Life Insurance",logger);
    }

    /**
     * This clicks 'Final Expense Life Insurance'
     */
    public void clickFELI(){
        Reusable_Methods_With_Logger.clickMethod(driver,finalExpenseLifeInsurance,"Final Expense Life Insurance",logger);
    }

    /**
     * This clicks 'Foreign Nationals'
     */
    public void clickFN(){
        Reusable_Methods_With_Logger.clickMethod(driver,foreignNationals,"Foreign Nationals",logger);
    }

    /**
     * Scroll up and down on page
     * @param num the amount to scroll
     */
    public void scrollLifeInsurance(int num){
        Reusable_Methods_With_Logger.scrollUpDown(driver,num,logger);
    }



}
