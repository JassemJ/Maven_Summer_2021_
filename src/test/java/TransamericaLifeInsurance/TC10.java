package TransamericaLifeInsurance;

import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import Transamerica_LifeInsurance_Page_Object.BaseClassTransamerica;
import org.testng.annotations.Test;

public class TC10 extends Reuseable_Annotations_Class_HTML_Report {
    @Test
    public void goToFAQTLI() throws InterruptedException {
        driver.navigate().to("https://www.transamerica.com/");
        Thread.sleep(2500);
        BaseClassTransamerica.transamericaHome().closePopUp();
        BaseClassTransamerica.transamericaHome().clickInsurance();
        BaseClassTransamerica.transamericaHome().clickTLI();
        //BaseClassTransamerica.transamericaTermLifeInsurance().scrollTermLifeInsurance(3900);
        BaseClassTransamerica.transamericaTermLifeInsurance().zoomShouldTheyBuyTLI();
        BaseClassTransamerica.transamericaTermLifeInsurance().clickShouldTheyBuyTLI();
        BaseClassTransamerica.transamericaTermLifeInsurance().zoomHowDoesTLIWork();
        BaseClassTransamerica.transamericaTermLifeInsurance().clickHowDoesTLIWork();
        BaseClassTransamerica.transamericaTermLifeInsurance().zoomWhatDoesTLICover();
        BaseClassTransamerica.transamericaTermLifeInsurance().clickWhatDoesTLICover();
        BaseClassTransamerica.transamericaTermLifeInsurance().zoomHowMuchTermLifeDoTheyNeed();
        BaseClassTransamerica.transamericaTermLifeInsurance().clickHowMuchTermLifeDoTheyNeed();
        BaseClassTransamerica.transamericaTermLifeInsurance().zoomBestTermPolicy();
        BaseClassTransamerica.transamericaTermLifeInsurance().clickBestTermPolicy();
        BaseClassTransamerica.transamericaTermLifeInsurance().zoomInsuranceCost();
        BaseClassTransamerica.transamericaTermLifeInsurance().clickInsuranceCost();
        BaseClassTransamerica.transamericaTermLifeInsurance().zoomPolicyToReceive();
        BaseClassTransamerica.transamericaTermLifeInsurance().clickPolicyToReceive();
        BaseClassTransamerica.transamericaTermLifeInsurance().zoomHowLongIsInsurance();
        BaseClassTransamerica.transamericaTermLifeInsurance().clickHowLongIsInsurance();
        BaseClassTransamerica.transamericaTermLifeInsurance().zoomLiveThroughInsurance();
        BaseClassTransamerica.transamericaTermLifeInsurance().clickLiveThroughInsurance();
        BaseClassTransamerica.transamericaTermLifeInsurance().zoomCanCancel();
        BaseClassTransamerica.transamericaTermLifeInsurance().clickCanCancel();
        BaseClassTransamerica.transamericaTermLifeInsurance().zoomCanBorrow();
        BaseClassTransamerica.transamericaTermLifeInsurance().clickCanBorrow();
        BaseClassTransamerica.transamericaTermLifeInsurance().zoomIsTaxable();
        BaseClassTransamerica.transamericaTermLifeInsurance().clickIsTaxable();
        BaseClassTransamerica.transamericaTermLifeInsurance().zoomCanBuy();
        BaseClassTransamerica.transamericaTermLifeInsurance().clickCanBuy();

        Thread.sleep(2000);
    }
}
