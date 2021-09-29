package Express_Page_Object;

import Reuseable_Classes_.Reusable_Methods;
import Reuseable_Classes_.Reusable_Methods_With_Logger;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpressContactInfo extends Reuseable_Annotations_Class_HTML_Report {
    public ExpressContactInfo(WebDriver Driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//*[@name='firstname']")
    WebElement fName;

    @FindBy (xpath = "//*[@name='lastname']")
    WebElement lName;

    @FindBy (xpath = "//*[@name='email']")
    WebElement email;

    @FindBy (xpath = "//*[@name='confirmEmail']")
    WebElement confirmEmail;

    @FindBy (xpath = "//*[@name='phone']")
    WebElement phone;

    @FindBy (xpath = "//*[text()='Continue']")
    WebElement cont;

    @FindBy (xpath = "//*[@class='close_button-20856-button close_button-20856-button-d2 bluecoreCloseButton']")
    WebElement closePopUp;

    @FindBy (xpath = "//*[@name='shipping.firstName']")
    WebElement shippingFname;

    @FindBy (xpath = "//*[@name='shipping.lastName']")
    WebElement shippinglname;

    @FindBy (xpath = "//*[@name='shipping.line1']")
    WebElement address;

    @FindBy (xpath = "//*[@name='shipping.postalCode']")
    WebElement zipCode;

    @FindBy (xpath = "//*[@name='shipping.city']")
    WebElement city;

    @FindBy (xpath = "//*[@name='shipping.state']")
    WebElement state;

    @FindBy (xpath = "//*[@class='_1Q4iDku_IopeC7OgnKsdoD']")
    WebElement infoDelivery;

    public void sendFName(String first_name){
        Reusable_Methods_With_Logger.sendKeysMethod(driver,fName,first_name,"First name",logger);
    }

    public void sendlName(String last_name){
        Reusable_Methods_With_Logger.sendKeysMethod(driver,lName,last_name,"Last name",logger);
    }

    public void sendEmail(String e_mail){
        Reusable_Methods_With_Logger.sendKeysMethod(driver,email,e_mail,"Email",logger);
    }

    public void confirmEmail(String e_mail){
        Reusable_Methods_With_Logger.sendKeysMethod(driver,confirmEmail,e_mail,"Confirm email",logger);
    }

    public void phone(String phone_num){
        Reusable_Methods_With_Logger.sendKeysMethod(driver,phone,phone_num,"Phone number",logger);
    }

    public void next(){
        Reusable_Methods_With_Logger.clickMethod(driver, cont,"Continue button",logger);
    }

    public void closePopUp(){
        Reusable_Methods_With_Logger.clickIfPopupExist(driver, closePopUp,"Pop up button",logger);
    }

    public void shipFName(String first_name){
        Reusable_Methods_With_Logger.sendKeysMethod(driver,shippingFname,first_name,"First name",logger);
    }

    public void shipLName(String last_name){
        Reusable_Methods_With_Logger.sendKeysMethod(driver,shippinglname,last_name,"Last name",logger);
    }

    public void sendAddress(String address_){
        Reusable_Methods_With_Logger.sendKeysMethod(driver,address,address_,"Location ",logger);
    }

    public void sendPostalCode(String zip){
        Reusable_Methods_With_Logger.sendKeysMethod(driver,zipCode,zip,"Zipcode ",logger);
    }

    public void sendCity(String city_){
        Reusable_Methods_With_Logger.sendKeysMethod(driver,city,city_,"City ",logger);
    }

    public void sendState(String state_){
        Reusable_Methods_With_Logger.selectMethod(driver,state,state_,"State ",logger);
    }

    public String getDeliveryInfo(){
        return Reusable_Methods_With_Logger.getText(driver,infoDelivery,"Delivery Information", logger);
    }


/*            Reusable_Methods.sendKeysMethod(driver, "//*[@name='firstname']", fName, "First name field");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='lastname']", lName, "Last name field");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='email']", email, "Email field");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='confirmEmail']", email, "Confirm email field");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='phone']", phone, "Phone number field");
            Reusable_Methods.clickMethod(driver, "//*[text()='Continue']", "Continue button");
            Reusable_Methods.clickMethod(driver, "//*[@class='close_button-20856-button close_button-20856-button-d2 bluecoreCloseButton']", "Pop up button");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='shipping.firstName']", fName, "First name field");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='shipping.lastName']", lName, "Last name field");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='shipping.line1']", addr, "Street address");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='shipping.postalCode']", zipCode, "Postal code");
            Reusable_Methods.sendKeysMethod(driver, "//*[@name='shipping.city']", city, "City");
            Reusable_Methods.selectMethod(driver, "//select[@name='shipping.state']", state, "State");
            Reusable_Methods.clickMethod(driver, "//*[text()='Continue']", "Continue button");
            Thread.sleep(2500);
            Reusable_Methods.clickMethod(driver, "//*[text()='Continue']", "Continue button");
            Thread.sleep(2500);
            String deliveryText = Reusable_Methods.getText(driver, "//*[@class='_1Q4iDku_IopeC7OgnKsdoD']", "Deliver options text");*/
}
