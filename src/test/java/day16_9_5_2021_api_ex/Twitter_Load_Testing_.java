package day16_9_5_2021_api_ex;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Twitter_Load_Testing_ {
    String consumerKey="ooyo7W8uuur7wJqxUIw7jxLrA";
    String consumerSecret = "hNa5Jmtrzi71SP6I0G9wfgtI7vqPwOgQ8lrULXD6AlLNTxdeYv";
    String accessToken = "1437601284241113088-05e8JZMyq9nOdT0vxYMNwQT08QGLIh";
    String tokenSecret = "8Ib9BTHQWJ8QjL4XJYmSJ890PmBO92NCrlZKnuJqc7Fek";

    String id="";

    @BeforeClass
    public void setup(){
        RestAssured.baseURI="https://api.twitter.com/1.1/statuses/";
    }//end of set up

    @Test(priority = 1)
    public void postAPILoadTest(){
        for(int i=1;i<=20; i++) {
            Response response =
                given()
                        .auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret).
                        queryParam("status", "My load test API message is " + i)
                        .when().post("update.json")
                        .then().extract().response();

            if(response.statusCode() == 200){
                System.out.println("Status code is 200 as expected");
            } else {
                System.out.println("Actual status code is " + response.statusCode());
            }

            //verify the id and the text after posting
            String resp = response.asString();
            JsonPath json = new JsonPath(resp);
            //id
            id = json.getString("id");
            //text
            String actualText = json.getString("text");

            System.out.println("My id is " + id + " and text is " + actualText);


        }
    }
}
