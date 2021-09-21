package day4_7_18_2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Search {
    public static void main(String[] args) throws InterruptedException {
        // set the property and path of chromedriver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");

        // define the driver you are using for automation
        WebDriver driver = new ChromeDriver();

        // navigate to google home page
        driver.navigate().to("https://www.google.com/");

        driver.manage().window().maximize();

        // automation is faster than browser loading time slow down
        // allow time to find element
        Thread.sleep(3000);

        //identify the search field and enter cars

        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");

        // hit submit
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        // sleep allow page time to load then search
        // every time you interact with new page you should sleep

        Thread.sleep(3000);

        //capture search result and print out number
        String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        String[] value = result.split(" ");

        //System.out.println("My full result is: "result);
        System.out.println("My search results is: "+value[1]);



        driver.quit();
    }
}
