package TransamericaLifeInsurance;

import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import Transamerica_LifeInsurance_Page_Object.BaseClassTransamerica;
import org.testng.annotations.Test;

public class TC3 extends Reuseable_Annotations_Class_HTML_Report {
    @Test
    public void clickIndexUniversalLifeInsurance() throws InterruptedException {
        driver.navigate().to("https://www.transamerica.com/");
        Thread.sleep(2500);
        BaseClassTransamerica.transamericaHome().closePopUp();
        BaseClassTransamerica.transamericaHome().clickInsurance();
        BaseClassTransamerica.transamericaHome().clickIULI();
        BaseClassTransamerica.transamericaHomeIndexUniversalLifeInsurance().scrollIndexUniversalLifeInsurance(1500);
        BaseClassTransamerica.transamericaHomeIndexUniversalLifeInsurance().clickBrochure();
        BaseClassTransamerica.transamericaHomeIndexUniversalLifeInsurance().changeToBrochureTab();
        BaseClassTransamerica.transamericaHomeIndexUniversalLifeInsurance().closeBrochureTab();
        //Thread.sleep(2500);
    }
}
