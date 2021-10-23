package Transamerica_LifeInsurance_Page_Object;

import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransamericaAgentLocator extends Reuseable_Annotations_Class_HTML_Report {
    public TransamericaAgentLocator(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//*[@class='-pl-md ta-input-override taeOutline']")
    WebElement textField;

    @FindBy (xpath = "/html/body/ta-agent-locator/section/div[1]/div/div/form/div[1]/button")
    WebElement search;



    /**
     * Type zipcode into text box
     * @param zipCode a valid 5 digit number
     */
    public void sendZip(String zipCode) throws InterruptedException {
        Reusable_Methods_With_Logger.sendKeysMethodEmptyField(driver,textField,zipCode,"Zip Code",logger);
        //textField.sendKeys(zipCode);
    }

    /**
     * Click search button
     */
    public void clickSearch(){
        Reusable_Methods_With_Logger.clickMethod(driver,search,"Search button",logger);
    }

    /**
     * Take screenshot of agent locations near zipcode provided
     */
    public void captureAgentAddress(){
        Reusable_Methods_With_Logger.getScreenShot(driver,"Agent Location",logger,true);
    }




}
