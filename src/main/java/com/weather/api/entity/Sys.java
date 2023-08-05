package com.weather.api.entity;

public class Sys {
	 
	    private String country;
	    private String sunrise;
	    private String sunset;
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getSunrise() {
			return sunrise;
		}
		public void setSunrise(String sunrise) {
			this.sunrise = sunrise;
		}
		public String getSunset() {
			return sunset;
		}
		public void setSunset(String sunset) {
			this.sunset = sunset;
		}
		public Sys(String country, String sunrise, String sunset) {
			super();
			this.country = country;
			this.sunrise = sunrise;
			this.sunset = sunset;
		}
		public Sys() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Sys [country=" + country + ", sunrise=" + sunrise + ", sunset=" + sunset + "]";
		}

	    

}
