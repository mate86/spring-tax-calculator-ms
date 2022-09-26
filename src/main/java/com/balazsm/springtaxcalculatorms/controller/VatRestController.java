package com.balazsm.springtaxcalculatorms.controller;

import com.balazsm.springtaxcalculatorms.model.VatRate;
import com.balazsm.springtaxcalculatorms.service.VatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rest/vat")
public class VatRestController {

    private final VatService vatService;

    @GetMapping("/highest-rate")

    public ResponseEntity<List<VatRate>> getHighestStandardVatRate(@RequestBody String requestJson) {
        List<VatRate> highestVatRates = vatService.calculateHighestVatRates(requestJson);
        return ResponseEntity.ok(highestVatRates);
    }

    @GetMapping("/lowest-rate")
    public ResponseEntity<List<VatRate>> getLowestReducedVatRate(@RequestBody String requestJson) {
        List<VatRate> lowestVatRates = vatService.calculateLowestVatRates(requestJson);
        return ResponseEntity.ok(lowestVatRates);
    }
}
