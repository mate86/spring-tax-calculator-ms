package com.balazsm.springtaxcalculatorms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "CountryDto", description = "Represents the country in JSON request")
public class CountryDto {

    @JsonProperty(value = "country")
    private String countryName;

    @JsonProperty(value = "standard_rate")
    private String standardRate;

    @JsonProperty(value = "reduced_rate")
    private String reducedRate;

    @JsonProperty(value = "reduced_rate_alt")
    private String reducedRateAlt;

    @JsonProperty(value = "super_reduced_rate")
    private String superReducedRate;

    @JsonProperty(value = "parking_rate")
    private String parkingRate;
}
