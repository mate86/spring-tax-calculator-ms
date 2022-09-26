package com.balazsm.springtaxcalculatorms.controller;

import com.balazsm.springtaxcalculatorms.model.VatRate;
import com.balazsm.springtaxcalculatorms.service.VatService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class VatRestControllerTest {

    @Mock
    private VatService vatService;

    @InjectMocks
    private VatRestController vatRestController;

    @Test
    void getHighestStandardVatRate() {
        ResponseEntity<List<VatRate>> response = vatRestController.getHighestStandardVatRate("request");
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void getLowestReducedVatRate() {
        ResponseEntity<List<VatRate>> response = vatRestController.getLowestReducedVatRate("request");
        assertEquals(200, response.getStatusCode().value());
    }
}