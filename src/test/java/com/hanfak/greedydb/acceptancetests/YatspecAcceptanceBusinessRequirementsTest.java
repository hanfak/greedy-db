package com.hanfak.greedydb.acceptancetests;

import com.googlecode.yatspec.junit.SpecRunner;
import com.hanfak.greedydb.core.usecases.ClickStreamRepository;
import com.hanfak.greedydb.core.usecases.EmployerStreamRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.runner.RunWith;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;

@RunWith(SpecRunner.class)
public abstract class YatspecAcceptanceBusinessRequirementsTest implements WithAssertions {
    protected final EmployerStreamRepository employerStreamRepository = mock(EmployerStreamRepository.class);
    protected final ClickStreamRepository clickStreamRepository = mock(ClickStreamRepository.class);
    protected final Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
}
