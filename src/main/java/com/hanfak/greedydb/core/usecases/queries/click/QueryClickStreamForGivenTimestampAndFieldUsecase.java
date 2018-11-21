package com.hanfak.greedydb.core.usecases.queries.click;

import com.hanfak.greedydb.core.usecases.importstreamevent.click.ClickStreamRepository;

import java.sql.Timestamp;

public class QueryClickStreamForGivenTimestampAndFieldUsecase {
    private ClickStreamRepository clickStreamRepository;

    public QueryClickStreamForGivenTimestampAndFieldUsecase(ClickStreamRepository clickStreamRepository) {
        this.clickStreamRepository = clickStreamRepository;
    }

    public String queryClickStream(Timestamp timestamp, String jsonPath) {
        return clickStreamRepository.findFieldForGivenTimestamp(timestamp, jsonPath);
    }
}
