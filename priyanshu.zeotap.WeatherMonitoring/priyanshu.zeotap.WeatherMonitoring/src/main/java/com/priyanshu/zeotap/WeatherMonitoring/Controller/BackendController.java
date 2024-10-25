package com.priyanshu.zeotap.WeatherMonitoring.Controller;


import com.priyanshu.zeotap.WeatherMonitoring.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackendController {

    @Autowired
    private WeatherService  weatherService;

@GetMapping("/api/weather")
    public String getWeather(@RequestParam String city, @RequestParam(defaultValue = "C") String unit){
    return weatherService.getWeatherForCity(city, unit);
}
}

