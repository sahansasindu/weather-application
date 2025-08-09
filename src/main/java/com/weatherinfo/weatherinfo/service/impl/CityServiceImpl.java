package com.weatherinfo.weatherinfo.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherinfo.weatherinfo.service.CityService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Override
    public List<String> getCityCodes() {
        List<String> cityCodes = new ArrayList<>();
        try {

            ClassPathResource resource = new ClassPathResource("cities.json");
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(resource.getInputStream());

            for (JsonNode city : rootNode.get("List")) {
                cityCodes.add(city.get("CityCode").asText());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading cities", e);
        }
        return cityCodes;
    }
}
