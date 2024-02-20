import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    @BeforeEach
    public void setUp() {
        //        Specify the base URL
        RestAssured.baseURI = Constants.BASE_URL.getValue();
    }
}
