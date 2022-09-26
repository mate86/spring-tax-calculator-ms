package com.balazsm.springtaxcalculatorms.model;

import lombok.Data;

@Data
public class VatRate {

    private String country;
    private String standardRate;
    private String reducedRate;
    private String reducedRateAlt;
    private String superReducedRate;
    private String parkingRate;
}
