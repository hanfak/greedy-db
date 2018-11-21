package com.hanfak.greedydb.core.domain.click;

import com.hanfak.greedydb.core.domain.SingleValueType;

public class Brand extends SingleValueType<String> {
    private Brand(String value) {
        super(value);
    }

    public static Brand brand(String brand) {
        return new Brand(brand);
    }
}
