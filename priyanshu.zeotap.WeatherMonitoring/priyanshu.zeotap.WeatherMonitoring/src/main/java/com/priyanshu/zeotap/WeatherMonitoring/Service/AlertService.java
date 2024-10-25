package com.priyanshu.zeotap.WeatherMonitoring.Service;


import org.springframework.stereotype.Service;

@Service
public class AlertService {

    private static final double TEMP_THRESHOLD = 35.0;

    public void checkForAlerts(String city, double temp){
        if(temp > TEMP_THRESHOLD){
            System.out.println("ALERT: High temperature in" + city + "! Current Temp: " + temp);
        }
    }
}
