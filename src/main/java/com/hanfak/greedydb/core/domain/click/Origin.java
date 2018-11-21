package com.hanfak.greedydb.core.domain.click;

import com.hanfak.greedydb.core.domain.ValueType;

public class Origin extends ValueType {
    private final Brand brand;
    private final Position pos;

    private Origin(Brand brand, Position pos) {
        this.brand = brand;
        this.pos = pos;
    }

    public static Origin origin(Brand brand, Position pos) {
        return new Origin(brand, pos);
    }
}
