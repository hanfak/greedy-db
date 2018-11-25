package acceptancetests.businessrequirements;

import acceptancetests.YatspecAcceptanceBusinessRequirementsTest;
import com.hanfak.greedydb.core.usecases.queries.click.QueryClickStreamForLatestTimestampUsecase;
import com.hanfak.greedydb.core.usecases.queries.employer.QueryEmployerStreamForLatestTimestampUsecase;
import org.junit.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FindValueOFFieldForLaterstTimestampForAStreamTest extends YatspecAcceptanceBusinessRequirementsTest {

    @Test
    public void returnsTheLatestEventFieldValueForAnEmployerStream() {
        givenEventsForEmployerStreamAreStored();

        whenTheApiToQueryTheEmployerStreamIsCalledForTheLatestEventGivenAField(NAME_JSON_PATH);

        thenTheValueOfTheFieldNameFromTheEmployerStreamIs("Bob");
    }

    @Test
    public void returnsTheLatestEventFieldValueForAnClickStream() {
        givenEventsForClickStreamAreStored();

        whenTheApiToQueryTheClickStreamIsCalledForTheLatestEventGivenAField(ORIGIN_BRAND_JSON_PATH);

        thenTheValueOfTheFieldNameFromTheClickStreamIs("Brand");
    }

    // For readability
    private void givenEventsForEmployerStreamAreStored() {
        when(employerStreamRepository.findFieldForLatestTimestamp(NAME_JSON_PATH)).thenReturn("Bob");
    }

    // For readability
    private void givenEventsForClickStreamAreStored() {
        when(clickStreamRepository.findFieldForLatestTimestamp(ORIGIN_BRAND_JSON_PATH)).thenReturn("Brand");
    }

    @SuppressWarnings("SameParameterValue") // For readability
    private void whenTheApiToQueryTheEmployerStreamIsCalledForTheLatestEventGivenAField(String jsonPath) {
        fieldValue = queryEmployerStreamForLatestTimestampUsecase.queryEmployerStream(jsonPath);
    }

    @SuppressWarnings("SameParameterValue") // For readability
    private void whenTheApiToQueryTheClickStreamIsCalledForTheLatestEventGivenAField(String jsonPath) {
        fieldValue = queryClickStreamForLatestTimestampUsecase.queryClickStream(jsonPath);
    }

    @SuppressWarnings("SameParameterValue") // For readability
    private void thenTheValueOfTheFieldNameFromTheEmployerStreamIs(String expectedFieldValue) {
        verify(employerStreamRepository).findFieldForLatestTimestamp(NAME_JSON_PATH);
        assertThat(fieldValue).isEqualTo(expectedFieldValue);
    }

    @SuppressWarnings("SameParameterValue") // For readability
    private void thenTheValueOfTheFieldNameFromTheClickStreamIs(String expectedFieldValue) {
        verify(clickStreamRepository).findFieldForLatestTimestamp(ORIGIN_BRAND_JSON_PATH);
        assertThat(fieldValue).isEqualTo(expectedFieldValue);
    }

    private String fieldValue;

    private static final String NAME_JSON_PATH = "name";
    private static final String ORIGIN_BRAND_JSON_PATH = "brand";

    private final QueryEmployerStreamForLatestTimestampUsecase queryEmployerStreamForLatestTimestampUsecase = new QueryEmployerStreamForLatestTimestampUsecase(employerStreamRepository);
    private final QueryClickStreamForLatestTimestampUsecase queryClickStreamForLatestTimestampUsecase = new QueryClickStreamForLatestTimestampUsecase(clickStreamRepository);
}
