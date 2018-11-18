package com.hanfak.greedydb.core.usecases.importstreamevent.employer;

import com.hanfak.greedydb.core.domain.Employer;

public class ImportEmployerStreamEventUsecase {
    private EmployerStreamRepository employerStreamRepository;

    public ImportEmployerStreamEventUsecase(EmployerStreamRepository employerStreamRepository) {
        this.employerStreamRepository = employerStreamRepository;
    }

    public void storeEvent(Employer employer) {
        employerStreamRepository.storeEventInStream(employer);
    }
}