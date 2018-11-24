package com.hanfak.greedydb.core.usecases.queries.click;

import com.hanfak.greedydb.core.usecases.ClickStreamRepository;

import java.sql.Timestamp;

public class QueryClickStreamForGivenTimestampAndFieldUsecase {
    private ClickStreamRepository clickStreamRepository;

    public QueryClickStreamForGivenTimestampAndFieldUsecase(ClickStreamRepository clickStreamRepository) {
        this.clickStreamRepository = clickStreamRepository;
    }

    public String queryClickStream(Timestamp timestamp, String jsonPath) {
        return String.valueOf(clickStreamRepository.findFieldForGivenTimestamp(timestamp, jsonPath));
    }
}
