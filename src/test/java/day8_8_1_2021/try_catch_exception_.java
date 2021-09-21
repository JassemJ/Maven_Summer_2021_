package day8_8_1_2021;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class try_catch_exception_ {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup(); // setup chromedriver
        // set preconditions for chromedriver before opening chromedriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        //options.addArguments("headless");  // run automation without seeing browser open
        WebDriver driver = new ChromeDriver(options); // instance of ChromeDriver
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);

        //entering a keyword on search field
        try {
            System.out.println("Enter keyword on search field");
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Cars");
            Thread.sleep(2000);
            System.out.println();
        }catch (Exception err){
            System.out.println("Unable to enter keyword on search field "+err);
        }

        //submit on google search button
        try {
            System.out.println("Submitting on google");
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();
            System.out.println();
            Thread.sleep(2000);
        }catch (Exception err){
            System.out.println("Unable to submit on google "+err);
        }


        //capture result
        try {
            System.out.println("Capturing on google");
            String results = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            System.out.println("The number of results is "+results);
            System.out.println();
            Thread.sleep(2000);
        }catch (Exception err){
            System.out.println("Unable to capture on google "+err);
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
