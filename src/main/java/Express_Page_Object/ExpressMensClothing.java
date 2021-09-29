package Express_Page_Object;

import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpressMensClothing extends Reuseable_Annotations_Class_HTML_Report {
    public ExpressMensClothing(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//*[@class='cdS1D9eKI7bXTMHp5xeAA']")
    WebElement firstPolo;

    public void clickPolo(){
        Reusable_Methods_With_Logger.clickMethod(driver,firstPolo,"First Polo",logger);
    }
}
