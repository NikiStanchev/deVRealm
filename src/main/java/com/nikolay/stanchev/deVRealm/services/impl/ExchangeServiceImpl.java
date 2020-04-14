package com.nikolay.stanchev.deVRealm.services.impl;

import com.nikolay.stanchev.deVRealm.services.ExchangeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final RestTemplate restTemplate;

    @Value("${service-exchange}")
    public String URL;

    private final CountryServiceImpl countryService;

    public ExchangeServiceImpl(RestTemplate restTemplate, CountryServiceImpl countryService) {
        this.restTemplate = restTemplate;
        this.countryService = countryService;
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
        Map<String, String> countries = new HashMap<>();
        try {
            countries = countryService.getAllCountryCodes();
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return countries.get(countryCode);
    }

    @Override
    public Double calculateCurrency(Double countryBudget, String currency, String currencyCode) {
        LinkedHashMap rates = getLatestExchangeRate();
        return Math.round((countryBudget / Double.parseDouble(rates.get(currency).toString()))
                * Double.parseDouble(rates.get(currencyCode).toString()) * 100.0) / 100.0;
    }
}