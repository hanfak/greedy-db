package com.hanfak.greedydb.core.usecases;

import com.hanfak.greedydb.core.domain.employer.Employer;

import java.sql.Timestamp;

// TODO better name for specific action, interface will not be used in all usecases
// Reader and writer interfaces
public interface EmployerStreamRepository<T> {
    void storeEventInStream(Employer employer);

    T findFieldForGivenTimestamp(Timestamp timestamp, String jsonPath); // seperate interface

    T findFieldForLatestTimestamp(String jsonPath);
}
