import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class DeleteTest extends BaseTest {
    @Test
    public void deleteItemFromCartTest() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .when().delete("/carts/bGwpsKqO8JqxVGNfTWd-p/items/368176937")
                .then().log().all()
                .statusCode(204);
    }

    @Test
    public void deleteOrderTest() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", Constants.TOKEN.getValue())
                .when().delete("/orders/vbyKzTjxp94-ZvPvrQTTc")
                .then().log().all()
                .statusCode(204);
    }
}
