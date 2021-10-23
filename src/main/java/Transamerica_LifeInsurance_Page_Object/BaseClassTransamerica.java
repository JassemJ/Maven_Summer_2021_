package Transamerica_LifeInsurance_Page_Object;

import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Return static objects to test case files to use
 * their corresponding methods
 */
public class BaseClassTransamerica extends Reuseable_Annotations_Class_HTML_Report {
    /**
     * Implement Page Object Model
     * @param driver A WebDriver
     */
    public BaseClassTransamerica(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    /**
     * return static Page Class object to use its corresponding methods
     * @return TransamericaHome object
     */
    public static TransamericaHome transamericaHome(){
        TransamericaHome transamericaHome = new TransamericaHome(driver);
        return transamericaHome;
    }

    /**
     * return static Page Class object to use its corresponding methods
     * @return TransamericaLifeInsurance object
     */
    public static TransamericaLifeInsurance transamericaLifeInsurance(){
        TransamericaLifeInsurance transamericaLifeInsurance = new TransamericaLifeInsurance(driver);
        return transamericaLifeInsurance;
    }

    /**
     * return static Page Class object to use its corresponding methods
     * @return TransamericaIndexUniversalLifeInsurance object
     */
    public static TransamericaIndexUniversalLifeInsurance transamericaHomeIndexUniversalLifeInsurance(){
        TransamericaIndexUniversalLifeInsurance transamericaHomeIndexUniversalLifeInsurance = new TransamericaIndexUniversalLifeInsurance(driver);
        return transamericaHomeIndexUniversalLifeInsurance;
    }

    /**
     * return static Page Class object to use its corresponding methods
     * @return TransamericaFinalExpenseLifeInsurance object
     */
    public static TransamericaFELifeInsurance transamericaFELifeInsurance(){
        TransamericaFELifeInsurance transamericaFELifeInsurance = new TransamericaFELifeInsurance(driver);
        return transamericaFELifeInsurance;
    }

    /**
     * return static Page Class object to use its corresponding methods
     * @return TransamericaForeignNationals object
     */
    public static TransamericaForeignNationals transamericaForeignNationals(){
        TransamericaForeignNationals transamericaForeignNationals = new TransamericaForeignNationals(driver);
        return transamericaForeignNationals;
    }

    /**
     * return static Page Class object to use its corresponding methods
     * @return TransamericaWholeLifeInsurance object
     */
    public static TransamericaWholeLifeInsurance transamericaWholeLifeInsurance(){
        TransamericaWholeLifeInsurance transamericaWholeLifeInsurance = new TransamericaWholeLifeInsurance(driver);
        return transamericaWholeLifeInsurance;
    }

    /**
     * return static Page Class object to use its corresponding methods
     * @return TransamericaTermLifeInsurance object
     */
    public static TransamericaTermLifeInsurance transamericaTermLifeInsurance(){
        TransamericaTermLifeInsurance transamericaTermLifeInsurance = new TransamericaTermLifeInsurance(driver);
        return transamericaTermLifeInsurance;
    }

    /**
     * return static Page Class object to use its corresponding methods
     * @return TransamericaSecureAccount object
     */
    public static TransamericaSecureAccount transamericaSecureAccount(){
        TransamericaSecureAccount transamericaSecureAccount = new TransamericaSecureAccount(driver);
        return  transamericaSecureAccount;
    }

    /**
     * return static Page Class object to use its corresponding methods
     * @return TransamericaRunAQuote object
     */
    public static TransamericaRunAQuote transamericaRunAQuote(){
        TransamericaRunAQuote transamericaRunAQuote = new TransamericaRunAQuote(driver);
        return transamericaRunAQuote;
    }

    /**
     * return static Page Class object to use its corresponding methods
     * @return TransamericaFinancialStrength object
     */
    public static TransamericaFinancialStrength transamericaFinancialStrength(){
        TransamericaFinancialStrength transamericaFinancialStrength = new TransamericaFinancialStrength(driver);
        return transamericaFinancialStrength;
    }

    /**
     * return static Page Class object to use its corresponding methods
     * @return TransamericaAgentLocator object
     */
    public static TransamericaAgentLocator transamericaAgentLocator(){
        TransamericaAgentLocator transamericaAgentLocator = new TransamericaAgentLocator(driver);
        return transamericaAgentLocator;
    }
}
