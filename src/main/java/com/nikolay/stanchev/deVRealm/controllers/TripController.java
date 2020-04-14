package com.nikolay.stanchev.deVRealm.controllers;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/travel")
public interface TripController {

    @RequestMapping(path = "/{startingCountry}/{countryBudget}/{totalBudget}/{currency}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity travels(
            @PathVariable String startingCountry,
            @PathVariable Double countryBudget,
            @PathVariable Double totalBudget,
            @PathVariable String currency
    );
}
