package acceptancetests.endtoend;

import acceptancetests.TestConfiguration;
import acceptancetests.YatspecAcceptanceEndToEndTest;
import com.hanfak.greedydb.configuration.GreedyDb;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ImportStreamEventTest extends YatspecAcceptanceEndToEndTest {

    @Test
    public void importAnEventForEmployerStream() throws Exception {
        whenAPostRequestToTheApiToImportAnEventForAEmployerStreamIsCalled();

        thenTheEventIsStored();
        andTheResponseIsSuccessful();
    }

    private void whenAPostRequestToTheApiToImportAnEventForAEmployerStreamIsCalled() throws UnirestException {
        String apiPath = "/import/employer";
        String apiUrl = "http://localhost:1234" + apiPath;
        log("API Url", apiUrl);

        HttpResponse<String> httpResponse = Unirest.get(apiUrl).asString();

        responseStatus = httpResponse.getStatus();
        log("Response Status", responseStatus);
    }

    private void thenTheEventIsStored() {

    }

    private void andTheResponseIsSuccessful() {
        assertThat(responseStatus).isEqualTo(200);
    }

    @Before
    public void startup() throws Exception {
        application.start(configuration);
    }

    @After
    public void teardown() {
        application.stop();
    }

    private int responseStatus;
    private final GreedyDb application = new GreedyDb();
    private final TestConfiguration configuration = new TestConfiguration();
}
