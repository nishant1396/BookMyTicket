package com.booking.movieInfo.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class GetDetail {

	List<String> cities= new ArrayList<String>();
	List<String> theaters= new ArrayList<String>();
	List<String> movies= new ArrayList<String>();
	List<String> dates= new ArrayList<String>();
	List<String> timings= new ArrayList<String>();
	
	public List<String> getCities() {
		return cities;
	}
	public void setCities(String  city) {
		this.cities.add(city);
	}
	public List<String> getTheaters() {
		return theaters;
	}
	public void setTheaters(String theater) {
		this.theaters.add(theater);
	}
	public List<String> getMovies() {
		return movies;
	}
	public void setMovies(String movie) {
		this.movies.add(movie);
	}
	public List<String> getDates() {
		return dates;
	}
	public void setDates(String date) {
		this.dates.add(date) ;
	}
	public List<String> getTimings() {
		return timings;
	}
	public void setTimings(String time) {
		this.timings.add(time);
	}
	
}
