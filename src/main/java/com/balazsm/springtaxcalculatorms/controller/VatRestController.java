package com.balazsm.springtaxcalculatorms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/vat")
public class VatRestController {

    @GetMapping("/highest-rate")
    public ResponseEntity<String> getHighestStandardVatRate() {
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/lowest-rate")
    public ResponseEntity<String> getLowestReducedVatRate() {
        return ResponseEntity.ok("OK");
    }
}
