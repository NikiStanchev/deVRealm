package com.nikolay.stanchev.deVRealm.services;

public interface ExchangeService {

    String getCurrencyCodeByCountryCode(String countryCode);
    Double calculateCurrency(Double countryBudget, String currency, String currencyCode);
}