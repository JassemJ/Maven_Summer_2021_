package TransamericaLifeInsurance;

import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import Transamerica_LifeInsurance_Page_Object.BaseClassTransamerica;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC1 extends Reuseable_Annotations_Class_HTML_Report {

    @Test
    public void viewLifeInsurance() throws InterruptedException {
        driver.navigate().to("https://www.transamerica.com/");
        Thread.sleep(2500);
        BaseClassTransamerica.transamericaHome().closePopUp();
        BaseClassTransamerica.transamericaHome().clickInsurance();
        BaseClassTransamerica.transamericaHome().clickLifeInsurance();
        BaseClassTransamerica.transamericaLifeInsurance().zoomToTermLifeInsurance();
        BaseClassTransamerica.transamericaLifeInsurance().zoomToIndexUniversalLifeInsurance();
        BaseClassTransamerica.transamericaLifeInsurance().zoomToFinalExpenseLifeInsurance();
        BaseClassTransamerica.transamericaLifeInsurance().zoomToFinalExpenseLifeInsurance();
        BaseClassTransamerica.transamericaLifeInsurance().zoomToWholeLifeInsurance();
        BaseClassTransamerica.transamericaLifeInsurance().zoomToLifeInsuranceForForeignNationals();
    }

}
