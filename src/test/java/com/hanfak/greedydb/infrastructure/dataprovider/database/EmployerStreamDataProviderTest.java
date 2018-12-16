package com.hanfak.greedydb.infrastructure.dataprovider.database;

import com.hanfak.greedydb.core.domain.employer.Employer;
import org.assertj.core.api.WithAssertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

public class EmployerStreamDataProviderTest implements WithAssertions {
  @Test
  public void shouldAddAndEmployerToStream() {
    Employer employer = mock(Employer.class);
    List<Employer> employers = new ArrayList<>();
    EmployerStreamDataProvider employerStreamDataProvider = new EmployerStreamDataProvider(employers);

    employerStreamDataProvider.storeEventInStream(employer);

    assertThat(employers).contains(employer);
  }
}