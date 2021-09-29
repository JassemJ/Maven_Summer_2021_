package Express_Page_Object;

import Reuseable_Classes_.Reusable_Methods;
import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpressBag extends Reuseable_Annotations_Class_HTML_Report {
    public ExpressBag(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath="//select[@id='qdd-0-quantity']")
    WebElement quantity;

    @FindBy (xpath="//button[@id='continue-to-checkout']")
    WebElement checkout;

    @FindBy (xpath="//*[text()='Checkout as Guest']")
    WebElement guest;

    public void changeQuantity(String qty){
        Reusable_Methods_With_Logger.selectMethod(driver,quantity,qty,"Quantity",logger);
    }

    public void checkOut(){
        Reusable_Methods_With_Logger.clickMethod(driver, checkout, "Checkout button",logger);
    }

    public void checkOutAsGuest(){
        Reusable_Methods_With_Logger.clickMethod(driver, guest, "Checkout as guest",logger);
    }
}
