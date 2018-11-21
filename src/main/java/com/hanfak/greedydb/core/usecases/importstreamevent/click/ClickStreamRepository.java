package com.hanfak.greedydb.core.usecases.importstreamevent.click;

import com.hanfak.greedydb.core.domain.Click;

import java.sql.Timestamp;

// TODO better name for specific action, interface will not be used in all usecases
public interface ClickStreamRepository {
    void storeEventInStream(Click click);

    String findFieldForGivenTimestamp(Timestamp timestamp, String jsonPath);
}
