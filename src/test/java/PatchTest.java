import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class PatchTest extends BaseTest {
    @Test
    public void modifyItemInCartTest() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body("""
                        {
                        "quantity" : 3
                        }
                        """)
                .when().patch("/carts/bGwpsKqO8JqxVGNfTWd-p/items/814947189")
                .then().log().all()
                .statusCode(204);
    }

    @Test
    public void updateOrderTest() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", Constants.TOKEN.getValue())
                .body("""
                        {
                        "customerName" : "Florin Bogdan"
                        }
                        """)
                .when().patch("/orders/vbyKzTjxp94-ZvPvrQTTc")
                .then().log().all()
                .statusCode(204);
    }
}
