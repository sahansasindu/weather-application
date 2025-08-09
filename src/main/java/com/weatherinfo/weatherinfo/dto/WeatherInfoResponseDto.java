package com.weatherinfo.weatherinfo.dto;

public class WeatherInfoResponseDto {
    private String cityName;
    private String description;
    private double temperature;

    public WeatherInfoResponseDto(String cityName, String description, double temperature) {
        this.cityName = cityName;
        this.description = description;
        this.temperature = temperature;
    }

    public String getCityName() { return cityName; }
    public String getDescription() { return description; }
    public double getTemperature() { return temperature; }
}

