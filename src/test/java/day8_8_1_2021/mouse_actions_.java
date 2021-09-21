package day8_8_1_2021;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class mouse_actions_ {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(3000);

        // move mouse to send tab with mouse actions (not clicking send hovering to see dropdown)

        Actions mouseAction = new Actions(driver);
        try {
            WebElement send_ = driver.findElement(By.xpath("//*[@id='mail-ship-width']")); // * ignore tag
            mouseAction.moveToElement(send_).perform();
            Thread.sleep(3000);
        }catch(Exception err){
            System.out.println("Unable to hover over send tab" + err);
        }


        // click schedule a pickup with mouse action
        try {
            WebElement pickup_ = driver.findElement(By.xpath("//a[text()='Schedule a Pickup']")); // tag <a> followed by property
            mouseAction.moveToElement(pickup_).click().perform();
            Thread.sleep(3000);
        }catch (Exception err){
            System.out.println("Unable to press Schedule a Pickup "+err);
        }

        driver.quit();





    }
}
