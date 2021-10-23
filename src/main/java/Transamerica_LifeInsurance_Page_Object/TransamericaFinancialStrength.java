package Transamerica_LifeInsurance_Page_Object;

import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class TransamericaFinancialStrength extends Reuseable_Annotations_Class_HTML_Report {
    public TransamericaFinancialStrength(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//*[@id=\"our-parent-company-aegon\"]/div/div/div/div[3]/div/div/a")
    WebElement aegonFactSheet;

    ArrayList<String> tabs = null;

    /**
     * Zoom to 'AEGON FACT SHEET' button
     */
    public void zoomToAegonFactSheet(){
        Reusable_Methods_With_Logger.zoomTo(driver,aegonFactSheet,logger);
    }

    /**
     * Click on 'AEGON FACT SHEET' button
     */
    public void clickAegonFactSheet(){
        Reusable_Methods_With_Logger.clickMethod(driver,aegonFactSheet,"Aegon Fact Sheet",logger);
     }

    /**
     * Switch to the new tab opened
     * @throws InterruptedException
     */
    public void changeToAegonFactSheet() throws InterruptedException {
        tabs = new ArrayList<>(driver.getWindowHandles()); // store tabs in array current tabs 2
        driver.switchTo().window(tabs.get(1)); // switch control to second tab
        Thread.sleep(500);
    }

    /**
     * Close the current tab
     * @throws InterruptedException
     */
    public void closeAegonFactSheet() throws InterruptedException {
        tabs = null;
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close(); // close current tab which is second
        Thread.sleep(500);
        driver.switchTo().window(tabs.get(0)); // switch control to first tab
    }


}
