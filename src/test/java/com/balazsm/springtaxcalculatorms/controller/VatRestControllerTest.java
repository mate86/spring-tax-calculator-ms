package com.balazsm.springtaxcalculatorms.controller;

import com.balazsm.springtaxcalculatorms.model.CountryDto;
import com.balazsm.springtaxcalculatorms.model.RatesDto;
import com.balazsm.springtaxcalculatorms.service.impl.VatServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VatRestControllerTest {

    private static final List<CountryDto> COUNTRY_RATE_DTOS = List.of(new CountryDto(), new CountryDto(), new CountryDto());

    @Mock
    private VatServiceImpl vatService;

    @InjectMocks
    private VatRestController vatRestController;

    @Test
    void getHighestStandardVatRate_jsonIsValid_returnsOk() {
        when(vatService.calculateHighestStandardVatRates(any(RatesDto.class))).thenReturn(COUNTRY_RATE_DTOS);

        ResponseEntity<List<CountryDto>> response = vatRestController.getHighestStandardVatRates(new RatesDto());

        assertEquals(200, response.getStatusCode().value());
        assertEquals(3, Objects.requireNonNull(response.getBody()).size());
    }

    @Test
    void getLowestReducedVatRate_jsonIsValid_returnsOk() {
        when(vatService.calculateLowestReducedVatRates(any(RatesDto.class))).thenReturn(COUNTRY_RATE_DTOS);

        ResponseEntity<List<CountryDto>> response = vatRestController.getLowestReducedVatRates(new RatesDto());

        assertEquals(200, response.getStatusCode().value());
        assertEquals(3, Objects.requireNonNull(response.getBody()).size());
    }
}