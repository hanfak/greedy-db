package com.hanfak.greedydb.acceptancetests.businessrequirements;

import com.hanfak.greedydb.acceptancetests.YatspecAcceptanceBusinessRequirementsTest;
import com.hanfak.greedydb.core.usecases.queries.click.QueryClickStreamForGivenTimestampAndFieldUsecase;
import com.hanfak.greedydb.core.usecases.queries.employer.QueryEmployerStreamForGivenTimestampAndFieldUsecase;
import org.junit.Test;

import java.sql.Timestamp;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FindFieldAtGivenTimestampForAStreamTest extends YatspecAcceptanceBusinessRequirementsTest {

    @Test
    public void returnsTheFieldValueGivenTheTimestampForAnEmployerStream() {
        givenAnEventForEmployerStreamIsStored();

        whenTheApiToQueryTheEmployerStreamIsCalledForAGivenTimestamp(timestamp, andField(JSON_PATH));

        thenTheValueOfTheFieldFromTheEmployerStreamIs("12345");
    }

    @Test
    public void returnsTheFieldValueGivenTheTimestampForAClickStream() {
        givenAnEventForClicktreamIsStored();

        whenTheApiToQueryTheClickStreamIsCalledForAGivenTimestamp(timestamp, andField(JSON_PATH));

        thenTheValueOfTheFieldFromTheClickStreamIs("12345");
    }

    private void givenAnEventForClicktreamIsStored() {
        when(clickStreamRepository.findFieldForGivenTimestamp(timestamp,JSON_PATH)).thenReturn("12345");

    }

    private void givenAnEventForEmployerStreamIsStored() {
        when(employerStreamRepository.findFieldForGivenTimestamp(timestamp,JSON_PATH)).thenReturn("12345");
    }

    private void whenTheApiToQueryTheClickStreamIsCalledForAGivenTimestamp(Timestamp timestamp, String jsonPath) {
        fieldValue = queryClickStreamForGivenTimestampAndFieldUsecase.queryClickStream(timestamp, jsonPath);
    }

    private void whenTheApiToQueryTheEmployerStreamIsCalledForAGivenTimestamp(Timestamp timestamp, String jsonPath) {
        fieldValue = queryEmployerStreamForGivenTimestampAndFieldUsecase.queryEmployerStream(timestamp, jsonPath);
    }

    @SuppressWarnings("SameParameterValue") // For readability
    private void thenTheValueOfTheFieldFromTheEmployerStreamIs(String expectedFieldValue) {
        verify(employerStreamRepository).findFieldForGivenTimestamp(timestamp, JSON_PATH);
        assertThat(fieldValue).isEqualTo(expectedFieldValue);
    }

    @SuppressWarnings("SameParameterValue") // For readability
    private void thenTheValueOfTheFieldFromTheClickStreamIs(String expectedFieldValue) {
        verify(clickStreamRepository).findFieldForGivenTimestamp(timestamp, JSON_PATH);
        assertThat(fieldValue).isEqualTo(expectedFieldValue);
    }

    @SuppressWarnings("SameParameterValue") // For readability
    private String andField(String jsonPath) {
        return jsonPath;
    }

    private String fieldValue;

    private static final String JSON_PATH = "id";

    private final QueryEmployerStreamForGivenTimestampAndFieldUsecase queryEmployerStreamForGivenTimestampAndFieldUsecase = new QueryEmployerStreamForGivenTimestampAndFieldUsecase(employerStreamRepository);
    private final QueryClickStreamForGivenTimestampAndFieldUsecase queryClickStreamForGivenTimestampAndFieldUsecase = new QueryClickStreamForGivenTimestampAndFieldUsecase(clickStreamRepository);
}
