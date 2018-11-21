package com.hanfak.greedydb.core.domain.click;

import com.hanfak.greedydb.core.domain.SingleValueType;

public class Position extends SingleValueType<String> {
    private Position(String value) {
        super(value);
    }

    public static Position position(String position) {
        return new Position(position);
    }
}
