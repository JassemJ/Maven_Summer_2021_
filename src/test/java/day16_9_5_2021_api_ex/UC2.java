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

public class UC2 extends Reuseable_Annotations_Class_HTML_Report {

    String consumerKey="ooyo7W8uuur7wJqxUIw7jxLrA";
    String consumerSecret = "hNa5Jmtrzi71SP6I0G9wfgtI7vqPwOgQ8lrULXD6AlLNTxdeYv";
    String accessToken = "1437601284241113088-05e8JZMyq9nOdT0vxYMNwQT08QGLIh";
    String tokenSecret = "8Ib9BTHQWJ8QjL4XJYmSJ890PmBO92NCrlZKnuJqc7Fek";
    Stack<String> twitterID = new Stack<>();
    //String id="";

    @BeforeClass
    public void setup(){
        RestAssured.baseURI="https://api.twitter.com/1.1/statuses/";
    }//end of set up

    String lastText = "";

    //create 20 twitter post through rest api
    @Test
    public void deleteRecentFiveTweets() throws InterruptedException {

        for(int i =1; i <= 5; i++) {
            Response response =
                    given()
                            .auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret)
                            //get the time line
                            .when().get("user_timeline.json")  // get all 20 id 1 by 1
                            .then().extract().response();


            if(response.statusCode() == 200){
                System.out.println("Status code is 200 as expected");
            } else {
                System.out.println("Actual status code is " + response.statusCode());
            }

            //verify the id and the text after posting
            String resp = response.asString();
            JsonPath json = new JsonPath(resp);
            //id returns as string "0 1 2
            String id = json.getString("id[0]"); // get recent 10 9 8 7 6
            //System.out.println("MY id is " + id);

            Response response2 =
                    given()
                            .auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                            queryParam("id",id)
                            .when().post("destroy.json") // delete 1 by 1
                            .then().extract().response();
            if(response2.statusCode() == 200){
                System.out.println("Successfully deleted id " + id);
                logger.log(LogStatus.PASS, "Successfully deleted");
            } else {
                System.out.println("Actual status code is " + response2.statusCode());
                logger.log(LogStatus.PASS, "Could not delete");
            }
        }//end of for loop

        Response response3 =
                given()
                        .auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret)
                        //get the time line
                        .when().get("user_timeline.json")  // get all id
                        .then().extract().response();

        //verify the id and the text after posting
        String resp3 = response3.asString();
        JsonPath json1 = new JsonPath(resp3);
        //id
        String id_ = json1.getString("id[0]");
        lastText = json1.getString("text[0]");

    }

    @Test(dependsOnMethods = "deleteRecentFiveTweets")
    public void verifyRecentTitleText() throws InterruptedException {
        driver.navigate().to("https://twitter.com/");
        Thread.sleep(2500);
        BaseClassTwitter.twitterLogin().clickSignIn();
        BaseClassTwitter.twitterLogin().clickUsePhoneUserEmail();
        driver.navigate().to("https://twitter.com/home"); // refresh as tweets can be shuffled with first signin
        Thread.sleep(2500);
        String recentTweet = BaseClassTwitter.twitterHome().getRecentText();
        //System.out.println(lastText);
        //System.out.println(recentTweet);
        if(recentTweet.equals(lastText)){
            System.out.println("Success");
            logger.log(LogStatus.PASS,"Success the text from UI and API matches");
        }
        else{
            System.out.println("Fail");
            logger.log(LogStatus.FAIL,lastText + " and " + recentTweet + " do not match!");
        }
        BaseClassTwitter.twitterHome().clickNameIcon();
        BaseClassTwitter.twitterHome().clickLogOut();
        BaseClassTwitter.twitterLogout().clickLogOut();
    }
}
