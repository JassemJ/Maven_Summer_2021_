package day5_7_24_2021;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptions_ {

    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup(); // setup chromedriver
        // set preconditions for chromedriver before opening chromedriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        //options.addArguments("headless");  // run automation without seeing browser open
        WebDriver driver = new ChromeDriver(options); // instance of ChromeDriver
        driver.navigate().to("https://www.bing.com");
        Thread.sleep(2000);
        driver.quit();


    }
}
