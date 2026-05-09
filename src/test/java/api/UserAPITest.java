package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserAPITest {

    @Test
    public void getUsersTest() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response = RestAssured
                .given()
                .when()
                .get("/users");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}