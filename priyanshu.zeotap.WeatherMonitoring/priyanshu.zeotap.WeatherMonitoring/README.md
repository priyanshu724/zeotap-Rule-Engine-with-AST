
# Real-Time Data Processing System for Weather Monitoring with Rollups and Aggregates

This project is a Real-Time Weather Monitoring System that continuously retrieves weather data from the OpenWeatherMap API for major cities across India. The system processes and analyzes this data to provide meaningful insights through rollups and aggregates, with capabilities for real-time alerts based on user-defined thresholds. Users can customize temperature units to their preference (Celsius, Fahrenheit, or Kelvin).


## Features

**Real-Time Weather Data Retrieval:** Continuously fetches weather data every 5 minutes for specified cities in India (Delhi, Mumbai, Chennai, Bangalore, Kolkata, and Hyderabad).

**Data Processing and Analysis:** 
- 	Converts temperatures from Kelvin to Celsius or Fahrenheit (based on user preference).
- Summarizes daily weather data for each city with aggregates including: 	Average, maximum, and minimum temperatures            Dominant weather conditions
- Generates alerts if temperatures exceed user-defined thresholds (e.g., alert if temperature exceeds 35°C).
**Weather Visualization:** Displays daily weather summaries, historical trends, and triggered alerts.
## Technology Used

This project is used by the following companies:

-	Java 17
-	Spring Boot 3.3.4
-	OpenWeatherMap API
-	RestTemplate for making HTTP requests
-	Spring Scheduling for real-time data fetching and processing
-	MySQL for database storage



## Project Setup Instructions

**Java 17:** Install Java 17 if not already installed.

**Maven:** Make sure Maven is installed to manage project dependencies.

**OpenWeatherMap API Key:** Sign up at OpenWeatherMap and obtain your free API key.


## How to Run the Project

**Clone this Repository:**

```bash
  git clone https://github.com/priyanshu724/Zeotap.-Real-Time-Data-Processing-System-for-Weather-Monitoring-with-Rollups-and-Aggregates.git
```

**Set up API Key:**

-	Open the application.properties file located in src/main/resources.
-	Update with your API key

```bash
  weather.api.url=https://api.openweathermap.org/data/2.5/weather?q={city}&appid={key}&units={units}
  weather.api.key=your_openweathermap_api_key
```
**Run the Application:**

```bash
  mvn spring-boot:run
```
- The application will be available at http://localhost:8080.
## Dependencies

-	Java 17
-	Spring Boot 3.3.4
-	Maven (for dependency management)
-	MySQL for persistent storage

## API Endpoints

**Get Weather by City:**

-	Endpoint: GET /api/weather?city={city_name}&units={unit}
-	Example: /api/weather?city=London&units=C
**Units Options:**
-	C: for Celsius
-	F: for Fahrenheit
-	K: for Kelvin
**Response:** Provides the current weather data for the specified city in the chosen unit.

## Example API Response:

```bash
  {
    "coord": {
        "lon": 77.33,
        "lat": 28.58
    },
    "weather": [
        {
            "id": 800,
            "main": "Clear",
            "description": "clear sky",
            "icon": "01d"
        }
    ],
    "base": "stations",
    "main": {
        "temp": 302.31,
        "feels_like": 300.9,
        "temp_min": 302.31,
        "temp_max": 302.31,
        "pressure": 1011,
        "humidity": 25,
        "sea_level": 1011,
        "grnd_level": 985
    },
    "visibility": 10000,
    "wind": {
        "speed": 2.15,
        "deg": 40,
        "gust": 2.52
    },
    "clouds": {
        "all": 0
    },
    "dt": 1729920960,
    "sys": {
        "type": 1,
        "id": 9165,
        "country": "IN",
        "sunrise": 1729904303,
        "sunset": 1729944638
    },
    "timezone": 19800,
    "id": 7279746,
    "name": "Noida",
    "cod": 200
}
```
## Data Processing and Analysis

**Real-Time Data Retrieval:**
-	The system calls the OpenWeatherMap API every 5 minutes to get weather data for selected Indian cities.
**Temperature Conversion:**
- Converts all temperature data based on the user’s selected unit (Celsius, Fahrenheit, or Kelvin).
**Daily Weather Summary:**
-	Calculates daily averages, maximum, and minimum temperatures, and identifies the dominant weather condition for each day.
**Alerting Thresholds:**
-	Allows users to set temperature thresholds and triggers alerts if conditions are breached (e.g., temperature exceeds 35°C for two consecutive updates).

## Future Improvements

**Weather Alerts:** Allow users to receive alerts for specific thresholds like temperature extremes.

**Historical Weather Data:** Store daily summaries in a database for trend analysis.

**Expanded Weather Parameters:** Incorporate additional parameters like humidity and wind speed.

**Forecast Retrieval:** Retrieve and summarize predicted weather conditions.

## Test Cases

**System Setup:** Verify the application connects to the OpenWeatherMap API with a valid API key.

**Data Retrieval:** Test scheduled API calls at configured intervals and validate data retrieval for specified locations.

**Temperature Conversion:** Confirm that temperature conversions between Kelvin and Celsius/Fahrenheit are accurate.

**Daily Weather Summary:** Validate that daily summaries are correctly calculated, including temperature averages and dominant weather conditions.

**Alerting Thresholds:** Test user-defined thresholds and validate alert functionality when thresholds are exceeded.
