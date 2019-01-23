package com.booking.movieInfo.bean;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class BookingDetail {
	
	private int userId;
	private String userEmail;
	private String cityId;
	private String theaterId;
	private String movieDate;
	private String movieId;
	private String movieTime;
	private ArrayList<String> seats = new ArrayList<String>();
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	public String getTheaterId() {
		return theaterId;
	}
	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}
	public String getMovieDate() {
		return movieDate;
	}
	public void setMovieDate(String date) {
		this.movieDate = date;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieTime() {
		return movieTime;
	}
	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}
	public ArrayList<String> getSeat() {
		return seats;
	}
	public void setSeat(String seat) {
		seats.add(seat);
	}
}
