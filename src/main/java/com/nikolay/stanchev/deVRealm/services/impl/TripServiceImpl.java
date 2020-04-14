package com.nikolay.stanchev.deVRealm.services.impl;

import com.nikolay.stanchev.deVRealm.models.Country;
import com.nikolay.stanchev.deVRealm.models.Trip;
import com.nikolay.stanchev.deVRealm.services.TripService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class TripServiceImpl implements TripService {


    @Override
    public Trip getTripByBudget(Double countryBudget, Double totalBudget) {
        Trip trip = new Trip();

        trip.setMoneyLeft(totalBudget);

        Country bg = new Country();
        bg.setCurrencyCode("BG");
        bg.setMoneyNeeded(countryBudget);

        List<Country> countries = new ArrayList<>();
        countries.add(bg);
        trip.setMoneyForCountries(countries);


        return trip;
    }
}
