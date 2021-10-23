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

public class TC5 extends Reuseable_Annotations_Class_HTML_Report {

    Workbook readableFile;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;

    String lastName;
    String DOB;
    String advisorNumberCorp;

    @BeforeSuite
    public void setTheWorkbook() throws IOException, BiffException, WriteException {
        readableFile = Workbook.getWorkbook(new File("src/main/resources/transamericaProfessionalAccount.xls"));
        writableFile = Workbook.createWorkbook(new File("src/main/resources/transamericaProfessionalAccount_copy.xls"),readableFile);
        writableSheet = writableFile.getSheet(0);
        lastName = writableSheet.getCell(0,1).getContents();
        DOB = writableSheet.getCell(1,1).getContents();
        advisorNumberCorp = writableSheet.getCell(2,1).getContents();
        //writableFile.write();
        writableFile.close();
    }

    @Test
    public void professionalRegisterForWholeLifeInsurance() throws InterruptedException {
        driver.navigate().to("https://www.transamerica.com/");
        Thread.sleep(2500);
        BaseClassTransamerica.transamericaHome().closePopUp();
        BaseClassTransamerica.transamericaHome().clickInsurance();
        BaseClassTransamerica.transamericaHome().clickWLI();
        BaseClassTransamerica.transamericaWholeLifeInsurance().scrollWholeLifeInsurance(2500);
        BaseClassTransamerica.transamericaWholeLifeInsurance().clickRegisterNow();
        BaseClassTransamerica.transamericaWholeLifeInsurance().changeToRegisterTab();
        BaseClassTransamerica.transamericaSecureAccount().clickFinancialProfessional();
        BaseClassTransamerica.transamericaSecureAccount().sendLastName(lastName);
        BaseClassTransamerica.transamericaSecureAccount().sendDOB(DOB);
        BaseClassTransamerica.transamericaSecureAccount().sendAdvisorNumber(advisorNumberCorp);
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
