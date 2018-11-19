package com.hanfak.greedydb.acceptancetests.businessrequirements;

import com.hanfak.greedydb.YatspecAcceptanceBusinessRequirementsTest;
import com.hanfak.greedydb.core.usecases.EmployerStreamRepository;
import com.hanfak.greedydb.core.usecases.queries.employer.QueryEmployerStreamForGivenTimestampAndFieldUsecase;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FindFieldAtGivenTimestampForAStreamTest extends YatspecAcceptanceBusinessRequirementsTest {

    @Test
    public void blah() {
        givenAnEventForEmployerStreamIsStored();

        whenTheApiToQueryTheEmployerStreamIsCalledForAGivenTimestamp(timestamp, andField(JSON_PATH));

        thenTheValueOfTheFieldIs("12345");
    }

    private void givenAnEventForEmployerStreamIsStored() {
        when(employerStreamRepository.findFieldForGivenTimestamp(timestamp,JSON_PATH)).thenReturn("12345");
    }

    private void whenTheApiToQueryTheEmployerStreamIsCalledForAGivenTimestamp(Timestamp timestamp, String jsonPath) {
        fieldValue = queryEmployerStreamForGivenTimestampAndFieldUsecase.queryEmployerStream(timestamp, jsonPath);
    }

    @SuppressWarnings("SameParameterValue") // For readability
    private void thenTheValueOfTheFieldIs(String expectedFieldValue) {
        verify(employerStreamRepository).findFieldForGivenTimestamp(timestamp, JSON_PATH);
        assertThat(fieldValue).isEqualTo(expectedFieldValue);
    }

    @SuppressWarnings("SameParameterValue") // For readability
    private String andField(String jsonPath) {
        return jsonPath;
    }

    private String fieldValue;

    private static final String JSON_PATH = "id";
    private final LocalDateTime dateTime = LocalDateTime.now();
    private final Timestamp timestamp = Timestamp.valueOf(dateTime);
    private final EmployerStreamRepository employerStreamRepository = mock(EmployerStreamRepository.class);

    private final QueryEmployerStreamForGivenTimestampAndFieldUsecase queryEmployerStreamForGivenTimestampAndFieldUsecase = new QueryEmployerStreamForGivenTimestampAndFieldUsecase(employerStreamRepository);
}
