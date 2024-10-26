package com.priyanshu.zeotap.WeatherMonitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.priyanshu.zeotap.WeatherMonitoring")
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

}
