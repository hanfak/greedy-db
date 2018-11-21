package com.hanfak.greedydb.core.domain.employer;

import com.hanfak.greedydb.core.domain.SingleValueType;

public class Surname extends SingleValueType<String> {
    private Surname(String value) {
        super(value);
    }

    public static Surname surname(String surname) {
        return new Surname(surname);
    }
}
