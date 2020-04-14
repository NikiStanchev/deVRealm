package com.nikolay.stanchev.deVRealm.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CountryService {

    List<String> getAllNeighbours(String country);
    Map<String, String> getAllCountryCodes() throws IOException;
}