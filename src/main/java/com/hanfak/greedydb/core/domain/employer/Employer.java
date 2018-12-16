package com.hanfak.greedydb.core.domain.employer;

import com.hanfak.greedydb.core.domain.ValueType;

import java.sql.Timestamp;

public class Employer extends ValueType {

    private final Timestamp timestamp;
    public final Id id;
    private final Name name;
    private final Surname surname;

    private Employer(Timestamp timestamp, Id id, Name name, Surname surname) {
        this.timestamp = timestamp;
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public static Employer employer(Timestamp timestamp, Id id, Name name, Surname surname) {
        return new Employer(timestamp, id, name, surname);
    }
}
