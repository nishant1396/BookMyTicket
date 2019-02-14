package com.booking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.booking.movieInfo.bean.BookingDetail;
import com.booking.user.bean.User;

@Repository
public class BookTicketImpl implements BookTicket{

	@Override
	public void bookingSeats(HttpSession session,HttpServletRequest request) throws SQLException {
		
		BookingDetail bookingDetail = (BookingDetail)session.getAttribute("bookingInfo");
		
		User user = (User)session.getAttribute("user");
		
		String dbUrl= "jdbc:mysql://localhost:3306/reservation_system";
		String dbUser= "root";
		String dbPassword = "root.root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
		
		Connection connection ;
		
		connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		
		String query1= "insert into booked_seat (u_id,c_id,t_id,date,m_id,time,seat_no) values (?,?,?,?,?,?,?)";
		String query2= "insert into booked_history (u_id,c_id,t_id,date,m_id,time) values (?,?,?,?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(query1);
		PreparedStatement statement2 = connection.prepareStatement(query2);
		
		System.out.println(bookingDetail.getCityId());
		
			statement.setInt(1,user.getUserId());
			statement.setString(2, bookingDetail.getCityId());
			statement.setString(3, bookingDetail.getTheaterId());
			statement.setString(4, bookingDetail.getMovieDate());
			statement.setString(5, bookingDetail.getMovieId());
			statement.setString(6, bookingDetail.getMovieTime());
			statement.setString(7, bookingDetail.getTotalSeat());
		
		statement.execute();
		statement.close();
		connection.close();
		
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
}
