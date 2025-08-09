package com.weatherinfo.weatherinfo.controller;

import com.weatherinfo.weatherinfo.dto.WeatherInfoResponseDto;
import com.weatherinfo.weatherinfo.service.impl.WeatherServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WeatherController {

    private final WeatherServiceImpl weatherServiceImpl;

    public WeatherController(WeatherServiceImpl weatherServiceImpl) {
        this.weatherServiceImpl = weatherServiceImpl;
    }

    @GetMapping("/weather")
    public String greet(Model model) {
        List<WeatherInfoResponseDto> weatherList = weatherServiceImpl.getWeatherForAllCities();
        model.addAttribute("weatherList", weatherList);
        return "weather";
    }

    @GetMapping("/public")
    public String publicPage() {
        return "This is a public page. No login required.";
    }
}
