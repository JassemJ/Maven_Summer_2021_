package Transamerica_LifeInsurance_Page_Object;

import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransamericaRunAQuote extends Reuseable_Annotations_Class_HTML_Report {
    public TransamericaRunAQuote (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id='ProductId']")
    WebElement productSelect;

    @FindBy (xpath = "//*[@id='pcAgeId']")
    WebElement ageSelect;

    @FindBy (xpath = "//*[@id='pcStateId']")
    WebElement stateSelect;

    @FindBy (xpath = "//*[@id='pcSexId']")
    WebElement genderSelect;

    @FindBy (xpath = "//*[@id='pcRiskClassId']")
    WebElement riskClassSelect;

    @FindBy (xpath = "//*[@id='svSolveId']")
    WebElement solveSelect;

    @FindBy (xpath = "//*[@id='svSolveId']")
    WebElement faceAmountSelect;


    @FindBy (xpath = "//*[@id='svPremium']")
    WebElement premiumAmount;

    @FindBy (xpath = "//*[@id='psPremiumModeId']")
    WebElement premiumModeSelect;

    @FindBy (xpath = "//*[@id='acDBTypeId']")
    WebElement benefitRiderSelect;

    @FindBy (xpath = "//*[@id='ciUnitsId']")
    WebElement benefitAmountSelect;

    @FindBy (xpath = "//*[@id='svFaceAmount']")
    WebElement faceAmount;

    @FindBy (xpath = "//*[@id='quoteButtonLabel']")
    WebElement viewQuote;

    @FindBy (xpath = "//*[@id='closeSummaryQuote']")
    WebElement close;



    /**
     * Select a prodduct
     * @param product ex. 10 pay Solution (2021)
     */
    public void selectProduct(String product){
        Reusable_Methods_With_Logger.selectMethod(driver,productSelect,product,"Product",logger);
    }

    /**
     * Select age
     * @param age The desired age
     */
    public void selectAge(String age) throws InterruptedException {
        Thread.sleep(500);
        Reusable_Methods_With_Logger.selectMethod(driver,ageSelect,age,"Age",logger);
    }

    /**
     * Select state
     * @param state The desired state
     */
    public void selectState(String state){
        Reusable_Methods_With_Logger.selectMethod(driver,stateSelect,state,"State",logger);
    }

    /**
     * Select gender
     * @param gender The desired gender
     */
    public void selectGender(String gender){
        Reusable_Methods_With_Logger.selectMethod(driver,genderSelect,gender,gender,logger);
    }

    /**
     * Select risk class
     * @param riskClass ex. Standard Tobacco
     */
    public void selectRiskClass(String riskClass){
        Reusable_Methods_With_Logger.selectMethod(driver,riskClassSelect,riskClass,riskClass,logger);
    }

    /**
     * Select solve
     * @param solve ex Solve For Premium Amount
     */
    public void selectSolve(String solve) throws InterruptedException {
        Thread.sleep(500);
        Reusable_Methods_With_Logger.selectMethod(driver,solveSelect,solve,solve,logger);
    }

    /**
     * The amount sending to text field
     * @param amount Desired amount
     */
    public void sendFaceAmount(String amount){
        //Reusable_Methods_With_Logger.clickMethod(driver,faceAmount,"Face Amount",logger);
        Reusable_Methods_With_Logger.sendKeysMethod(driver,faceAmount,amount,amount,logger);
    }

    /**
     * Select a premium ex. Annual
     * @param premium
     */
    public void selectPremiumMode(String premium){
        Reusable_Methods_With_Logger.selectMethod(driver,premiumModeSelect,premium,premium,logger);
    }

    /**
     * View Quote
     * @throws InterruptedException
     */
    public void clickViewQuote() throws InterruptedException {
        Reusable_Methods_With_Logger.clickMethod(driver,viewQuote,"View Quote",logger);
        Thread.sleep(500);
        Reusable_Methods_With_Logger.getScreenShot(driver,"Quote",logger,true);
    }
}
