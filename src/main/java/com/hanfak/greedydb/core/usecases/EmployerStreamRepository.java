package com.hanfak.greedydb.core.usecases;

import com.hanfak.greedydb.core.domain.employer.Employer;

import java.sql.Timestamp;

// TODO better name for specific action, interface will not be used in all usecases
public interface EmployerStreamRepository {
    void storeEventInStream(Employer employer);

    Long findFieldForGivenTimestamp(Timestamp timestamp, String jsonPath); // seperate interface
}
