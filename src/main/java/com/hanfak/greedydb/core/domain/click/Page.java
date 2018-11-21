package com.hanfak.greedydb.core.domain.click;

import com.hanfak.greedydb.core.domain.SingleValueType;

public class Page extends SingleValueType<String> {
    private Page(String value) {
        super(value);
    }

    public static Page page(String page) {
        return new Page(page);
    }
}
