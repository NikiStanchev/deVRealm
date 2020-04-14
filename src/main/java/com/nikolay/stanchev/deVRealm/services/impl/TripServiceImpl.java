package com.nikolay.stanchev.deVRealm.services.impl;

import com.nikolay.stanchev.deVRealm.models.Country;
import com.nikolay.stanchev.deVRealm.models.Trip;
import com.nikolay.stanchev.deVRealm.services.TripService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    private final ExchangeServiceImpl exchangeService;
    private final CountryServiceImpl countryService;

    public TripServiceImpl(ExchangeServiceImpl exchangeService,
                           CountryServiceImpl countryService) {
        this.exchangeService = exchangeService;
        this.countryService = countryService;
    }


    @Override
    public Trip getTripByBudget(String startingCountry, Double countryBudget, Double totalBudget, String currency) {
        List<String> neighbours = countryService.getAllNeighbours(startingCountry);

        int numberOfTrips = (int) (totalBudget / (neighbours.size() * countryBudget));
        Double moneyLeft = (totalBudget % (neighbours.size() * countryBudget));

        Trip trip = new Trip();
        trip.setMoneyLeft(moneyLeft);
        trip.setTravelNumber(numberOfTrips);
        trip.setNeighbours(neighbours);
        trip.setStartCountry(startingCountry);
        trip.setInputCurrency(currency);

        List<Country> countries = new ArrayList<>();
        for(String neighbour : neighbours){
            Country country = new Country();
            country.setCountryCode(neighbour);
            country.setCurrencyCode(exchangeService.getCurrencyCodeByCountryCode(neighbour));
            country.setMoneyNeeded(exchangeService.calculateCurrency(
                    countryBudget,
                    currency,
                    country.getCurrencyCode()) * numberOfTrips
            );
            countries.add(country);
        }
        trip.setMoneyForCountries(countries);

        return trip;
    }
}
