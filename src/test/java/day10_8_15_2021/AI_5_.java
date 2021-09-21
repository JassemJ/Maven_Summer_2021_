package day10_8_15_2021;

import Reuseable_Classes_.Reusable_Methods;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class AI_5_ {
    public static void main(String[] args) throws BiffException, IOException, InterruptedException, WriteException {
        // locate file
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/express.xls"));

        // make a copy of readableFile and add to it
        WritableWorkbook writeableFile = Workbook.createWorkbook(new File("src/main/resources/express_results.xls"), readableFile);

        // access excel sheet from workbook
        WritableSheet writableSheet = writeableFile.getSheet(0);

        // get row count from writeableSheet_ which is not empty
        int rowCount = writableSheet.getRows();
        //int colCount = writableSheet_.getColumns();

        //set driver
        WebDriver driver = Reusable_Methods.setDriver();

        for(int i=1; i<rowCount; i++){
            // 1. Navigate to express.com
            driver.navigate().to("https://www.express.com");
            Thread.sleep(2500);
            // 2. there may be a pop up so click on x to close the pop up
            Reusable_Methods.clickMethod(driver,"//button[@id='closeModal']","Pop-Up");
            // 3. hover to the Men tab
            Reusable_Methods.mouseHover(driver,"//a[@href='/mens-clothing']","Men Nav");
            // 4. click on polo link
            Reusable_Methods.mouseHover(driver,"//a[text()='Polos']","Polo");
            Reusable_Methods.clickMethod(driver,"//a[text()='Polos']","Polo Link");
            // 5. put few seconds wait
            Thread.sleep(2500);
            // 6. scroll down to men's polo section
            Reusable_Methods.scroll(driver, 750);
            // 7. on men's polo section choose the first polo
            Reusable_Methods.clickMethod(driver,"//a[text()='Solid Moisture-Wicking Luxe Pique Polo']","First Polo");
            // 8. put few seconds wait
            Thread.sleep(2500);
            // 9. click on desired size(you put the size in xpath from your size column)
            Reusable_Methods.clickMethod(driver,"//span[text()='"+writableSheet.getCell(0, i).getContents()+"']","Choosing size");
            // 10. on add to bag button
            Reusable_Methods.clickMethod(driver,"//button[text()='Add to Bag']","Add to Bag");
            // 11. click on view bag pop up button
            Thread.sleep(1500); //
            Reusable_Methods.clickMethod(driver,"//a[text()='View Bag']","View Bag");
            // 12. wait few seconds
            Thread.sleep(2500);
            // 13. select quantity from the dropdown
            Reusable_Methods.selectMethod(driver,"//select[@id='qdd-0-quantity']",writableSheet.getCell(1, i).getContents(),"Quantity");
            // 14. on the right side at the bottom click on Checkout
            Reusable_Methods.scroll(driver,1000);
            Reusable_Methods.clickMethod(driver, "//button[text()='Checkout']", "Checkout");
            // 15. on pop up click on continue as guest
            Reusable_Methods.clickMethod(driver, "//button[text()='Checkout as Guest']", "Checkout as guest");
            // 16. wait few seconds
            Thread.sleep(2500);
            // 17. enter first name
            Reusable_Methods.sendKeysMethod(driver, "//input[@id='contact-information-firstname']", writableSheet.getCell(2, i).getContents(), "First name");
            // 18. enter last name
            Reusable_Methods.sendKeysMethod(driver, "//input[@name='lastname']", writableSheet.getCell(3, i).getContents(), "Last name");
            // 19. enter email address. for instance, abc123@gmail.com //valid format
            Reusable_Methods.sendKeysMethod(driver, "//input[@name='email']", writableSheet.getCell(4, i).getContents(), "Email");
            // 20. re enter the same email address above
            Reusable_Methods.sendKeysMethod(driver, "//input[@name='confirmEmail']", writableSheet.getCell(4, i).getContents(), "Confirm email");
            // 21. enter phone number //valid us format
            Reusable_Methods.sendKeysMethod(driver, "//input[@name='phone']", writableSheet.getCell(5, i).getContents(), "Phone number");
            // 22. click on continue button
            Reusable_Methods.clickMethod(driver, "//span[text()='Continue']", "Continue");
            // 23. there maybe a pop up so close the pop up
            Reusable_Methods.clickMethod(driver, "//*[@name='bluecoreCloseButton']", "Pop up");

            Reusable_Methods.sendKeysMethod(driver, "//input[@id='shipping-firstName']",writableSheet.getCell(2, i).getContents(), "First name");
            Reusable_Methods.sendKeysMethod(driver, "//input[@name='shipping.lastName']",writableSheet.getCell(3, i).getContents(), "Last name");
            // 24. enter address
            Reusable_Methods.sendKeysMethod(driver, "//input[@name='shipping.line1']", writableSheet.getCell(6, i).getContents(), "Street address");
            // 25. enter postal code
            Reusable_Methods.sendKeysMethod(driver, "//input[@name='shipping.postalCode']", writableSheet.getCell(7, i).getContents(), "Postal code");
            // 26. enter city
            Reusable_Methods.sendKeysMethod(driver, "//input[@name='shipping.city']", writableSheet.getCell(8, i).getContents(), "City");
            // 27. select New York only for your drop down
            Reusable_Methods.selectMethod(driver, "//select[@name='shipping.state']", writableSheet.getCell(9, i).getContents(), "State");
            // 28. click on continue button
            Reusable_Methods.clickMethod(driver, "//*[text()='Continue']", "Continue");
            // 29. wait few seconds
            Thread.sleep(2500);
            // 30. click on continue button again
            Reusable_Methods.clickMethod(driver, "//*[text()='Continue']", "Continue");
            // 31. on the top capture the delivery option information and write it back to excel empty column deliveryOption
            String deliveryOptions = Reusable_Methods.getText(driver, "//*[@class='_1Q4iDku_IopeC7OgnKsdoD']", "Deliver options");
            Label label = new Label(10, i, deliveryOptions);
            writableSheet.addCell(label);
            // 32. delete cookies by typing driver.manage().deleteAllCookies;
            driver.manage().deleteAllCookies();
            //break;
        }

        // 33. outside of for loop write back to the writable file
        writeableFile.write();

        // 34. close the writable file
        writeableFile.close();

        // 35. quit the driver
        driver.quit();

    }
}
