package com.priyanshu.zeotap.WeatherMonitoring.Service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherProcessor {

//    for converting Java objects to JSON (serialization) and JSON to Java objects (deserialization).
private final ObjectMapper objectMapper;
    private final Map<String, DailySummary> dailySummaries = new HashMap<>();

    public WeatherProcessor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void processWeatherData(String city, String response, String unit) throws Exception{
        JsonNode rootNode = objectMapper.readTree(response);

        // Check if the JSON structure matches the expected format
        JsonNode weatherNode = rootNode.path("weather"); //This line accesses the weather array from the rootNode.
        JsonNode mainNode = rootNode.path("main");

        if (weatherNode.isMissingNode() || weatherNode.get(0).path("main").isMissingNode() || mainNode.isMissingNode()) {
            throw new IllegalArgumentException("Invalid JSON structure in response");
        }
        String mainCondition = weatherNode.get(0).path("main").asText();
        double tempKelvin = mainNode.path("temp").asDouble();

        unit = (unit == null || unit.isEmpty()) ? "C" : unit;

        double tempConverted = convertTemperature(tempKelvin, unit);
    }

    private double convertTemperature(double tempKelvin, String unit) {
        // Convert to uppercase to handle case insensitivity
        switch (unit.toUpperCase()) {
            case "F":
                return (tempKelvin - 273.15) * 9 / 5 + 32; // Kelvin to Fahrenheit
            case "C":
                return tempKelvin - 273.15; // Kelvin to Celsius
            case "K":
            default:
                return tempKelvin; // Default to Kelvin
        }
    }

    private void updateDailySummary(String city, double temp, String mainCondition){
        DailySummary summary = dailySummaries.getOrDefault(city, new DailySummary());
    }
}
