package TransamericaLifeInsurance;

import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import Transamerica_LifeInsurance_Page_Object.BaseClassTransamerica;
import org.testng.annotations.Test;

public class TC9 extends Reuseable_Annotations_Class_HTML_Report {
    @Test
    public void clickFinalExpenseLifeInsurance() throws InterruptedException {
        driver.navigate().to("https://www.transamerica.com/");
        Thread.sleep(2500);
        BaseClassTransamerica.transamericaHome().closePopUp();
        BaseClassTransamerica.transamericaHome().clickInsurance();
        BaseClassTransamerica.transamericaHome().clickFN();
        BaseClassTransamerica.transamericaForeignNationals().zoomToLearnMore();
        BaseClassTransamerica.transamericaForeignNationals().clickLearnMoreNonRes();
        BaseClassTransamerica.transamericaForeignNationals().changeToNew();
        BaseClassTransamerica.transamericaForeignNationals().closeTab();
        BaseClassTransamerica.transamericaForeignNationals().clickLearnMoreRes();
        BaseClassTransamerica.transamericaForeignNationals().changeToNew();
        BaseClassTransamerica.transamericaForeignNationals().closeTab();
        BaseClassTransamerica.transamericaForeignNationals().clickLearnMoreEstate();
        BaseClassTransamerica.transamericaForeignNationals().changeToNew();
        BaseClassTransamerica.transamericaForeignNationals().closeTab();
        //BaseClassTransamerica.transamericaFELifeInsurance().scrollWholeLifeInsurance(850);
        //Thread.sleep(2500);
    }
}
