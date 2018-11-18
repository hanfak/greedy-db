package com.hanfak.greedydb.core.usecases.importstreamevent.employer;

import com.hanfak.greedydb.core.domain.Employer;
// TODO better name for specific action, interface will not be used in all usecases
public interface EmployerStreamRepository {
    void storeEventInStream(Employer employer);
}
