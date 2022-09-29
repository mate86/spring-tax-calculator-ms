package com.balazsm.springtaxcalculatorms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
@ApiModel(value = "RatesDto", description = "Represents the JSON request")
public class RatesDto {

    @JsonProperty("last_updated")
    private Date lastUpdated;

    @JsonProperty("disclaimer")
    private String disclaimer;

    @JsonProperty("rates")
    private Map<String, CountryDto> vatRateMap;
}
