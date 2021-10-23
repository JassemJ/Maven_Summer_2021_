package TransamericaLifeInsurance;

import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import Transamerica_LifeInsurance_Page_Object.BaseClassTransamerica;
import org.testng.annotations.Test;

public class TC2 extends Reuseable_Annotations_Class_HTML_Report {
    @Test
    public void clickTermLifeInsurance() throws InterruptedException {
        driver.navigate().to("https://www.transamerica.com/");
        Thread.sleep(2500);
        BaseClassTransamerica.transamericaHome().closePopUp();
        BaseClassTransamerica.transamericaHome().clickInsurance();
        BaseClassTransamerica.transamericaHome().clickTLI();
        BaseClassTransamerica.transamericaTermLifeInsurance().scrollTermLifeInsurance(875);
        BaseClassTransamerica.transamericaTermLifeInsurance().clickPlay();
        BaseClassTransamerica.transamericaTermLifeInsurance().popUpClickPlay();
        BaseClassTransamerica.transamericaTermLifeInsurance().closeVideoPopUp();
    }
}
