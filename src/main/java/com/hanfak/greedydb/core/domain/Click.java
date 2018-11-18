package com.hanfak.greedydb.core.domain;

import java.sql.Timestamp;

// TODO: ValueType, static factory method
public class Click {
    private final Timestamp timestamp;
    private final String page;
    public final Origin origin;

    public Click(Timestamp timestamp, String page, Origin origin) {
        this.timestamp = timestamp;
        this.page = page;
        this.origin = origin;
    }
}
