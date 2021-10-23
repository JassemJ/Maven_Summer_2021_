package Transamerica_LifeInsurance_Page_Object;

import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * This class represents Transamerica Term Life Insurance page
 */
public class TransamericaTermLifeInsurance extends Reuseable_Annotations_Class_HTML_Report {
    /**
     * Implement Page Object Model
     * @param driver A WebDriver
     */
    public TransamericaTermLifeInsurance(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath="//button[@data-micromodal-trigger='video-modal--billboard-5806']")
    WebElement playButton;

    @FindBy (xpath="//*[@id='kv-video-player-1']")
    WebElement popUpPlayButton;

    @FindBy (xpath="//*[@id='video-modal--billboard-5806']/div/div/button")
    WebElement popUpClosePlayButton;

    @FindBy (xpath = "//*[@id='ac-trigger-0']/div")
    WebElement shouldTheyBuyTLI;

    @FindBy (xpath = "//*[@id='ac-trigger-1']/div")
    WebElement howDoesTLIWork;

    @FindBy (xpath = "//*[@id='ac-trigger-2']/div")
    WebElement whatDoesTLICover;

    @FindBy (xpath = "//*[@id='ac-trigger-3']/div")
    WebElement howMuchTLI;

    @FindBy (xpath = "//*[@id='ac-trigger-4']/div")
    WebElement bestTermLifePolicy;

    @FindBy (xpath = "//*[@id='ac-trigger-5']/div")
    WebElement cost;

    @FindBy (xpath = "//*[@id='ac-trigger-6']/div")
    WebElement choice;

    @FindBy (xpath = "//*[@id='ac-trigger-7']/div")
    WebElement duration;

    @FindBy (xpath = "//*[@id='ac-trigger-8']/div")
    WebElement liveThrough;

    @FindBy (xpath = "//*[@id='ac-trigger-9']/div")
    WebElement cancel;

    @FindBy (xpath = "//*[@id='ac-trigger-10']/div")
    WebElement borrow;

    @FindBy (xpath = "//*[@id='ac-trigger-11']/div")
    WebElement taxable;

    @FindBy (xpath = "//*[@id='ac-trigger-12']/div")
    WebElement buy;

    @FindBy (xpath = "//*[@id='block-themekit-content']/div/div[9]/div/div[2]/div/div[3]/div/div/a")
    WebElement findAnAgent;

    /**
     * Click play button on picture
     */
    public void clickPlay(){
        Reusable_Methods_With_Logger.clickMethod(driver,playButton,"Play Button",logger);
    }

    /**
     * Click Play on the video shown on pop up
     */
    public void popUpClickPlay(){
        driver.switchTo().frame(0); // iframe video not in original frame
        Reusable_Methods_With_Logger.clickMethod(driver, popUpPlayButton, "Pop Up Play Button",logger);
        driver.switchTo().defaultContent(); // go back to original
    }

    /**
     * Close video pop up
     */
    public void closeVideoPopUp(){
        Reusable_Methods_With_Logger.clickMethod(driver,popUpClosePlayButton,"Closing the pop up video",logger);
    }

    /**
     * Scroll to 'Should they buy term life insurance?'
     */
    public void zoomShouldTheyBuyTLI(){
        Reusable_Methods_With_Logger.zoomTo(driver,shouldTheyBuyTLI,logger);
    }

    /**
     * Click 'Should they buy term life insurance?'
     */
    public void clickShouldTheyBuyTLI(){
        Reusable_Methods_With_Logger.clickMethod(driver,shouldTheyBuyTLI,"Should they buy life insurance",logger);
    }

    /**
     * Scroll to 'How does term life insurance work?'
     */
    public void zoomHowDoesTLIWork(){
        Reusable_Methods_With_Logger.zoomTo(driver,howDoesTLIWork,logger);
    }

    /**
     * Click 'How does term life insurance work?'
     */
    public void clickHowDoesTLIWork(){
        Reusable_Methods_With_Logger.clickMethod(driver,howDoesTLIWork,"How does term life insurance work?",logger);
    }

    /**
     * Scroll to 'What does term life insurance cover?'
     */
    public void zoomWhatDoesTLICover(){
        Reusable_Methods_With_Logger.zoomTo(driver,whatDoesTLICover,logger);
    }

    /**
     * Click 'What does term life insurance cover?'
     */
    public void clickWhatDoesTLICover(){
        Reusable_Methods_With_Logger.clickMethod(driver,whatDoesTLICover,"What does term life insurance cover?",logger);
    }

    /**
     * Scroll to 'How much term life insurance do they need?'
     */
    public void zoomHowMuchTermLifeDoTheyNeed(){
        Reusable_Methods_With_Logger.zoomTo(driver,howMuchTLI,logger);
    }

    /**
     * Click 'How much term life insurance do they need?'
     */
    public void clickHowMuchTermLifeDoTheyNeed(){
        Reusable_Methods_With_Logger.clickMethod(driver,howMuchTLI,"How much term life insurance do they need?",logger);
    }

    /**
     * Scroll to 'What is the best term life policy?'
     */
    public void zoomBestTermPolicy(){
        Reusable_Methods_With_Logger.zoomTo(driver,bestTermLifePolicy,logger);
    }

    /**
     * Click 'What is the best term life policy?'
     */
    public void clickBestTermPolicy(){
        Reusable_Methods_With_Logger.clickMethod(driver,bestTermLifePolicy,"What is the best term life policy?",logger);
    }

    /**
     * Scroll to 'How much does term life insurance cost?'
     */
    public void zoomInsuranceCost(){
        Reusable_Methods_With_Logger.zoomTo(driver,cost,logger);
    }

    /**
     * Click 'How much does term life insurance cost?'
     */
    public void clickInsuranceCost(){
        Reusable_Methods_With_Logger.clickMethod(driver,cost,"How much does term life insurance cost?",logger);
    }

    /**
     * Scroll to 'Which term life insurance policy should a client get?'
     */
    public void zoomPolicyToReceive(){
        Reusable_Methods_With_Logger.zoomTo(driver,choice,logger);
    }

    /**
     * Click 'Which term life insurance policy should a client get?'
     */
    public void clickPolicyToReceive(){
        Reusable_Methods_With_Logger.clickMethod(driver,choice,"Which term life insurance policy should a client get?",logger);
    }

    /**
     * Scroll to 'How long is term life insurance?'
     */
    public void zoomHowLongIsInsurance(){
        Reusable_Methods_With_Logger.zoomTo(driver,duration,logger);
    }

    /**
     * Click 'How long is term life insurance?'
     */
    public void clickHowLongIsInsurance(){
        Reusable_Methods_With_Logger.clickMethod(driver,duration,"How long is term life insurance?",logger);
    }

    /**
     * Scroll to 'What if the insured individual lives through the level term policy?'
     */
    public void zoomLiveThroughInsurance(){
        Reusable_Methods_With_Logger.zoomTo(driver,liveThrough,logger);
    }

    /**
     * Click 'What if the insured individual lives through the level term policy?'
     */
    public void clickLiveThroughInsurance(){
        Reusable_Methods_With_Logger.clickMethod(driver,liveThrough,"What if the insured individual lives through the level term policy?",logger);
    }

    /**
     * Scroll to 'Can customers cancel term life insurance?'
     */
    public void zoomCanCancel(){
        Reusable_Methods_With_Logger.zoomTo(driver,cancel,logger);
    }

    /**
     * Click 'Can customers cancel term life insurance?'
     */
    public void clickCanCancel(){
        Reusable_Methods_With_Logger.clickMethod(driver,cancel,"Can customers cancel term life insurance?",logger);
    }

    /**
     * Scroll to 'Can customers borrow against their term life insurance?'
     */
    public void zoomCanBorrow(){
        Reusable_Methods_With_Logger.zoomTo(driver,borrow,logger);
    }

    /**
     * Click 'Can customers borrow against their term life insurance?'
     */
    public void clickCanBorrow(){
        Reusable_Methods_With_Logger.clickMethod(driver,borrow,"Can customers borrow against their term life insurance?",logger);
    }

    /**
     * Scroll to 'Is term life insurance taxable?'
     */
    public void zoomIsTaxable(){
        Reusable_Methods_With_Logger.zoomTo(driver,taxable,logger);
    }

    /**
     * Click 'Is term life insurance taxable?'
     */
    public void clickIsTaxable(){
        Reusable_Methods_With_Logger.clickMethod(driver,taxable,"Is term life insurance taxable?",logger);
    }

    /**
     * Scroll to 'How can customers buy term life insurance?'
     */
    public void zoomCanBuy(){
        Reusable_Methods_With_Logger.zoomTo(driver,buy,logger);
    }

    /**
     * Click 'How can customers buy term life insurance?'
     */
    public void clickCanBuy(){
        Reusable_Methods_With_Logger.clickMethod(driver,buy,"How can customers buy term life insurance?",logger);
    }

    /**
     * Scroll up and down on Term Life Insurance page
     * @param num the amount to scroll
     */
    public void scrollTermLifeInsurance(int num){
        Reusable_Methods_With_Logger.scrollUpDown(driver,num,logger);
    }

    /**
     * Zoom to 'SEARCH FOR AN AGENT'
     */
    public void zoomToFindAgent(){
        Reusable_Methods_With_Logger.zoomTo(driver,findAnAgent,logger);
    }

    /**
     * Click 'SEARCH FOR AN AGENT'
     */
    public void clickToFindAgent(){
        Reusable_Methods_With_Logger.clickMethod(driver,findAnAgent,"Find an Agent",logger);
    }
}
