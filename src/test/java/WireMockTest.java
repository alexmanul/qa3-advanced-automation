import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;

public class WireMockTest {

    @Test
    public void runner() {
//    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer(9999);
        wireMockServer.start();
        configureFor("localhost", wireMockServer.port());
        stubFor(post(urlEqualTo("/create"))
                .withHeader("content-type", equalTo("application/json"))
                .withRequestBody(containing("testing-framework"))
                .willReturn(aResponse().withStatus(200)));
    }
}
