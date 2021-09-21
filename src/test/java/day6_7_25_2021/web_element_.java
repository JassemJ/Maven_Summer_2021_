package day6_7_25_2021;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class web_element_ {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup(); // initialize chromedriver
        ChromeOptions options = new ChromeOptions(); // set up options for how chrome will be opened
        options.addArguments("start-maximized","incognito");
        WebDriver driver = new ChromeDriver(options); // instantiate chrome browser
        driver.navigate().to("https://www.mortgagecalculator.org/");
        Thread.sleep(3000); // wait for element to exist

        // store homevalue as a webelement to reuse locator

        WebElement homeVal = driver.findElement(By.xpath("//*[@id='homeval']"));

        // clear any data on homeVal
        homeVal.clear();

        //enter desired value
        homeVal.sendKeys("45000");
        Thread.sleep(3000);

        driver.quit(); // shutdown WebDriver




    }
}
