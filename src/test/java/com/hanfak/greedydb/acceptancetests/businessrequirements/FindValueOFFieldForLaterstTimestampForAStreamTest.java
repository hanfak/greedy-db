package com.hanfak.greedydb.acceptancetests.businessrequirements;

import com.hanfak.greedydb.acceptancetests.YatspecAcceptanceBusinessRequirementsTest;
import com.hanfak.greedydb.core.domain.employer.Employer;
import com.hanfak.greedydb.core.usecases.queries.click.QueryClickStreamForGivenTimestampAndFieldUsecase;
import com.hanfak.greedydb.core.usecases.queries.employer.QueryEmployerStreamForLatestTimestampUsecase;
import org.junit.Test;

import java.io.IOException;

import static com.hanfak.greedydb.core.domain.employer.Employer.employer;
import static com.hanfak.greedydb.core.domain.employer.Id.id;
import static com.hanfak.greedydb.core.domain.employer.Name.name;
import static com.hanfak.greedydb.core.domain.employer.Surname.surname;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FindValueOFFieldForLaterstTimestampForAStreamTest extends YatspecAcceptanceBusinessRequirementsTest {

    @Test
    public void returnsTheLatestEventFieldValueForAnEmployerStream() throws IOException {
        given3EventsForEmployerStreamAreStored();

        whenTheApiToQueryTheEmployerStreamIsCalledForTheLatestEventGivenAField(JSON_PATH);

        thenTheValueOfTheFieldFromTheEmployerStreamIs("789");
    }

//    @Test
//    public void returnsTheFieldValueGivenTheTimestampForAClickStream() {
//        given3EventsForClickStreamAreStored();
//
//        whenTheApiToQueryTheClickStreamIsCalledForAGivenTimestamp(timestamp, andField(JSON_PATH));
//
//        thenTheValueOfTheFieldFromTheClickStreamIs("12345");
//    }

    private void given3EventsForClickStreamAreStored() {
        when(clickStreamRepository.findFieldForGivenTimestamp(timestamp, JSON_PATH)).thenReturn(12345L);

    }
    // TODO change name
    private void given3EventsForEmployerStreamAreStored() {
        when(employerStreamRepository.findFieldForLatestTimestamp()).thenReturn(employer);
    }

//        private void whenTheApiToQueryTheClickStreamIsCalledForAGivenTimestamp(Timestamp timestamp, String jsonPath) {
//        fieldValue = queryClickStreamForGivenTimestampAndFieldUsecase.queryClickStream(timestamp, jsonPath);
//    }

    @SuppressWarnings("SameParameterValue") // For readability
    private void whenTheApiToQueryTheEmployerStreamIsCalledForTheLatestEventGivenAField(String jsonPath) throws IOException {
        fieldValue = queryEmployerStreamForLatestTimestampUsecase.queryEmployerStream(jsonPath);
    }

    @SuppressWarnings("SameParameterValue") // For readability
    private void thenTheValueOfTheFieldFromTheEmployerStreamIs(String expectedFieldValue) {
        verify(employerStreamRepository).findFieldForLatestTimestamp();
        assertThat(fieldValue).isEqualTo(expectedFieldValue);
    }

//    @SuppressWarnings("SameParameterValue") // For readability
//    private void thenTheValueOfTheFieldFromTheClickStreamIs(String expectedFieldValue) {
//        verify(clickStreamRepository).findFieldForGivenTimestamp(timestamp, JSON_PATH);
//        assertThat(fieldValue).isEqualTo(expectedFieldValue);
//    }
//
//    @SuppressWarnings("SameParameterValue") // For readability
//    private String andField(String jsonPath) {
//        return jsonPath;
//    }

    private String fieldValue;

    private static final String JSON_PATH = "id";
    private final Employer employer = employer(timestamp, id(789L), name("Bob"), surname("Coco"));

    private final QueryEmployerStreamForLatestTimestampUsecase queryEmployerStreamForLatestTimestampUsecase = new QueryEmployerStreamForLatestTimestampUsecase(employerStreamRepository);
    private final QueryClickStreamForGivenTimestampAndFieldUsecase queryClickStreamForGivenTimestampAndFieldUsecase = new QueryClickStreamForGivenTimestampAndFieldUsecase(clickStreamRepository);
}
