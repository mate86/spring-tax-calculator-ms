package com.balazsm.springtaxcalculatorms.controller;

import com.balazsm.springtaxcalculatorms.model.CountryDto;
import com.balazsm.springtaxcalculatorms.model.RatesDto;
import com.balazsm.springtaxcalculatorms.service.interfaces.VatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("rest/vat")
public class VatRestController {

    private final VatService vatService;

    @GetMapping("/highest-rate")
    public ResponseEntity<List<CountryDto>> getHighestStandardVatRates(@Valid @RequestBody RatesDto ratesDto) {
        List<CountryDto> highestVatRates = vatService.calculateHighestStandardVatRates(ratesDto);
        return ResponseEntity.ok(highestVatRates);
    }

    @GetMapping("/lowest-rate")
    public ResponseEntity<List<CountryDto>> getLowestReducedVatRates(@Valid @RequestBody RatesDto ratesDto) {
        List<CountryDto> lowestVatRates = vatService.calculateLowestReducedVatRates(ratesDto);
        return ResponseEntity.ok(lowestVatRates);
    }
}
