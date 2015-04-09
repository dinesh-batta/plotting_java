package com.charting.utils;

public class QueryBuilder {

    private QueryBuilder() {
    }

    private static final QueryBuilder builder = new QueryBuilder();

    private static String table;

    public QueryBuilder setTable(String tableName) {
	table = tableName;
	return builder;
    }

    public static QueryBuilder getBuilder() {
	return builder;
    }

    public String build() {
	return "select * from " + table;
    }

}
