package com.hanfak.greedydb.core.usecases;

import com.hanfak.greedydb.core.domain.click.Click;

import java.sql.Timestamp;

// TODO better name for specific action, interface will not be used in all usecases
public interface ClickStreamRepository<T> {
    void storeEventInStream(Click click);

    T findFieldForGivenTimestamp(Timestamp timestamp, String jsonPath);

    T findFieldForLatestTimestamp(String originBrandJsonPath);
}
