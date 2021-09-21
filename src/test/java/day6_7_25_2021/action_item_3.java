package day6_7_25_2021;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class action_item_3 {
    public static void main(String[] args) throws InterruptedException {
        String[] myZipcodes = new String[3];
        myZipcodes[0]="11219";
        myZipcodes[1]="11281";
        myZipcodes[2]="11246";

        WebDriverManager.chromedriver().setup(); // initialize chromedriver
        ChromeOptions options = new ChromeOptions(); // set up options for how chrome will be opened
        //options.addArguments("start-maximized","incognito");
        options.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options); // instantiate chrome browser

/*        driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/"); // navigate to weight watchers
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class='studioIcon-2TdMR']")).click(); // studio tab
        Thread.sleep(2000); // wait for element to exist
        WebElement search_box_ = driver.findElement(By.xpath("//*[@id='location-search']")); // search box*/

        for(int i=0; i< myZipcodes.length; i++){
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/"); // navigate to weight watchers
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@class='studioIcon-2TdMR']")).click(); // studio tab
            Thread.sleep(2000); // wait for element to exist
            //WebElement search_box_ = driver.findElement(By.xpath("//*[@id='location-search']")); // search box
            WebElement search_box_ = driver.findElement(By.xpath("//*[contains(@id,'location-search')]")); // search box with contains
            search_box_.clear(); // clear search field
            search_box_.sendKeys(myZipcodes[i]); // place a zipcode in search field
            search_box_.submit(); // hit enter
            Thread.sleep(2000);

            if(i==0){
                driver.findElements(By.xpath("//*[@class='wrapperLink-2NobU']")).get(i).click(); // press address
                Thread.sleep(3000);
            }

            if(i==1) {
                driver.findElements(By.xpath("//*[@class='wrapperLink-2NobU']")).get(i).click(); // press address
                Thread.sleep(3000);
            }

            if(i==2) {
                driver.findElements(By.xpath("//*[@class='wrapperLink-2NobU']")).get(i).click(); // press address
                Thread.sleep(3000);
            }

            String result = driver.findElement(By.xpath("//*[@class='locationName-1jro_']")).getText(); // store location name
            System.out.println(result); // print location name
            result = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText(); // store address
            String[] format = result.split("Studio"); // break up string at "Studio"
            System.out.println(format[0]); // print relevant portion
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0,1100)"); // scroll down
            Thread.sleep(3000);
            result = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText(); // store all availability
            // information Sunday-Saturday
            System.out.println(result); // print availability
            System.out.println(); // space for next studio
        }
        driver.quit();
    }
}
