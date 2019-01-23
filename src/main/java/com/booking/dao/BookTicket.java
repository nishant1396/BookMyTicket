package com.booking.dao;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.booking.movieInfo.bean.BookingDetail;
import com.booking.user.bean.User;

public interface BookTicket {

	public void bookingSeats(HttpSession session, HttpServletRequest request)  throws SQLException ;
	
}
