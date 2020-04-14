package com.nikolay.stanchev.deVRealm.services.impl;

import com.nikolay.stanchev.deVRealm.services.CountryService;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class CountryServiceImpl implements CountryService {


    @Value("${countries}")
    private String countriesFilename;

    @Override
    public List<String> getAllNeighbours(String country) {
        // TODO
        if(country.equalsIgnoreCase("BG")){
            return Arrays.asList("TR", "GR", "MK", "SR", "RO");
        }
        return new ArrayList<>();
    }

    @Override
    public Map<String, String> getAllCountryCodes() throws IOException {

        Map<String, String> countries = new HashMap<>();
        Resource resource = new ClassPathResource(countriesFilename);
        try {
            File file = resource.getFile();
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] line;
            while ((line = reader.readNext()) != null) {
                countries.put(line[1], line[3]);
            }
        } catch (IOException e) {
            throw new IOException(e);
        }
        return countries;
    }
}