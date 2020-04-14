package com.nikolay.stanchev.deVRealm.services;

import com.nikolay.stanchev.deVRealm.models.Trip;

import java.util.List;

public interface TripService {

    Trip getTripByBudget(Double countryBudget, Double totalBudget);
}
