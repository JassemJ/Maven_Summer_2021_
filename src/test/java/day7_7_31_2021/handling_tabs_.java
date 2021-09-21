package day7_7_31_2021;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class handling_tabs_ {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup(); // setup chromedriver
        // set preconditions for chromedriver before opening chromedriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized", "incognito");
        //options.addArguments("headless");  // run automation without seeing browser open
        WebDriver driver = new ChromeDriver(options); // instance of ChromeDriver


        driver.navigate().to("https://www.uhc.com");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[text()='Find a doctor']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[text()='Start your search']")).click();
        Thread.sleep(2000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); // store tabs in array current tabs 2
        driver.switchTo().window(tabs.get(1)); // switch control to second tab
        Thread.sleep(2000);

        driver.close(); // close current tab which is second
        Thread.sleep(2000);

        driver.switchTo().window(tabs.get(0)); // switch control to first tab
        Thread.sleep(2000);

        driver.quit(); // closes everything

    }
}
