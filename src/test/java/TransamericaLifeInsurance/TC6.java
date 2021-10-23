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

public class TC6 extends Reuseable_Annotations_Class_HTML_Report {

    Workbook readableFile;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;

    String businessName;
    String TIN;
    String advisorNumberBus;

    @BeforeSuite
    public void setTheWorkbook() throws IOException, BiffException, WriteException {
        readableFile = Workbook.getWorkbook(new File("src/main/resources/transamericaCorportionAccount.xls"));
        writableFile = Workbook.createWorkbook(new File("src/main/resources/transamericaCorportionAccount_copy.xls"),readableFile);
        writableSheet = writableFile.getSheet(0);
        businessName = writableSheet.getCell(0,1).getContents();
        TIN = writableSheet.getCell(1,1).getContents();
        advisorNumberBus = writableSheet.getCell(2,1).getContents();
        //writableFile.write();
        writableFile.close();
    }

    @Test
    public void corporationRegisterForWholeLifeInsurance() throws InterruptedException {
        driver.navigate().to("https://www.transamerica.com/");
        Thread.sleep(2500);
        BaseClassTransamerica.transamericaHome().closePopUp();
        BaseClassTransamerica.transamericaHome().clickInsurance();
        BaseClassTransamerica.transamericaHome().clickWLI();
        BaseClassTransamerica.transamericaWholeLifeInsurance().scrollWholeLifeInsurance(2500);
        BaseClassTransamerica.transamericaWholeLifeInsurance().clickRegisterNow();
        BaseClassTransamerica.transamericaWholeLifeInsurance().changeToRegisterTab();
        BaseClassTransamerica.transamericaSecureAccount().clickFinancialCorporation();
        BaseClassTransamerica.transamericaSecureAccount().sendBusinessName(businessName);
        BaseClassTransamerica.transamericaSecureAccount().sendTIN(TIN);
        BaseClassTransamerica.transamericaSecureAccount().sendAdvisorNumber(advisorNumberBus);
        BaseClassTransamerica.transamericaSecureAccount().scrollAccount(500);
        BaseClassTransamerica.transamericaSecureAccount().hitNext();
        BaseClassTransamerica.transamericaSecureAccount().captureErrorMessage();
        BaseClassTransamerica.transamericaWholeLifeInsurance().closeRegisterTab();
    }

    @AfterSuite
    public void finish(){
        driver.manage().deleteAllCookies();
    }
}
