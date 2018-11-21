package com.hanfak.greedydb.core.domain.employer;

import com.hanfak.greedydb.core.domain.SingleValueType;

public class Id extends SingleValueType<Long> {
    private Id(Long value) {
        super(value);
    }

    public static Id id(Long id) {
        return new Id(id);
    }
}
