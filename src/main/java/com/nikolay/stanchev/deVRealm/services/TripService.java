package com.nikolay.stanchev.deVRealm.services;

import com.nikolay.stanchev.deVRealm.models.Trip;

public interface TripService {

    Trip getTripByBudget(String startingCountry, Double countryBudget, Double totalBudget, String currency);
}
