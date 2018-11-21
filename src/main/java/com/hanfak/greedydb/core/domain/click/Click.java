package com.hanfak.greedydb.core.domain.click;

import com.hanfak.greedydb.core.domain.ValueType;

import java.sql.Timestamp;

public class Click extends ValueType {
    private final Timestamp timestamp;
    private final Page page;
    public final Origin origin;

    private Click(Timestamp timestamp, Page page, Origin origin) {
        this.timestamp = timestamp;
        this.page = page;
        this.origin = origin;
    }

    public static Click click(Timestamp timestamp, Page page, Origin origin) {
        return new Click(timestamp, page, origin);
    }
}
