package com.balazsm.springtaxcalculatorms.service;

import com.balazsm.springtaxcalculatorms.model.CountryDto;
import com.balazsm.springtaxcalculatorms.model.RatesDto;
import com.balazsm.springtaxcalculatorms.service.impl.VatServiceImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
class VatServiceImplTest {

    private static final String TEST_JSON_PATH = "src/test/resources/vat_rates.json";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final String jsonString = new String(Files.readAllBytes(Paths.get(TEST_JSON_PATH)));
    private final RatesDto ratesDto = OBJECT_MAPPER.readValue(jsonString, RatesDto.class);

    @InjectMocks
    private VatServiceImpl vatService;

    VatServiceImplTest() throws IOException {
    }

    @BeforeAll
    static void beforeAll() {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Test
    void calculateHighestVatRates_jsonIsValid_returnsOk() {
        List<CountryDto> highestVatRates = vatService.calculateHighestStandardVatRates(ratesDto);

        assertFalse(highestVatRates.isEmpty());
        assertEquals(3, highestVatRates.size());
        assertEquals("Hungary", highestVatRates.get(0).getCountryName());
        assertEquals("Denmark", highestVatRates.get(1).getCountryName());
        assertEquals("Croatia", highestVatRates.get(2).getCountryName());
    }

    @Test
    void calculateLowestVatRates_jsonIsValid_returnsOk() {
        List<CountryDto> lowestVatRates = vatService.calculateLowestReducedVatRates(ratesDto);

        assertFalse(lowestVatRates.isEmpty());
        assertEquals(3, lowestVatRates.size());
        assertEquals("United Kingdom", lowestVatRates.get(0).getCountryName());
        assertEquals("Netherlands", lowestVatRates.get(1).getCountryName());
        assertEquals("Germany", lowestVatRates.get(2).getCountryName());
    }
}