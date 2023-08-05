package com.weather.api.controller;

import java.text.DecimalFormat;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.api.entity.WeatherResponse;
import com.weather.api.service.WeatherService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class HomeController {
	private static final DecimalFormat decfor = new DecimalFormat("0.00");  
	@Autowired
	WeatherService weatherService;


	@GetMapping("/weather")
	public ResponseEntity<?> getWeather(@RequestParam("city") String city){
		
		try {
//			getting weather details
			WeatherResponse weatherData = weatherService.getWeatherData(city);
			
//			creating new object
			HashMap<String, String> weather = new HashMap<>();
//			adding humidity
			weather.put("humidity", weatherData.getMain().getHumidity());
			
//			converting temperature in celsius
			double temperatureKelvin = Double.valueOf(weatherData.getMain().getTemp());
			
			double temperatureCelsius = temperatureKelvin - 273.15;
		
//			adding into object
			weather.put("temperature", String.valueOf(decfor.format(temperatureCelsius)));
			
//			adding weather in object
			weather.put("weatherMain",weatherData.getWeather().get(0).getMain());
			weather.put("weatherDescription",weatherData.getWeather().get(0).getDescription());
			
//			adding country and city
			weather.put("city", weatherData.getName());
			weather.put("country", weatherData.getSys().getCountry());
			
			
			
			return ResponseEntity.ok().body(weather);
			
		} catch (Exception e) {
			e.printStackTrace();
			HashMap<String , String > response = new  HashMap<>();
			response.put("message", "Please enter valid city !");
			response.put("status", "404");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		
	}
}
