package com.priyanshu.zeotap.WeatherMonitoring.Service;

import java.util.ArrayList;

public class DailySummary {
    private ArrayList<Double> temperatures = new ArrayList<>();
    private int conditionCount = 0;
    private String dominantCondition;

    public void update(double temp, String condition){
        temperatures.add(temp);
        conditionCount++;
        dominantCondition = condition;
    }

    public double getAverageTemperature() {
        return temperatures.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public double getMaxTemperature() {
        return temperatures.stream().mapToDouble(Double::doubleValue).max().orElse(0);
    }

    public double getMinTemperature() {
        return temperatures.stream().mapToDouble(Double::doubleValue).min().orElse(0);
    }

}
