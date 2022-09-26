package com.balazsm.springtaxcalculatorms.service;

import com.balazsm.springtaxcalculatorms.model.VatRate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VatService {

    public List<VatRate> calculateHighestVatRates(String requestJson) {
        return new ArrayList<>();
    }

    public List<VatRate> calculateLowestVatRates(String requestJson) {
        return new ArrayList<>();
    }
}
