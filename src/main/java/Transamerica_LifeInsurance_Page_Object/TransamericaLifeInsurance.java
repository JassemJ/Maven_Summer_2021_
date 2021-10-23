package Transamerica_LifeInsurance_Page_Object;

import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class represents Transamerica Life Insurance page
 */
public class TransamericaLifeInsurance extends Reuseable_Annotations_Class_HTML_Report {
    public TransamericaLifeInsurance(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    /**
     * Implement Page Object Model
     * @param driver A WebDriver
     */
    @FindBy (xpath = "//h2[text()='Term Life Insurance']")
    WebElement tli; // term life insurance

    @FindBy (xpath = "//*[@id='index-universal-life-insurance']")
    WebElement iuli; // index universal life insurance

    @FindBy (xpath = "//*[@id='final-expense-life-insurancenbsp']")
    WebElement feli; // final expense life insurance

    @FindBy (xpath = "//*[@id='final-expense-life-insurancenbsp']")
    WebElement wli; // whole life insurance

    @FindBy (xpath = "//*[@id='life-insurance-for-foreign-nationals']")
    WebElement lifn; // life insurance for foreign nationals


    /**
     * This method scrolls to Term Life Insurance summary
     */
    public void zoomToTermLifeInsurance(){
        Reusable_Methods_With_Logger.zoomTo(driver,tli,logger);
    }

    /**
     * This method scrolls to Index Universal Life Insurance summary
     */
    public void zoomToIndexUniversalLifeInsurance(){
        Reusable_Methods_With_Logger.zoomTo(driver,iuli,logger);
    }

    /**
     * This method scrolls to Final Expense Insurance summary
     */
    public void zoomToFinalExpenseLifeInsurance(){
        Reusable_Methods_With_Logger.zoomTo(driver,feli,logger);
    }

    /**
     * This method scrolls to Whole Life Insurance summary
     */
    public void zoomToWholeLifeInsurance(){
        Reusable_Methods_With_Logger.zoomTo(driver,wli,logger);
    }

    /**
     * This method scrolls to Foreign Nationals summary
     */
    public void zoomToLifeInsuranceForForeignNationals(){
        Reusable_Methods_With_Logger.zoomTo(driver,lifn,logger);
    }

    //public void zoomToLifeInsurance(){
        //Reusable_Methods_With_Logger.zoomTo(driver,iuli,logger);
    //}


}
