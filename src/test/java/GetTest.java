import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.internal.path.json.JsonPrettifier;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class GetTest extends BaseTest {
    @Test
    public void getStatusTest() {
//        Specify the request
        RequestSpecification httpRequest = given();
//        Specify the method (Get/Post)
        httpRequest.request(Method.GET);
    }

    @Test
    public void getStatusWithLoggingTest() {
        RestAssured.given().log().all()
                .when().get("/status")
                .then().log().all();
    }

    @Test
    public void getStatusResponseTest() {
        Response response = get("/status");
        int statusCode = response.getStatusCode();
        Assertions.assertEquals(200, statusCode);
        System.out.println(response.getBody().asString());
    }

    @Test
    public void getAllProductsTest() {
        Response response = get("/products");
        int statusCode = response.getStatusCode();
        Assertions.assertEquals(200, statusCode);
        String responseBody = response.getBody().asString();
        System.out.println(JsonPrettifier.prettifyJson(responseBody));
    }

    @Test
    public void getOneProductTest() {
        Response response = get("/products/4646");
        int statusCode = response.getStatusCode();
        Assertions.assertEquals(200, statusCode);
        String responseBody = response.getBody().asString();
        System.out.println(JsonPrettifier.prettifyJson(responseBody));
    }

    @Test
    public void getCartItemsTest() {
        Response response = get("/carts/bGwpsKqO8JqxVGNfTWd-p/items");
        int statusCode = response.getStatusCode();
        Assertions.assertEquals(200, statusCode);
        String responseBody = response.getBody().asString();
        System.out.println(JsonPrettifier.prettifyJson(responseBody));
    }

    @Test
    public void getCartTest() {
        Response response = get("/carts/bGwpsKqO8JqxVGNfTWd-p");
        int statusCode = response.getStatusCode();
        Assertions.assertEquals(200, statusCode);
        String responseBody = response.getBody().asString();
        System.out.println(JsonPrettifier.prettifyJson(responseBody));
    }

    @Test
    public void getOrderTest() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", Constants.TOKEN.getValue())
                .when().get("/orders/cnl1t3ZDzE-zlBwWxerPg")
                .then().log().all()
                .statusCode(200).statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void getAllOrdersTest() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", Constants.TOKEN.getValue())
                .when().get("/orders")
                .then().log().all()
                .statusCode(200);
    }
}
