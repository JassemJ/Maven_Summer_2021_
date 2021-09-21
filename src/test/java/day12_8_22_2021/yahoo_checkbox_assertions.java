package day12_8_22_2021;

import Reuseable_Classes_.Reusable_Methods;
import Reuseable_Classes_.Reuseable_Annotations_Class;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class yahoo_checkbox_assertions extends Reuseable_Annotations_Class { // inheritance
    @Test
    public void checkboxAssertion() throws IOException, InterruptedException {
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(3000);
        //click on sign in
        Reusable_Methods.clickMethod(driver, "//*[text()='Sign in']", "Sign In Button");
        Thread.sleep(2000);
        //verify the checkbox stay signed in is selected using testNg assertion
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id='persistent']")).isSelected(), "Should be Selected");

        //verify checkbox is selected using boolean command
        boolean checkBoxStatus = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        if (checkBoxStatus == true) {
            System.out.println("Checkbox is selected as expected");
        } else {
            System.out.println("Checkbox is not selected");
        }//end of condition

        softAssert.assertAll();

    }
}
