package TransamericaLifeInsurance;

import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import Transamerica_LifeInsurance_Page_Object.BaseClassTransamerica;
import org.testng.annotations.Test;

public class TC8 extends Reuseable_Annotations_Class_HTML_Report {
    @Test
    public void learnMoreFinalExpenseLifeInsurance() throws InterruptedException {
        driver.navigate().to("https://www.transamerica.com/");
        Thread.sleep(500);
        BaseClassTransamerica.transamericaHome().closePopUp();
        BaseClassTransamerica.transamericaHome().clickInsurance();
        BaseClassTransamerica.transamericaHome().clickFELI();
        BaseClassTransamerica.transamericaFELifeInsurance().zoomToLearnMore();
        BaseClassTransamerica.transamericaFELifeInsurance().clickLearnMore();
        BaseClassTransamerica.transamericaFinancialStrength().zoomToAegonFactSheet();
        BaseClassTransamerica.transamericaFinancialStrength().clickAegonFactSheet();
        BaseClassTransamerica.transamericaFinancialStrength().changeToAegonFactSheet();
        Thread.sleep(1000);
        BaseClassTransamerica.transamericaFinancialStrength().closeAegonFactSheet();
    }
}
