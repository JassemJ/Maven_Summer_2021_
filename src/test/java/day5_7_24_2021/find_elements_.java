package day5_7_24_2021;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class find_elements_ {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup(); // setup chromedriver
        // set preconditions for chromedriver before opening chromedriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        //options.addArguments("headless");  // run automation without seeing browser open
        WebDriver driver = new ChromeDriver(options); // instance of ChromeDriver

        //navigate to yahoo
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(3000); // wait for element to exist

        // click on second tab (News) using find Elements // note class name changing revisit yahoo.com to get class value
        driver.findElements(By.xpath("//*[@class='_yb_pmdr5 ']")).get(0).click(); // use index mail is [0] news is [1] ...
        Thread.sleep(3000);
        driver.navigate().to("https://www.yahoo.com");
        driver.findElements(By.xpath("//*[contains(@class, '_yb_pmdr5')]")).get(1).click(); // contains helps with ignoring for ex white space match
        Thread.sleep(3000);

        // unique value also helps with longer strings I can choose to find a substring '_yb_b4xff ' will click same as _yb_b4xff (using contains)
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(3000);
        driver.findElements(By.className("_yb_pmdr5")).get(2).click();
        Thread.sleep(3000);

        driver.quit();
    }
}
