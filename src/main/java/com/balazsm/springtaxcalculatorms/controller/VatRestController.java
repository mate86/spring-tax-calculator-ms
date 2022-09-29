package com.balazsm.springtaxcalculatorms.controller;

import com.balazsm.springtaxcalculatorms.model.CountryDto;
import com.balazsm.springtaxcalculatorms.model.RatesDto;
import com.balazsm.springtaxcalculatorms.service.interfaces.VatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "VatRestController", tags = {"VAT Rest Controller"})
public class VatRestController {

    private final VatService vatService;

    @GetMapping("/highest-rate")
    @ApiOperation(value = "Get highest standard VAT rates")
    @ApiResponses(value = {
            @ApiResponse(response = ResponseEntity.class, code = 200, message = "OK"),
            @ApiResponse(response = ResponseEntity.class, code = 400, message = "Bad Request")
    })
    public ResponseEntity<List<CountryDto>> getHighestStandardVatRates(@Valid @RequestBody RatesDto ratesDto) {
        List<CountryDto> highestVatRates = vatService.calculateHighestStandardVatRates(ratesDto);
        return ResponseEntity.ok(highestVatRates);
    }

    @GetMapping("/lowest-rate")
    @ApiOperation(value = "Get lowest reduced VAT rates")
    @ApiResponses(value = {
            @ApiResponse(response = ResponseEntity.class, code = 200, message = "OK"),
            @ApiResponse(response = ResponseEntity.class, code = 400, message = "Bad Request")
    })
    public ResponseEntity<List<CountryDto>> getLowestReducedVatRates(@Valid @RequestBody RatesDto ratesDto) {
        List<CountryDto> lowestVatRates = vatService.calculateLowestReducedVatRates(ratesDto);
        return ResponseEntity.ok(lowestVatRates);
    }
}
