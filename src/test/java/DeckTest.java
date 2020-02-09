import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

@Log4j
public class DeckTest {

    Response shuffleResponse = get("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1");

    @Test
    public void testFirst() {
        shuffleResponse.then()
                .assertThat()
                .statusCode(200)
                .body("shuffled", is(true))
                .body("success", is(true))
                .body("remaining", equalTo(52))
                .body("deck_id", notNullValue());
    }

    @Test
    public void secondTest() {
        String deckID = shuffleResponse.jsonPath().getString("deck_id");
        String path = "https://deckofcardsapi.com/api/deck/" + deckID + "/draw/?count=1";
        log.info(path);

        Response response = get(path);
        response.then().statusCode(200);
        JsonPath jsonPathEvaluator = response.jsonPath();
        ArrayList cards = jsonPathEvaluator.get("cards");
        for (Object card : cards) {
            assertTrue(((HashMap) card).containsKey("image"));
            assertTrue(((HashMap) card).containsKey("images"));
            assertTrue(((HashMap) card).containsKey("code"));
            assertTrue(((HashMap) card).containsKey("suit"));
            assertTrue(((HashMap) card).containsKey("value"));
        }
    }
}
