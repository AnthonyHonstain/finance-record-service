package com.finance.financerecord.core;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PriceMapper implements ResultSetMapper<Price>
{
    public Price map(int index, ResultSet r, StatementContext ctx) throws SQLException
    {
        return new Price(r.getInt("id"), r.getString("ticker"));
    }
}