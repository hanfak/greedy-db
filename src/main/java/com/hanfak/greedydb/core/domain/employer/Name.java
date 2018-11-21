package com.hanfak.greedydb.core.domain.employer;

import com.hanfak.greedydb.core.domain.SingleValueType;

public class Name extends SingleValueType<String> {
    private Name(String value) {
        super(value);
    }

    public static Name name(String name) {
        return new Name(name);
    }
}
