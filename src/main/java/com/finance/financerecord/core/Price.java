package com.finance.financerecord.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;


public class Price {
    private int id;

    @Length(max = 4)
    private String ticker;

    public Price() {
        // Jackson deserialization
    }

    public Price(int id, String ticker) {
        this.id = id;
        this.ticker = ticker;
    }

    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public String getTicker() {
        return ticker;
    }
}