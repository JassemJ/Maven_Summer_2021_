package day10_8_15_2021;

import Reuseable_Classes_.Reusable_Methods;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class mlcalc_dataDriven {
    public static void main(String[] args) throws BiffException, IOException, InterruptedException, WriteException {
        // locate file
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/mlcalc.xls"));

        // create a writeable file that mimics readablefile to write back results

        WritableWorkbook writeableFile = Workbook.createWorkbook(new File("src/main/resources/mlcalc_results.xls"), readableFile);

        // access excel sheet from workbook
        WritableSheet writableSheet_ = writeableFile.getSheet(0);

        // get row count from writeableSheet_ which is not empty
        int rowCount = writableSheet_.getRows();
        //int colCount = writableSheet_.getColumns();

        //set driver
        WebDriver driver = Reusable_Methods.setDriver();

        // iterate through test data
        for (int i = 1; i<rowCount; i++){
            String purchasePrice = writableSheet_.getCell(0,i).getContents(); // .getCell(col,row)
            String dPay = writableSheet_.getCell(1,i).getContents();
            String mTerm = writableSheet_.getCell(2,i).getContents();
            String iRate = writableSheet_.getCell(3,i).getContents();
            String sMonth = writableSheet_.getCell(4,i).getContents();
            String sYear = writableSheet_.getCell(5,i).getContents();

            // navigate to mlcalc
            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(3500);

            Reusable_Methods.sendKeysMethod(driver,"//*[@id='ma']",purchasePrice,"Purchase Price");
            Reusable_Methods.sendKeysMethod(driver,"//*[@id='dp']",dPay,"Down Payment");
            Reusable_Methods.sendKeysMethod(driver,"//*[@id='mt']",mTerm,"Mortgage Term");
            Reusable_Methods.sendKeysMethod(driver,"//*[@id='ir']",iRate,"Interest Rate");

            Reusable_Methods.clickMethod(driver,"//*[text()='Show advanced options']","Show advanced options");

            Reusable_Methods.selectMethod(driver,"//*[@name='sm']",sMonth,"Start Month");
            Reusable_Methods.selectMethod(driver,"//*[@name='sy']",sYear,"Start Year");
            //Thread.sleep(5000);

            Reusable_Methods.clickMethod(driver,"//*[@value='Calculate']","Calculate");

            String result = Reusable_Methods.getTextByIndex(driver,"//div[@style='font-size: 32px']",0,"Monthly Payment");
            System.out.println("My monthly payment is " + result);

            // send result to excel

            Label label = new Label(6,i,result);
            writableSheet_.addCell(label); // store data on excel sheet

        }

        // write back to excel
        writeableFile.write();

        // close file
        writeableFile.close();

        driver.quit();
    }
}
