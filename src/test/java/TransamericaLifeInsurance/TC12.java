package TransamericaLifeInsurance;

import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import Transamerica_LifeInsurance_Page_Object.BaseClassTransamerica;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TC12 extends Reuseable_Annotations_Class_HTML_Report {
    @Test
    public void findAnAgent() throws InterruptedException {

        ArrayList<String> myZipCodes = new ArrayList<>();
        myZipCodes.add("11232");

        driver.navigate().to("https://www.transamerica.com/");
        Thread.sleep(2500);
        BaseClassTransamerica.transamericaHome().closePopUp();
        BaseClassTransamerica.transamericaHome().clickInsurance();
        BaseClassTransamerica.transamericaHome().clickTLI();
        BaseClassTransamerica.transamericaTermLifeInsurance().zoomToFindAgent();
        BaseClassTransamerica.transamericaTermLifeInsurance().clickToFindAgent();
        Thread.sleep(2500);
        BaseClassTransamerica.transamericaAgentLocator().sendZip(myZipCodes.get(0));
        BaseClassTransamerica.transamericaAgentLocator().clickSearch();
        BaseClassTransamerica.transamericaAgentLocator().captureAgentAddress();

    }
}
