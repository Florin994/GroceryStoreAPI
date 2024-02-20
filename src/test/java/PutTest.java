import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class PutTest extends BaseTest {
    @Test
    public void replaceItemInCartTest() {
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body("""
                        {
                        "productId" : 1225,
                        "quantity" : 2
                        }
                        """)
                .when().put("/carts/bGwpsKqO8JqxVGNfTWd-p/items/368176937")
                .then().log().all()
                .statusCode(204);
    }
}
