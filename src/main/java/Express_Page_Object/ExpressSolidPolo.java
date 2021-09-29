package Express_Page_Object;

import Reuseable_Classes_.Reusable_Methods;
import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpressSolidPolo extends Reuseable_Annotations_Class_HTML_Report {
    public ExpressSolidPolo(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[text()='Add to Bag']")
    WebElement addBag;

    @FindBy(xpath = "//*[text()='View Bag']")
    WebElement viewMyBag;

    public void clickSize(String size){
        Reusable_Methods_With_Logger.clickMethod(driver,"//*[text()='" + size + "']",size,logger);
    }

    public void addToBag(){
        Reusable_Methods_With_Logger.clickMethod(driver,addBag,"Bag",logger);
    }

    public void viewBag(){
        Reusable_Methods_With_Logger.clickMethod(driver,viewMyBag,"View Bag",logger);
    }
            //Reusable_Methods_With_Logger.clickMethod(driver, "//*[text()='" + size + "']", "Sizes",logger);
    //click Add to Bag
           // Reusable_Methods_With_Logger.clickMethod(driver, "//button[text()='Add to Bag']", "Add to Bag button");
    // Reusable_Methods.clickMethod(driver, "//*[text()='View Bag']", "View Bag button");

}
