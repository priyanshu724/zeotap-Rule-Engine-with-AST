package com.priyanshu.zeotap.WeatherMonitoring.Service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${weather.api.url}")
    private String apiUrl;

    @Value("${weather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String getWeatherForCity(String city, String unit) {
        String url = apiUrl.replace("{city}", city).replace("{key}", apiKey);

        // Make the API call to fetch weather data
        String response = restTemplate.getForObject(url, String.class);

        // Process and return the response with the selected unit
        return processWeatherData(response, unit);
    }

    private String processWeatherData(String response, String unit) {
        try {
            // Parse the API response into a JSON object
            ObjectNode rootNode = (ObjectNode) objectMapper.readTree(response);

            // Access and convert the temperature values in the "main" section
            double tempKelvin = rootNode.path("main").path("temp").asDouble();
            double feelsLikeKelvin = rootNode.path("main").path("feels_like").asDouble();
            double tempMinKelvin = rootNode.path("main").path("temp_min").asDouble();
            double tempMaxKelvin = rootNode.path("main").path("temp_max").asDouble();

            // Perform temperature conversion based on the user’s preference
            double convertedTemp = convertTemperature(tempKelvin, unit);
            double convertedFeelsLike = convertTemperature(feelsLikeKelvin, unit);
            double convertedTempMin = convertTemperature(tempMinKelvin, unit);
            double convertedTempMax = convertTemperature(tempMaxKelvin, unit);

            // Update the JSON object with the converted values
            rootNode.with("main").put("temp", convertedTemp);
            rootNode.with("main").put("feels_like", convertedFeelsLike);
            rootNode.with("main").put("temp_min", convertedTempMin);
            rootNode.with("main").put("temp_max", convertedTempMax);

            // Return the modified JSON as a String
            return objectMapper.writeValueAsString(rootNode);

        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\": \"Error processing weather data\"}";
        }
    }

    private double convertTemperature(double tempKelvin, String unit) {
        switch (unit.toUpperCase()) {
            case "F":
                return (tempKelvin - 273.15) * 9 / 5 + 32; // Convert Kelvin to Fahrenheit
            case "C":
                return tempKelvin - 273.15; // Convert Kelvin to Celsius
            case "K":
            default:
                return tempKelvin; // Keep in Kelvin if unit is "K"
        }
    }
}
