package com.nikolay.stanchev.deVRealm.services.impl;

import com.nikolay.stanchev.deVRealm.services.ExchangeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final RestTemplate restTemplate;

    @Value("${service-exchange}")
    public String URL;

    public ExchangeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private LinkedHashMap getLatestExchangeRate() {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseEntity responseEntity = restTemplate.exchange(
                URL,
                HttpMethod.GET,
                new HttpEntity<>( httpHeaders ),
                Map.class);

        LinkedHashMap latestExchangeRate = (LinkedHashMap) responseEntity.getBody();
        assert latestExchangeRate != null;
        return (LinkedHashMap) latestExchangeRate.get("rates");
    }

    @Override
    public String getCurrencyCodeByCountryCode(String countryCode) {
        Map<String, String> currencyCodes  = new HashMap<>() {{
            put("SR", "RSD");
            put("MK", "MKD");
            put("TR", "TRY");
            put("RO", "RON");
            put("GR", "EUR");
        }};

        return currencyCodes.get(countryCode);
    }

    @Override
    public Double calculateCurrency(Double countryBudget, String currency, String currencyCode) {
        LinkedHashMap rates = getLatestExchangeRate();
        return Math.round((countryBudget / Double.valueOf(rates.get(currency).toString()))
                * Double.valueOf(rates.get(currencyCode).toString()) * 100.0) / 100.0;
    }
}