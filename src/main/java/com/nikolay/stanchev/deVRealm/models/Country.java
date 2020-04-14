package com.nikolay.stanchev.deVRealm.models;

public class Country {
    private Double moneyNeeded;
    private String currencyCode;
    private String countryCode;

    public Double getMoneyNeeded() {
        return moneyNeeded;
    }

    public void setMoneyNeeded(Double moneyNeeded) {
        this.moneyNeeded = moneyNeeded;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
