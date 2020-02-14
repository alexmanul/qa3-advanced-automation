import Utils.RESTHelper;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

@Log4j
public class WireMockTest {

    private final String HOST = "localhost";
    private final int PORT = 8089;
    private Response response;

    @Test
    public void TEST_WIREMOCK_01() throws IOException {
        WireMockServer wireMockServer = new WireMockServer(PORT);
        wireMockServer.start();
        configureFor(HOST, PORT);
        stubFor(get(urlEqualTo("/baeldung"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/xml")
                        .withBody("Welcome to Baeldung!")));

        HttpGet request = new HttpGet("http://" + HOST + ":" + PORT + "/baeldung");
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpResponse httpResponse = httpClient.execute(request);
        String responseString = RESTHelper.convertResponseToString(httpResponse);
        log.info(responseString);
    }

    @Test
    public void TEST_WIREMOCK_02() throws IOException {
        WireMockServer wireMockServer = new WireMockServer(PORT);
        wireMockServer.start();
        configureFor(HOST, PORT);
        stubFor(get(urlEqualTo("/new-employee"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBodyFile("NewEmployee.json")));


//        HttpGet request = new HttpGet("http://" + HOST + ":" + PORT + "/new-employee");
//        CloseableHttpClient httpClient = HttpClients.createDefault();
        response = given().get("http://" + HOST + ":" + PORT + "/new-employee");

//        HttpResponse httpResponse = httpClient.execute(request);
//        String responseString = RESTHelper.convertResponseToString(httpResponse);
        log.info(response);

//        assertEquals(200, httpResponse.getStatusLine().getStatusCode());

        response.then().statusCode(200);
        JsonPath jsonPathEvaluator = response.jsonPath();
        HashMap<String, HashMap> data = jsonPathEvaluator.get("data");
        log.info(data);

//        for (Object key : data) {
//            assertTrue(((HashMap) key).containsKey("name"));
//            assertTrue(((HashMap) key).containsKey("salary"));
//            assertTrue(((HashMap) key).containsKey("age"));
//            assertTrue(((HashMap) key).containsKey("id"));
//        }

//        for(Map.Entry<String, HashMap> entry : data.entrySet()) {
//            String key = entry.getKey();
//            HashMap value = entry.getValue();
//            assertTrue(((HashMap) key).containsKey("name"));
//            assertTrue(((HashMap) key).containsKey("salary"));
//            assertTrue(((HashMap) key).containsKey("age"));
//            assertTrue(((HashMap) key).containsKey("id"));
//        }
    }


}
