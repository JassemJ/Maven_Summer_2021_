package day16_9_5_2021_api_ex;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Twitter_Delete_Recent_20 {

    String consumerKey="ooyo7W8uuur7wJqxUIw7jxLrA";
    String consumerSecret = "hNa5Jmtrzi71SP6I0G9wfgtI7vqPwOgQ8lrULXD6AlLNTxdeYv";
    String accessToken = "1437601284241113088-05e8JZMyq9nOdT0vxYMNwQT08QGLIh";
    String tokenSecret = "8Ib9BTHQWJ8QjL4XJYmSJ890PmBO92NCrlZKnuJqc7Fek";

    //String id="";

    @BeforeClass
    public void setup(){
        RestAssured.baseURI="https://api.twitter.com/1.1/statuses/";
    }//end of set up

    //create 20 twitter post through rest api
    @Test
    public void deleteRecentTwentyTweets() throws InterruptedException {

        for(int i =1; i <= 20; i++) {
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
            String id = json.getString("id[0]"); // get recent
            //System.out.println("MY id is " + id);

            Response response2 =
                    given()
                            .auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                            queryParam("id",id)
                            .when().post("destroy.json") // delete 1 by 1
                            .then().extract().response();
            if(response2.statusCode() == 200){
                System.out.println("Successfully deleted id " + id);
            } else {
                System.out.println("Actual status code is " + response2.statusCode());
            }
        }//end of for loop


    }
}
