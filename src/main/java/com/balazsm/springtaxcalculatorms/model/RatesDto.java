package com.balazsm.springtaxcalculatorms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class RatesDto {

    @JsonProperty("last_updated")
    private Date lastUpdated;

    @JsonProperty("disclaimer")
    private String disclaimer;

    @JsonProperty("rates")
    private Map<String, CountryDto> vatRateMap;
}
