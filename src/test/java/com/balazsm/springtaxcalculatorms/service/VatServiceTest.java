package com.balazsm.springtaxcalculatorms.service;

import com.balazsm.springtaxcalculatorms.model.VatRate;
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
class VatServiceTest {

    private static final String TEST_JSON_PATH = "src/test/resources/vat_rates.json";

    private final String jsonString = new String(Files.readAllBytes(Paths.get(TEST_JSON_PATH)));

    @InjectMocks
    private VatService vatService;

    VatServiceTest() throws IOException {
    }

    @Test
    void calculateHighestVatRates() {
        List<VatRate> highestVatRates = vatService.calculateHighestVatRates(jsonString);
        assertFalse(highestVatRates.isEmpty());
        assertEquals(3, highestVatRates.size());
    }

    @Test
    void calculateLowestVatRates() {
        List<VatRate> lowestVatRates = vatService.calculateLowestVatRates(jsonString);
        assertFalse(lowestVatRates.isEmpty());
        assertEquals(3, lowestVatRates.size());
    }
}