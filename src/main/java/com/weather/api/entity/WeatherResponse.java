package com.weather.api.entity;

import java.util.*;

public class WeatherResponse {

	private Main main;
	private List<Weather> weather;
	private String name;
	 private Sys sys;
	
	
	
	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}


	

	public WeatherResponse(Main main, List<Weather> weather, String name, Sys sys) {
		super();
		this.main = main;
		this.weather = weather;
		this.name = name;
		this.sys = sys;
	}

	public WeatherResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "WeatherResponse [main=" + main + ", weather=" + weather + ", name=" + name + ", sys=" + sys + "]";
	}

	
	


}
