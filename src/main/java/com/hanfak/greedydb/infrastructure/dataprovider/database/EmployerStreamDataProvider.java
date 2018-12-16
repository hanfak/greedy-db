package com.hanfak.greedydb.infrastructure.dataprovider.database;

import com.hanfak.greedydb.core.domain.employer.Employer;
import com.hanfak.greedydb.core.usecases.EmployerStreamRepository;

import java.sql.Timestamp;
import java.util.List;

public class EmployerStreamDataProvider implements EmployerStreamRepository {

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private final List<Employer> employerEvents;

  public EmployerStreamDataProvider(List<Employer> employerEvents) {
    this.employerEvents = employerEvents;
  }

  @Override // unit test
    public void storeEventInStream(Employer employer) {
        employerEvents.add(employer);
    }

    @Override
    public Object findFieldForGivenTimestamp(Timestamp timestamp, String jsonPath) {
        return null;
    }

    @Override
    public Object findFieldForLatestTimestamp(String jsonPath) {
        return null;
    }
}
