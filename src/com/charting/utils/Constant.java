package com.charting.utils;

public class Constant {

    public static final String DATABASE_USER = "root";
    public static final String DATABASE_PASSWORD = "root";

    public static final String SANDMAN_DATABASE = "localhost/sandman_dev";
    public static final String SANDMAN_QUERY = "select * from preparedsand where foundry_line_id = 6 limit 10000";
    public static final String SANDMAN_X = "active_clay";
    public static final String SANDMAN_Y = "gcs";

    public static final String TRADEPLUS_DATABASE = "localhost/tradeplus_dev";
    public static final String TRADEPLUS_QUERY = "select sum(trade_qty * trade_price) as turnover, sum(if(buy_sell = 'B',(-trade_qty * trade_price),(trade_qty * trade_price))) as profit from equity where account_id = 'cbm00222' group by trade_date";
    public static final String TRADEPLUS_X = "turnover";
    public static final String TRADEPLUS_Y = "profit";

    public static final String DB_URL = "Data Base URL";
    public static final String TABLE_NAME = "Table Name";
    public static final String X_AXIS = "X Axis";
    public static final String Y_AXIS = "Y Axis";
    public static final String SEARCH = "Search";
}
