package com.hanfak.greedydb.core.usecases.queries.employer;

import com.hanfak.greedydb.core.usecases.EmployerStreamRepository;

import java.sql.Timestamp;
// TODO make more abstract, factory for repository - switch/strategy,
// repository implements interface for just findFieldForGivenTimestamp
// webservice calls factory which passes the correct repository into the abstract usecase

public class QueryEmployerStreamForGivenTimestampAndFieldUsecase {
    private EmployerStreamRepository employerStreamRepository;

    public QueryEmployerStreamForGivenTimestampAndFieldUsecase(EmployerStreamRepository employerStreamRepository) {
        this.employerStreamRepository = employerStreamRepository;
    }

    public String queryEmployerStream(Timestamp timestamp, String jsonPath) {
        return employerStreamRepository.findFieldForGivenTimestamp(timestamp, jsonPath);
    }
}
