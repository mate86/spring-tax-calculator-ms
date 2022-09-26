package com.balazsm.springtaxcalculatorms.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class VatRestControllerTest {

    @InjectMocks
    private VatRestController vatRestController;

    @Test
    void getHighestStandardVatRate() {
        ResponseEntity<String> response = vatRestController.getHighestStandardVatRate();
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void getLowestReducedVatRate() {
        ResponseEntity<String> response = vatRestController.getLowestReducedVatRate();
        assertEquals(200, response.getStatusCode().value());
    }
}