package day4_7_18_2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class action_item_2 {
    public static void main(String[] args) throws InterruptedException {

        // install driver and set its path to be saved
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // instance of Chrome Browser
        String[] color = new String[3];
        color[0]="blue";
        color[1]="white";
        color[2]="gray";

        for(String i:color){
            // navigate to bing.com
            driver.navigate().to("https://www.bing.com");
            driver.manage().window().maximize(); //maximize the window
            // automation can move faster than browser pause script to allow for browser to load
            Thread.sleep(3000); // 3 second delay before interacting with webpage
            //identify search field and type color
            driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys(i);
            //press magnifying glass
            driver.findElement(By.xpath("//*[@class='search icon tooltip']")).submit();
            Thread.sleep(3000); // 3 second delay before interacting with webpage
            //store the number of results in results
            String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            String[] arrayResult = result.split(" "); //format result string such that arrayResult stores words separated by a space
            String[] arrayResult1 = arrayResult[0].split(","); //separate first element at comma
            StringBuilder result1 = new StringBuilder(); // initialize string that will hold value without comma
            for(int j=0; j<arrayResult1.length; j=j+2){
                result1.append(arrayResult1[j]);
                if((j+2)==arrayResult.length) // check ahead
                    result1.append(arrayResult1[arrayResult1.length-1]); // add the value that is skipped by the iteration
            }
            System.out.println("My search number for color: " + i + " is " + result1);
        }

        driver.quit(); // quit open chrome drivers
    }
}
