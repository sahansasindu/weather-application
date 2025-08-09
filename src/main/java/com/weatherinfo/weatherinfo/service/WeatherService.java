package com.weatherinfo.weatherinfo.service;

import com.weatherinfo.weatherinfo.dto.WeatherInfoResponseDto;

import java.util.List;

public interface WeatherService {
    public List<WeatherInfoResponseDto> getWeatherForAllCities();
}
