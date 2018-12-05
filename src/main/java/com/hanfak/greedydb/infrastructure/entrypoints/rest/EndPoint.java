package com.hanfak.greedydb.infrastructure.entrypoints.rest;

import java.util.List;

import static java.util.Arrays.asList;

public class EndPoint {
    final String method;
    final String path;
    final List<String> parameterNames;

    private EndPoint(String method, String path, List<String> parameterNames) {
        this.method = method;
        this.path = path;
        this.parameterNames = parameterNames;
    }

    public static EndPoint get(String path, String... parameterNames) {
        return new EndPoint("GET", path, asList(parameterNames));
    }
}