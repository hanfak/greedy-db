package com.hanfak.greedydb.core.usecases.queries.employer;

import com.hanfak.greedydb.core.usecases.EmployerStreamRepository;

public class QueryEmployerStreamForLatestTimestampUsecase {

    private EmployerStreamRepository employerStreamRepository;

    public QueryEmployerStreamForLatestTimestampUsecase(EmployerStreamRepository employerStreamRepository) {
        this.employerStreamRepository = employerStreamRepository;
    }

    public String queryEmployerStream(String jsonPath) {
        Object latestTimestampEmployer = employerStreamRepository.findFieldForLatestTimestamp(jsonPath);
        return String.valueOf(latestTimestampEmployer);
    }
}
