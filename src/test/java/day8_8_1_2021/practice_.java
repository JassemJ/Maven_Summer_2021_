package day8_8_1_2021;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class practice_ {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options_ = new ChromeOptions();
        options_.addArguments("start-maximized");
        WebDriver driver_ = new ChromeDriver(options_);
        driver_.navigate().to("https://weill.cornell.edu/"); // Step 1 navigate to uhc.com
        driver_.findElements(By.xpath("//a[@target='_blank']")).get(1).click();
    }
}
