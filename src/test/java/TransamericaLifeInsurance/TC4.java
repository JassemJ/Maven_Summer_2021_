package TransamericaLifeInsurance;

import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import Transamerica_LifeInsurance_Page_Object.BaseClassTransamerica;
import org.testng.annotations.Test;

public class TC4 extends Reuseable_Annotations_Class_HTML_Report {
    @Test
    public void clickWholeLifeInsurance() throws InterruptedException {
        driver.navigate().to("https://www.transamerica.com/");
        Thread.sleep(2500);
        BaseClassTransamerica.transamericaHome().closePopUp();
        BaseClassTransamerica.transamericaHome().clickInsurance();
        BaseClassTransamerica.transamericaHome().clickWLI();
        BaseClassTransamerica.transamericaWholeLifeInsurance().scrollWholeLifeInsurance(850);
        BaseClassTransamerica.transamericaWholeLifeInsurance().clickWatchNow();
        BaseClassTransamerica.transamericaWholeLifeInsurance().popUpClickPlay();
        BaseClassTransamerica.transamericaWholeLifeInsurance().closePopUp();
        //Thread.sleep(2500);
    }
}
