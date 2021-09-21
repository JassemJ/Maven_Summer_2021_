package day12_8_22_2021;

import Reuseable_Classes_.Reusable_Methods;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class AI_6_ {

    Workbook readMe = null;
    WritableWorkbook writeMe = null;
    WritableSheet myPage = null;
    int rowCount = -1;
    int colCount = -1;
    WebDriver driver = null;

    @BeforeSuite
    public void mySetUp() throws BiffException, IOException {
        readMe = Workbook.getWorkbook(new File("src/main/resources/aetna_data_driven_.xls"));
        writeMe = Workbook.createWorkbook(new File("src/main/resources/aetna_data_driven_results_.xls"), readMe);
        myPage = writeMe.getSheet(0);
        rowCount = myPage.getRows();
        colCount= myPage.getColumns()-1;
        driver = Reusable_Methods.setDriver();
    }


    @Test
    public void myTest() throws InterruptedException, WriteException {
        for (int i = 1; i < rowCount; i++) {
            // 1. go to aetna.com and verify the title is Health Insurance Plans | Aetna
            driver.navigate().to("https://www.aetna.com/");
            SoftAssert myCheck = new SoftAssert();
            myCheck.assertEquals("Health Insurance Plans | Aetna",driver.getTitle());

            // 2. click on Shop for a plan
            Reusable_Methods.clickMethod(driver,"//*[text()='Shop for a plan']","Shop for a plan");

            // 3. click on Medicare
            Reusable_Methods.clickMethod(driver,"//*[text()='Medicare']","Medicare");

            // 4. on the suggestion click on Find a Doctor
            Reusable_Methods.clickMethod(driver,"//*[contains(text(),'Find a doctor')]","Find a doctor");


            // 5. click on 2021 medicare plans you purchase yourself
            Reusable_Methods.clickMethod(driver,"//*[text()='2021 Medicare plans you purchase yourself']","2021 Medicare plans you purchase yourself");


            // 6. enter a zipcode //pass values from zipcode column here
            Reusable_Methods.sendKeysMethod(driver,"//input[@id='medZip']",myPage.getCell(0,i).getContents(),"ZipCode");


            // 7. click on zipcode suggested on the dropdown menu
            Reusable_Methods.clickMethod(driver,"//a[@ng-bind-html='match.label | uibTypeaheadHighlight:query']","Choose result");

            // 8. now on the slider bar select a mile //this is what you have to research to figure it out then store the miles on mile column and pass it on your method
            //Reusable_Methods.clickMethod(driver,"//*[text()='Look within']","Look within");
            int myData = Integer.parseInt(myPage.getCell(1,i).getContents());
            myData *= 5; // increasing slider by 1 requires 4-5 px
            Reusable_Methods.horizontalSlider(driver,"//span[@class='rz-pointer rz-pointer-min']","Slider",myData);
            //Reusable_Methods.horizontalSlider(driver,"//span[@class='rz-pointer rz-pointer-min']","Slider",myData*5);

/*
            // works for bizarre reason
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='rz-pointer rz-pointer-min']")));
            Reusable_Methods.clickMethod(driver,"//span[contains(@class,'rz-pointer')]","Slider"); // slider does not move without this
            WebElement slider = driver.findElement(By.xpath("//span[@class='rz-pointer rz-pointer-min']"));
            Actions actions = new Actions(driver);
            actions.clickAndHold(slider).pause(1).moveByOffset(-120,0).release().perform();
            actions.clickAndHold(slider).pause(1).moveByOffset(Integer.parseInt(myPage.getCell(1,i).getContents())*5,0).release().perform();*/

            //actions.dragAndDropBy(slider,243,0).release().build().perform();

            //Reusable_Methods.clickMethod(driver,"//span[@class='rz-pointer rz-pointer-min']","Slider");
            //int xWidth = slider.getSize().width;
            //System.out.println("My width is " + xWidth);
            //Actions move = new Actions(driver);
            //int offset = Integer.parseInt(myPage.getCell(1,i).getContents())*4;
            //Random rand = new Random();
            //int upperbound = 100;
            //generate random values from 0-99
            //int int_random = rand.nextInt(upperbound);
            //move.dragAndDropBy(slider,xWidth-127+offset,0); // get to 0 and then add 5 = 1 mi
            //move.dragAndDropBy(slider,xWidth-132+int_random,0);
            //move.dragAndDropBy(slider,xWidth+Integer.parseInt(myPage.getCell(1,i).getContents())+10,0);
            //move.build().perform();
            //Actions actions = new Actions(driver);
            //actions.dragAndDropBy(slider,243,0).release().build().perform();
            //slider.click();
            //System.out.println(driver.findElement(By.xpath("//span[@class='rz-bubble centerlabel']")).getText());
            //System.out.println(Integer.parseInt(myPage.getCell(1,i).getContents()));
            Thread.sleep(2500);

            // 9. click on skip plan selection
            //Reusable_Methods.clickMethod(driver,"//*[text()='Skip plan selection*']","Skip plan selection*"); // have to click twice for it to work ???
            Reusable_Methods.clickMethod(driver,"//*[text()='Skip plan selection*']","Skip plan selection*");
            //Thread.sleep(2500);
            //Reusable_Methods.mouseHover(driver,"//input[@class='primaryPurple BtnWidth col-md-6 col-xs-12']","Skip plan selection*");

            // 10. click on medial doctors & specialist
            Reusable_Methods.clickMethod(driver,"//*[contains(text(),'Medical Doctors & Specialists')]","Medical Doctors & Specialists");

            // 11. click on all primary care physicians
            Reusable_Methods.clickMethod(driver,"//*[contains(text(),'Doctors (Primary Care)')]","Doctors (Primary Care)");
            Reusable_Methods.clickMethod(driver,"//*[text()='All Primary Care Physicians']","All primary care physicians");

            // 12. now capture the first result and send it back to excel doctorLocation column
            String docName = Reusable_Methods.getText(driver, "//*[@class='providerNameDetails']", "Provider/Facility Information");
            String format[] = docName.split("n "); //Information column
            String format_[] = format[1].split("n"); // columnLeb
            String address = Reusable_Methods.getText(driver, "//*[@ng-bind-html='provider.providerLocations.address.streetLine1|trustHtml']", "Part of address");
            String restAddress = Reusable_Methods.getText(driver, "//*[@ng-bind-html='provider.providerLocations.address.streetLine2|trustHtml']", "Rest of address");
            String phoneNum = Reusable_Methods.getText(driver, "//*[@aria-describedby='phone555']", "Phone number");
            Label label = new Label(colCount, i, format_[1]+" "+address+" "+restAddress+" "+phoneNum);
            myPage.addCell(label);
            driver.manage().deleteAllCookies();
        }
    }

    @AfterSuite
    public void close() throws IOException, WriteException {
        writeMe.write();
        writeMe.close();
        driver.quit();
    }
}
