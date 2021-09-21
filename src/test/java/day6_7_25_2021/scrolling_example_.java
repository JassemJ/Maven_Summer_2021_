package day6_7_25_2021;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class scrolling_example_ {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup(); // initialize chromedriver
        ChromeOptions options = new ChromeOptions(); // set up options for how chrome will be opened
        //options.addArguments("start-maximized","incognito");
        WebDriver driver = new ChromeDriver(options); // instantiate chrome browser
        driver.navigate().to("https://www.yahoo.com/");
        Thread.sleep(2000); // wait for element to exist

        WebElement search_ = driver.findElement(By.xpath("//*[@type='text']"));
        search_.sendKeys("Cars");
        search_.submit();
        Thread.sleep(2000);

        // scroll all the way to bottom so we can see search results number
        // may or may not be necessary purely visual ?

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,6000)");

        Thread.sleep(2000);

        // capture result and print only numbers portion
        String result = driver.findElement(By.xpath("//*[@class='compPagination']")).getText();
        String[] numResults = result.split("Next");
        String noWS_numResults = numResults[1].trim();
        String[] number = noWS_numResults.split(" ");
        System.out.println("The number of results is: "+number[0]);

        jse.executeScript("scroll(0,-6000)");
        Thread.sleep(2000);

        driver.quit();
    }
}
