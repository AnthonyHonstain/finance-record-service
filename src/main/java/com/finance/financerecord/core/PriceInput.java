package com.finance.financerecord.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;


public class PriceInput {

    @Length(max = 4)
    private String ticker;

    public PriceInput() {
        // Jackson deserialization
    }

    public PriceInput(String ticker) {
        this.ticker = ticker;
    }

    @JsonProperty
    public String getTicker() {
        return ticker;
    }
}
