package com.hanfak.greedydb.core.usecases;

import com.hanfak.greedydb.core.domain.click.Click;

import java.sql.Timestamp;

// TODO better name for specific action, interface will not be used in all usecases
public interface ClickStreamRepository {
    void storeEventInStream(Click click);

    Long findFieldForGivenTimestamp(Timestamp timestamp, String jsonPath);
}
