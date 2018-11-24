package com.hanfak.greedydb.core.usecases.queries.click;

import com.hanfak.greedydb.core.usecases.ClickStreamRepository;

public class QueryClickStreamForLatestTimestampUsecase {

    private ClickStreamRepository clickStreamRepository;

    public QueryClickStreamForLatestTimestampUsecase(ClickStreamRepository clickStreamRepository) {
        this.clickStreamRepository = clickStreamRepository;
    }

    public String queryClickStream(String jsonPath) {
        Object LatestTimestampFieldValue = clickStreamRepository.findFieldForLatestTimestamp(jsonPath);
        return String.valueOf(LatestTimestampFieldValue);
    }
}
