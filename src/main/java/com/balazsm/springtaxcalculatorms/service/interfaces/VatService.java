package com.balazsm.springtaxcalculatorms.service.interfaces;

import com.balazsm.springtaxcalculatorms.model.CountryDto;
import com.balazsm.springtaxcalculatorms.model.RatesDto;

import java.util.List;

public interface VatService {

    List<CountryDto> calculateHighestStandardVatRates(RatesDto ratesDto);

    List<CountryDto> calculateLowestReducedVatRates(RatesDto ratesDto);
}
