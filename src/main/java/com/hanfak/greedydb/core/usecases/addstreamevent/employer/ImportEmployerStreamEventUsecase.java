package com.hanfak.greedydb.core.usecases.addstreamevent.employer;

import com.hanfak.greedydb.core.domain.employer.Employer;
import com.hanfak.greedydb.core.usecases.EmployerStreamRepository;

public class ImportEmployerStreamEventUsecase {
    private EmployerStreamRepository employerStreamRepository;

    public ImportEmployerStreamEventUsecase(EmployerStreamRepository employerStreamRepository) {
        this.employerStreamRepository = employerStreamRepository;
    }

    public void storeEvent(Employer employer) {
        employerStreamRepository.storeEventInStream(employer);
    }
}
