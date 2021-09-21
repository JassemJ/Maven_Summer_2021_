package day7_7_31_2021;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class select_ex_ {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> monthList = new ArrayList<>();
        monthList.add("Aug");
        monthList.add("Sep");
        monthList.add("Oct");
        ArrayList<String> yearList = new ArrayList<>();
        yearList.add("2022");
        yearList.add("2023");
        yearList.add("2024");

        WebDriverManager.chromedriver().setup(); // setup chromedriver
        // set preconditions for chromedriver before opening chromedriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        //options.addArguments("headless");  // run automation without seeing browser open
        WebDriver driver = new ChromeDriver(options); // instance of ChromeDriver

        for(int i=0; i<monthList.size(); i++) {
            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(2000);

            driver.findElement(By.xpath("//*[contains(text(),'Show advanced options')]")).click();
            Thread.sleep(2000);

            WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']")); // save box with dropdown capabilities
            Select smSelect = new Select(startMonth); // only works if there is select property for web element
            smSelect.selectByVisibleText(monthList.get(i)); // select Aug

           WebElement startYear = driver.findElement(By.xpath("//*[@name='sy']"));
            Select sySelect = new Select(startYear);
            sySelect.selectByVisibleText(yearList.get(i));

            // click concept
            //driver.findElement(By.xpath("//*[@name='sy']")).click(); // click dropdown
           // driver.findElement(By.xpath("//*[text()='"+yearList.get(i)+"']")).click(); // click 2022

            // click outside
            driver.findElement(By.xpath("//*[@style='padding-top: 20px']")).click();


            Thread.sleep(3000);
        }
        driver.quit();
    }
}
