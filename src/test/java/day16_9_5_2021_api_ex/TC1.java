package day16_9_5_2021_api_ex;

import Reuseable_Classes_.Reuseable_Annotations_Class_HTML_Report;
import Twitter_API_Page_Object.BaseClassTwitter;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Stack;

import static io.restassured.RestAssured.given;

public class TC1 extends Reuseable_Annotations_Class_HTML_Report {
    String consumerKey="ooyo7W8uuur7wJqxUIw7jxLrA";
    String consumerSecret = "hNa5Jmtrzi71SP6I0G9wfgtI7vqPwOgQ8lrULXD6AlLNTxdeYv";
    String accessToken = "1437601284241113088-05e8JZMyq9nOdT0vxYMNwQT08QGLIh";
    String tokenSecret = "8Ib9BTHQWJ8QjL4XJYmSJ890PmBO92NCrlZKnuJqc7Fek";

    String id="";
    String lastText="";
    String recentTweet="";
    Stack<String> twitterID = new Stack<>();

    @BeforeClass
    public void setup(){
        RestAssured.baseURI="https://api.twitter.com/1.1/statuses/";
    }//end of set up

    @Test(priority = 1)
    public void postAPILoadTest(){
            for(int i=1;i<=10; i++) {
                Response response =
                        given()
                                .auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                                queryParam("status", "My load test API message is " + i)
                                .when().post("update.json")
                                .then().extract().response();

                if(response.statusCode() == 200){
                    System.out.println("Status code is 200 as expected");
                    logger.log(LogStatus.PASS,"Successfully made a generic tweet");
                } else {
                    System.out.println("Actual status code is " + response.statusCode());
                    logger.log(LogStatus.PASS,"Tweet unsuccessful");
                }

                //verify the id and the text after posting
                String resp = response.asString();
                JsonPath json = new JsonPath(resp);
                //id
                id = json.getString("id");
                twitterID.push(id);
                //text
                String actualText = json.getString("text");
                lastText = actualText;
                System.out.println("My id is " + id + " and text is " + actualText);
            }
    }

    @Test(priority = 2)
    public void verifyRecentTitleText() throws InterruptedException {
        driver.navigate().to("https://twitter.com/");
        Thread.sleep(2500);
        BaseClassTwitter.twitterLogin().clickSignIn();
        BaseClassTwitter.twitterLogin().clickUsePhoneUserEmail();
        //recentTweet = BaseClassTwitter.twitterHome().getRecentText();
        //System.out.println("Recent tweet is: "+recentTweet);
        //System.out.println("Last tweet is: "+lastText);
        //if(lastText==recentTweet){
        //    System.out.println("Success");
        //    logger.log(LogStatus.PASS,"Success the text from UI and API matches");
        //}
        //else{
        //    System.out.println("Fail");
        //    logger.log(LogStatus.FAIL,lastText + " and " + recentTweet + "do not match!");
        //}
        BaseClassTwitter.twitterHome().clickNameIcon();
        BaseClassTwitter.twitterHome().clickLogOut();
    }

    @Test(priority = 3)
    public void deleteRecentFive() {
        //System.out.println(twitterID.size()-5 );
        int size = twitterID.size();
        for (int i = twitterID.size(); i > size ; i--) {
            Response response =
                    given()
                            .auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                            queryParam("id", twitterID.pop())
                            .when().post("destroy.json")
                            .then().extract().response();

            if (response.statusCode() == 200) {
                System.out.println("Successfully deleted");
                logger.log(LogStatus.PASS, "Successfully delete tweet");
            } else {
                System.out.println("Actual status code is " + response.statusCode());
                logger.log(LogStatus.FAIL, "Unsuccessful at deleting tweet");
            }

        }//end of delete recent post
/*        RestAssured.baseURI="https://api.twitter.com/1.1/statuses/show.json";
        Response response1 =
                given()
                        .auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                        queryParam("id", twitterID.peek())
                        .when().get()
                        .then().extract().response();
        String resp = response1.asString();
        JsonPath json = new JsonPath(resp);
        lastText = json.getString("text");*/
    }

/*    @Test(dependsOnMethods = "deleteRecentFive")
    public void verifyRecentTextAgain() throws InterruptedException {
        //driver.manage().deleteAllCookies();
        //driver.close();
        driver.navigate().to("https://twitter.com/");
        Thread.sleep(2500);
        BaseClassTwitter.twitterLogin().clickSignIn();
        BaseClassTwitter.twitterLogin().clickUsePhoneUserEmail();
        recentTweet = BaseClassTwitter.twitterHome().getRecentText();
        if(lastText==recentTweet){
            System.out.println("Success");
            logger.log(LogStatus.PASS,"Success the text from UI and API matches");
        }
        else{
            System.out.println("Fail");
            logger.log(LogStatus.FAIL,lastText + " and " + recentTweet + "do not match!");
        }
        BaseClassTwitter.twitterHome().clickNameIcon();
        BaseClassTwitter.twitterHome().clickLogOut();
    }*/
}
