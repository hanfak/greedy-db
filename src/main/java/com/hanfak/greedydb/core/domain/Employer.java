package com.hanfak.greedydb.core.domain;

import java.sql.Timestamp;

// TODO: ValueType, static factory method
public class Employer {
    private final Timestamp timestamp;
    private final int id;
    private final String name;
    private final String surname;

    public Employer(Timestamp timestamp, int id, String name, String surname) {
        this.timestamp = timestamp;
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
