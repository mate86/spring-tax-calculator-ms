package com.balazsm.springtaxcalculatorms.service.impl;

import com.balazsm.springtaxcalculatorms.model.CountryDto;
import com.balazsm.springtaxcalculatorms.model.RatesDto;
import com.balazsm.springtaxcalculatorms.service.interfaces.VatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class VatServiceImpl implements VatService {

    public List<CountryDto> calculateHighestStandardVatRates(RatesDto ratesDto) {
        Comparator<CountryDto> comparator = Comparator.comparing(countryRate -> Float.parseFloat(countryRate.getStandardRate()));
        Stream<CountryDto> countryRateDtoStream = ratesDto.getVatRateMap().values().stream()
                .filter(countryRate -> !countryRate.getStandardRate().equals("false"));
        return getCountryRateDtos(countryRateDtoStream, comparator.reversed());
    }

    public List<CountryDto> calculateLowestReducedVatRates(RatesDto ratesDto) {
        Comparator<CountryDto> comparator = Comparator.comparing(countryRate -> Float.parseFloat(countryRate.getReducedRate()));
        Stream<CountryDto> countryRateDtoStream = ratesDto.getVatRateMap().values().stream()
                .filter(countryRate -> !countryRate.getReducedRate().equals("false"));
        return getCountryRateDtos(countryRateDtoStream, comparator);
    }

    private List<CountryDto> getCountryRateDtos(Stream<CountryDto> countryRateDtoStream, Comparator<CountryDto> comparator) {
        return countryRateDtoStream
                .distinct()
                .sorted(comparator)
                .limit(3)
                .collect(Collectors.toList());
    }
}
