package day14;

import Express_Page_Object.BaseClassExpress;
import Reuseable_Classes_.Reusable_Methods;
import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ExpressPageObject extends Reuseable_Annotations_Class_HTML_Report {

    Workbook readableFile;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;
    int i=0;
    String size;
    String qty;
    String fName;
    String lName;
    String email;
    String phone;
    String address;
    String zipCode;
    String city;
    String state;

    @BeforeSuite
    public void setTheWorkbook() throws IOException, BiffException {
        readableFile = Workbook.getWorkbook(new File("src/main/resources/express.xls"));
        writableFile = Workbook.createWorkbook(new File("src/main/resources/express_results.xls"),readableFile);
        writableSheet = writableFile.getSheet(0);
        rowCount = writableSheet.getRows();
    }

    @Test
    public void expressHome() throws InterruptedException {
            i++;
            size = writableSheet.getCell(0, i).getContents();
            qty = writableSheet.getCell(1, i).getContents();
            fName = writableSheet.getCell(2, i).getContents();
            lName = writableSheet.getCell(3, i).getContents();
            email = writableSheet.getCell(4, i).getContents();
            phone = writableSheet.getCell(5, i).getContents();
            address = writableSheet.getCell(6, i).getContents();
            zipCode = writableSheet.getCell(7, i).getContents();
            city = writableSheet.getCell(8, i).getContents();
            state = writableSheet.getCell(9, i).getContents();
            driver.navigate().to("https://express.com");
            Thread.sleep(2500);
            BaseClassExpress.expressHome().closePopUp();
            BaseClassExpress.expressHome().clickMensTab();
            BaseClassExpress.expressHome().clickPolos();
    }

    @Test (dependsOnMethods = "expressHome")
    public void mensClothing(){
        BaseClassExpress.expressMensClothing().clickPolo();
    }

    @Test (dependsOnMethods = "mensClothing")
    public void solidPolo(){
        BaseClassExpress.expressSolidPolo().clickSize(size);
        BaseClassExpress.expressSolidPolo().addToBag();
        BaseClassExpress.expressSolidPolo().viewBag();
    }

    @Test (dependsOnMethods = "solidPolo")
    public void myBag(){
        BaseClassExpress.expressBag().changeQuantity(qty);
        BaseClassExpress.expressBag().checkOut();
        BaseClassExpress.expressBag().checkOutAsGuest();
    }

    @Test (dependsOnMethods = "myBag")
    public void contactInfo() throws WriteException {
        BaseClassExpress.expressContactInfo().sendFName(fName);
        BaseClassExpress.expressContactInfo().sendlName(lName);
        BaseClassExpress.expressContactInfo().sendEmail(email);
        BaseClassExpress.expressContactInfo().confirmEmail(email);
        BaseClassExpress.expressContactInfo().phone(phone);
        BaseClassExpress.expressContactInfo().next();
        BaseClassExpress.expressContactInfo().closePopUp();
        BaseClassExpress.expressContactInfo().sendAddress(address);
        BaseClassExpress.expressContactInfo().sendPostalCode(zipCode);
        BaseClassExpress.expressContactInfo().sendCity(city);
        BaseClassExpress.expressContactInfo().sendState(state);
        BaseClassExpress.expressContactInfo().next();
        BaseClassExpress.expressContactInfo().next();
        String deliveryText = BaseClassExpress.expressContactInfo().getDeliveryInfo();
        Label label = new Label(10, i, deliveryText);
        writableSheet.addCell(label);
        driver.manage().deleteAllCookies();
    }

    @Test (dependsOnMethods = "contactInfo")
    public void expressHome2() throws InterruptedException, WriteException {
        //System.out.println(i);
        //i=i+1;
        i++;
        //System.out.println(i);
        size = writableSheet.getCell(0, i).getContents();
        qty = writableSheet.getCell(1, i).getContents();
        fName = writableSheet.getCell(2, i).getContents();
        lName = writableSheet.getCell(3, i).getContents();
        email = writableSheet.getCell(4, i).getContents();
        phone = writableSheet.getCell(5, i).getContents();
        address = writableSheet.getCell(6, i).getContents();
        zipCode = writableSheet.getCell(7, i).getContents();
        city = writableSheet.getCell(8, i).getContents();
        state = writableSheet.getCell(9, i).getContents();
        driver.navigate().to("https://express.com");
        Thread.sleep(2500);
        //BaseClassExpress.expressHome().closePopUp();
        BaseClassExpress.expressHome().clickMensTab();
        BaseClassExpress.expressHome().clickPolos();
        BaseClassExpress.expressMensClothing().clickPolo();
        BaseClassExpress.expressSolidPolo().clickSize(size);
        BaseClassExpress.expressSolidPolo().addToBag();
        BaseClassExpress.expressSolidPolo().viewBag();
        BaseClassExpress.expressBag().changeQuantity(qty);
        BaseClassExpress.expressBag().checkOut();
        BaseClassExpress.expressBag().checkOutAsGuest();

        BaseClassExpress.expressContactInfo().sendFName(fName);
        BaseClassExpress.expressContactInfo().sendlName(lName);
        BaseClassExpress.expressContactInfo().sendEmail(email);
        BaseClassExpress.expressContactInfo().confirmEmail(email);
        BaseClassExpress.expressContactInfo().phone(phone);
        BaseClassExpress.expressContactInfo().next();
        BaseClassExpress.expressContactInfo().closePopUp();
        BaseClassExpress.expressContactInfo().sendAddress(address);
        BaseClassExpress.expressContactInfo().sendPostalCode(zipCode);
        BaseClassExpress.expressContactInfo().sendCity(city);
        BaseClassExpress.expressContactInfo().sendState(state);
        BaseClassExpress.expressContactInfo().next();
        BaseClassExpress.expressContactInfo().next();

        String deliveryText = BaseClassExpress.expressContactInfo().getDeliveryInfo();
        //Thread.sleep(2500);
        Label label = new Label(10, i, deliveryText);
        writableSheet.addCell(label);
        driver.manage().deleteAllCookies();
    }

    @Test (dependsOnMethods = "expressHome2")
    public void expressHome3() throws InterruptedException, WriteException {
        //System.out.println(i);
        //i=i+1;
        i++;
        //System.out.println(i);
        size = writableSheet.getCell(0, i).getContents();
        qty = writableSheet.getCell(1, i).getContents();
        fName = writableSheet.getCell(2, i).getContents();
        lName = writableSheet.getCell(3, i).getContents();
        email = writableSheet.getCell(4, i).getContents();
        phone = writableSheet.getCell(5, i).getContents();
        address = writableSheet.getCell(6, i).getContents();
        zipCode = writableSheet.getCell(7, i).getContents();
        city = writableSheet.getCell(8, i).getContents();
        state = writableSheet.getCell(9, i).getContents();
        driver.navigate().to("https://express.com");
        Thread.sleep(2500);
        //BaseClassExpress.expressHome().closePopUp();
        BaseClassExpress.expressHome().clickMensTab();
        BaseClassExpress.expressHome().clickPolos();
        BaseClassExpress.expressMensClothing().clickPolo();
        BaseClassExpress.expressSolidPolo().clickSize(size);
        BaseClassExpress.expressSolidPolo().addToBag();
        BaseClassExpress.expressSolidPolo().viewBag();
        BaseClassExpress.expressBag().changeQuantity(qty);
        BaseClassExpress.expressBag().checkOut();
        BaseClassExpress.expressBag().checkOutAsGuest();

        BaseClassExpress.expressContactInfo().sendFName(fName);
        BaseClassExpress.expressContactInfo().sendlName(lName);
        BaseClassExpress.expressContactInfo().sendEmail(email);
        BaseClassExpress.expressContactInfo().confirmEmail(email);
        BaseClassExpress.expressContactInfo().phone(phone);
        BaseClassExpress.expressContactInfo().next();
        BaseClassExpress.expressContactInfo().closePopUp();
        BaseClassExpress.expressContactInfo().sendAddress(address);
        BaseClassExpress.expressContactInfo().sendPostalCode(zipCode);
        BaseClassExpress.expressContactInfo().sendCity(city);
        BaseClassExpress.expressContactInfo().sendState(state);
        BaseClassExpress.expressContactInfo().next();
        BaseClassExpress.expressContactInfo().next();

        String deliveryText = BaseClassExpress.expressContactInfo().getDeliveryInfo();
        //Thread.sleep(2500);
        Label label = new Label(10, i, deliveryText);
        writableSheet.addCell(label);
    }

    @AfterSuite
    public void writeExcel() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
    }
}
