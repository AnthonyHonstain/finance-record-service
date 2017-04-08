package com.finance.financerecord.core;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;


public interface PriceDAO {

    //@SqlUpdate("create table something (id int primary key, name varchar(100))")
    //void createSomethingTable();

    @SqlUpdate("insert into price (ticker) value (:ticker)")
    @GetGeneratedKeys
    int insert(@Bind("ticker") String ticker);

    @SqlQuery("select id, ticker from price where id = :id")
    @Mapper(PriceMapper.class)
    Price findTickerById(@Bind("id") int id);
}
