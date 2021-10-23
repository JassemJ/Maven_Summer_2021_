package TransamericaLifeInsurance;

import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import Transamerica_LifeInsurance_Page_Object.BaseClassTransamerica;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TC7 extends Reuseable_Annotations_Class_HTML_Report {

    Workbook readableFile;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;

    String product;
    String age;
    String state;
    String gender;
    String riskClass;
    String solve;
    String premiumAmount;
    String premiumMode;

    @BeforeSuite
    public void setTheWorkbook() throws IOException, BiffException, WriteException {
        readableFile = Workbook.getWorkbook(new File("src/main/resources/transAmericaQuote.xls"));
        writableFile = Workbook.createWorkbook(new File("src/main/resources/transAmericaQuote_copy.xls"),readableFile);
        writableSheet = writableFile.getSheet(0);
        product = writableSheet.getCell(0,1).getContents();
        age = writableSheet.getCell(1,1).getContents();
        state = writableSheet.getCell(2,1).getContents();
        gender = writableSheet.getCell(3,1).getContents();
        riskClass = writableSheet.getCell(4,1).getContents();
        solve = writableSheet.getCell(5,1).getContents();
        premiumAmount = writableSheet.getCell(6,1).getContents();
        premiumMode = writableSheet.getCell(7,1).getContents();
        //writableFile.write();
        writableFile.close();
    }

    @Test
    public void runAQuote() throws InterruptedException {
        driver.navigate().to("https://www.transamerica.com/");
        Thread.sleep(500);
        BaseClassTransamerica.transamericaHome().closePopUp();
        BaseClassTransamerica.transamericaHome().clickInsurance();
        BaseClassTransamerica.transamericaHome().clickFELI();
        BaseClassTransamerica.transamericaFELifeInsurance().zoomToRunAQuote();
        BaseClassTransamerica.transamericaFELifeInsurance().clickRunAQuote();
        BaseClassTransamerica.transamericaFELifeInsurance().changeToRunAQuote();
        BaseClassTransamerica.transamericaRunAQuote().selectProduct(product);
        BaseClassTransamerica.transamericaRunAQuote().selectAge(age);
        BaseClassTransamerica.transamericaRunAQuote().selectState(state);
        BaseClassTransamerica.transamericaRunAQuote().selectGender(gender);
        BaseClassTransamerica.transamericaRunAQuote().selectRiskClass(riskClass);
        BaseClassTransamerica.transamericaRunAQuote().sendFaceAmount(premiumAmount);
        BaseClassTransamerica.transamericaRunAQuote().clickViewQuote();
        BaseClassTransamerica.transamericaFELifeInsurance().closeRunAQuote();

    }

    @AfterSuite
    public void finish(){
        driver.manage().deleteAllCookies();
    }
}
