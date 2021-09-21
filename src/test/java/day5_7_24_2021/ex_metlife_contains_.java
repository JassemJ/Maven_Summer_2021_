package day5_7_24_2021;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ex_metlife_contains_ {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup(); // setup chromedriver
        // set preconditions for chromedriver before opening chromedriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        //options.addArguments("headless");  // run automation without seeing browser open
        WebDriver driver = new ChromeDriver(options); // instance of ChromeDriver
        driver.navigate().to("https://www.metlife.com");
        Thread.sleep(2000);
        // click on solutions
        // when a property value has a long value or white space before or after the value then
        // contains command can be used best practice
        driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]")).click(); // find unique property
        // inspect element class name is long the link Solutions has a text property
        // "                SOLUTIONS
        //                "  use contains to include appropriate substring which is SOLUTIONS
        // search for text attribute that has substring SOLUTIONS
        // = match entire value contains -> match substring
        Thread.sleep(2000);
        driver.quit();
    }
}
