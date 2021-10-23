package TransamericaLifeInsurance;

import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import Transamerica_LifeInsurance_Page_Object.BaseClassTransamerica;
import org.testng.annotations.Test;

public class TC11 extends Reuseable_Annotations_Class_HTML_Report {
    @Test
    public void clickFinalExpenseLifeInsurance() throws InterruptedException {
        driver.navigate().to("https://www.transamerica.com/");
        Thread.sleep(500);
        BaseClassTransamerica.transamericaHome().closePopUp();
        BaseClassTransamerica.transamericaHome().clickInsurance();
        BaseClassTransamerica.transamericaHome().clickFN();
        BaseClassTransamerica.transamericaForeignNationals().zoomToWhyTransAmerica();
        BaseClassTransamerica.transamericaForeignNationals().clickGetToKnowUs();
        Thread.sleep(500);
        driver.navigate().to("https://www.transamerica.com/insurance/foreign-nationals-life-insurance");
        Thread.sleep(500);
        //driver.navigate().back();
        BaseClassTransamerica.transamericaForeignNationals().zoomToWhyTransAmerica();
        //BaseClassTransamerica.transamericaForeignNationals().changeToNew();
        //BaseClassTransamerica.transamericaForeignNationals().closeTab();
        BaseClassTransamerica.transamericaForeignNationals().clickFinancialStrength();
        Thread.sleep(500);
        driver.navigate().to("https://www.transamerica.com/insurance/foreign-nationals-life-insurance");
        Thread.sleep(500);
        //driver.navigate().back();
        BaseClassTransamerica.transamericaForeignNationals().zoomToWhyTransAmerica();
        BaseClassTransamerica.transamericaForeignNationals().clickOurCredibility();
        BaseClassTransamerica.transamericaForeignNationals().changeToNew();
        BaseClassTransamerica.transamericaForeignNationals().closeTab();
        //BaseClassTransamerica.transamericaFELifeInsurance().scrollWholeLifeInsurance(850);
        //Thread.sleep(2500);
    }
}
