package com.nikolay.stanchev.deVRealm.models;

import java.util.List;

public class Trip {
    private String startCountry;
    private List<String> neighbours;
    private Integer travelNumber;
    private Double moneyLeft;
    private List<Country> moneyForCountries;

    public String getStartCountry() {
        return startCountry;
    }

    public void setStartCountry(String startCountry) {
        this.startCountry = startCountry;
    }

    public List<String> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<String> neighbours) {
        this.neighbours = neighbours;
    }

    public Integer getTravelNumber() {
        return travelNumber;
    }

    public void setTravelNumber(Integer travelNumber) {
        this.travelNumber = travelNumber;
    }

    public Double getMoneyLeft() {
        return moneyLeft;
    }

    public void setMoneyLeft(Double moneyLeft) {
        this.moneyLeft = moneyLeft;
    }

    public List<Country> getMoneyForCountries() {
        return moneyForCountries;
    }

    public void setMoneyForCountries(List<Country> moneyForCountries) {
        this.moneyForCountries = moneyForCountries;
    }
}
