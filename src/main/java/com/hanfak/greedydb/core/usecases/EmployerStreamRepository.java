package com.hanfak.greedydb.core.usecases;

import com.hanfak.greedydb.core.domain.Employer;

import java.sql.Timestamp;

// TODO better name for specific action, interface will not be used in all usecases
public interface EmployerStreamRepository {
    void storeEventInStream(Employer employer);

    String findFieldForGivenTimestamp(Timestamp timestamp, String jsonPath); // seperate interface
}
