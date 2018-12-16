package acceptancetests.endtoend;

import acceptancetests.YatspecAcceptanceEndToEndTest;
import com.hanfak.greedydb.core.domain.employer.Employer;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
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
        log("API Url", apiUrl);
        log("Request Body", jsonString);
        HttpResponse<String> httpResponse = Unirest.post(apiUrl)
                .header("accept", "application/json")
                .body(new JSONObject(jsonString))
                .asString();

        responseStatus = httpResponse.getStatus();
        log("Response Status", responseStatus);
    }

    private void thenTheEventIsStored() {
        Employer employer = configuration.employerStreamDataProvider().findEvent();
        log("employer in database", employer);

        assertThat(employer.id.value).isEqualTo(88837264);
    }

    private void andTheResponseIsSuccessful() {
        assertThat(responseStatus).isEqualTo(204);
    }

    private int responseStatus;
    private final String jsonString = "{\n" +
            "\"streamName\": \"employer\",\n" +
            "\"timestamp\": 1460463641,\n" +
            "\"id\": \"88837264\",\n" +
            "\"name\": \"Davide\",\n" +
            "\"surname\": \"Palmisano\"\n" +
            "}";
    private final String apiPath = "/import/employer";
    private final String apiUrl = "http://localhost:1234" + apiPath;

}
