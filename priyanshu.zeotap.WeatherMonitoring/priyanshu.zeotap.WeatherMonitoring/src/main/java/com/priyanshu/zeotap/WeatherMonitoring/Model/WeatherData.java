package com.priyanshu.zeotap.WeatherMonitoring.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
    public class WeatherData {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id; // Unique identifier for the record

        private String city; // Name of the city
        private double temperature; // Current temperature in Celsius
        private double feelsLike; // Perceived temperature in Celsius
        private String weatherCondition; // Current weather condition (e.g., Rain, Clear)

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public double getFeelsLike() {
            return feelsLike;
        }

        public void setFeelsLike(double feelsLike) {
            this.feelsLike = feelsLike;
        }

        public String getWeatherCondition() {
            return weatherCondition;
        }

        public void setWeatherCondition(String weatherCondition) {
            this.weatherCondition = weatherCondition;
        }
}
