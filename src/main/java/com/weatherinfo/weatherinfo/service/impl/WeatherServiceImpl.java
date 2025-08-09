package com.weatherinfo.weatherinfo.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherinfo.weatherinfo.dto.WeatherInfoResponseDto;
import com.weatherinfo.weatherinfo.service.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    @Value("${openweathermap.api.url}")
    private String apiUrl;


    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();


    private final CityServiceImpl cityServiceImpl;

    public WeatherServiceImpl(CityServiceImpl cityServiceImpl) {
        this.cityServiceImpl = cityServiceImpl;
    }


    @Cacheable("weatherData")
    @Override
    public List<WeatherInfoResponseDto> getWeatherForAllCities() {

        List<String> cityCodes = cityServiceImpl.getCityCodes();
        List<WeatherInfoResponseDto> weatherList = new ArrayList<>();


        for (String cityId : cityCodes) {
            try {
                String url = String.format("%s?id=%s&units=metric&appid=%s", apiUrl, cityId, apiKey);
                String response = restTemplate.getForObject(url, String.class);

                if(response==null){
                    System.out.println("No weather data found for city id");
                }

                JsonNode json = mapper.readTree(response);

                String cityName = json.get("name").asText();
                String description = json.get("weather").get(0).get("description").asText();
                double temperature = json.get("main").get("temp").asDouble();

                weatherList.add(new WeatherInfoResponseDto(cityName, description, temperature));

            } catch (Exception e) {

                System.out.println("Error fetching weather for city id" + e);

            }

        }

        return weatherList;

    }

}

