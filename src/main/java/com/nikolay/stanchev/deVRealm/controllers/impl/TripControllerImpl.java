package com.nikolay.stanchev.deVRealm.controllers.impl;

import com.nikolay.stanchev.deVRealm.controllers.TripController;
import com.nikolay.stanchev.deVRealm.models.Trip;
import com.nikolay.stanchev.deVRealm.services.impl.TripServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TripControllerImpl implements TripController {

    private final TripServiceImpl tripService;
    public TripControllerImpl(TripServiceImpl tripService) {
        this.tripService = tripService;
    }


    @Override
    public ResponseEntity travels(Double countryBudget, Double totalBudget) {
        Trip trip = tripService.getTripByBudget(countryBudget, totalBudget);
        return ResponseEntity.ok(trip);
    }
}
