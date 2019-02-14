package com.booking.movieInfo.bean;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Entity
@Table(name="booked_seat")
@Component
public class BookingDetail {
	
	@Id  @ GeneratedValue
	private int booking_id;
	
	@Column(name="u_id")
	private int userId;
	
	private String userEmail;
	
	@Column(name="c_id")
	private String cityId;
	
	@Column(name="t_id")
	private String theaterId;
	
	@Column(name="date")
	private String movieDate;
	
	@Column(name="date")
	private String movieId;
	
	@Column(name="time")
	private String movieTime;
	
	@Column(name="seat_no")
	private String totalSeat;
	
	public String getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(String totalSeat) {
		this.totalSeat = totalSeat;
	}
	private ArrayList<String> seats= new ArrayList<String>();
	
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
		this.seats.add(seat);
	}
}
