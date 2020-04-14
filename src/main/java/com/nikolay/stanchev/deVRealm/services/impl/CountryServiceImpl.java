package com.nikolay.stanchev.deVRealm.services.impl;

import com.nikolay.stanchev.deVRealm.services.CountryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Override
    public List<String> getAllNeighbours(String country) {
        if(country.equalsIgnoreCase("BG")){
            return Arrays.asList("TR", "GR", "MK", "SR", "RO");
        }
        return null;
    }
}