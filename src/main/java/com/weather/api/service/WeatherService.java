package com.weather.api.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.api.entity.WeatherResponse;

@Service
public class WeatherService {


	private static final String API_KEY = "5f40613a4380cafaca04f496f83cab78";
	private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
	
	private final RestTemplate restTemplate;
	
	
	public WeatherService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public WeatherResponse getWeatherData(String city) {
		String url = API_URL + "?q=" + city + "&appid=" + API_KEY;
		
		ResponseEntity<WeatherResponse> responseEntity = restTemplate.getForEntity(url, WeatherResponse.class);
		
		if(responseEntity.getStatusCode() == HttpStatus.OK) {
			return responseEntity.getBody();
		}
		else {
			throw new RuntimeException("Failed to fetch weather data");
		}
	}
}
