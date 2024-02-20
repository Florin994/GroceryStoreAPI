import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class PostTest extends BaseTest {
    @Test
    public void createANewCartTest() {
        RestAssured.given()
                .when().post("/carts")
                .then().log().all()
                .statusCode(201);
    }

    @Test
    public void addItemToCartTest() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(
                        """
                                {
                                   "productId": 1225
                                }
                                """
                )
                .when().post("/carts/bWnAtklZ524owXTjyHsAG/items")
                .then().log().all()
                .statusCode(201);
    }

    @Test
    public void registerNewAPIClientTest() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(
                        """
                                {
                                "clientName" : "Florin Florin",
                                "clientEmail" : "email2@email.com"
                                }
                                """)
                .when().post("/api-clients")
                .then().log().all()
                .statusCode(201);
    }

    @Test
    public void createNewOrderTest() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", Constants.TOKEN.getValue())
                .body("""
                        {
                        "cartId" : "bWnAtklZ524owXTjyHsAG",
                        "customerName" : "Florin Florin",
                        "comment" : "phone 0746"
                        }
                        """)
                .when().post("/orders")
                .then().log().all()
                .statusCode(201);
    }
}
