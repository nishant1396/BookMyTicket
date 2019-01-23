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

import com.booking.movieInfo.bean.BookingDetail;
import com.booking.user.bean.User;

public class BookTicketImpl implements BookTicket{

	@Override
	public void bookingSeats(HttpSession session,HttpServletRequest request) throws SQLException {
		
		BookingDetail bookingDetail = new BookingDetail();
		
		User user = (User)session.getAttribute("user");
		
		Cookie[] cookies = request.getCookies();
		
		HashMap<String, String> cookieData= new HashMap<String, String>();
		
		for(Cookie cookie: cookies) {
			cookieData.put(cookie.getName(), cookie.getValue());
		}
		
		List<String> seats= new ArrayList<String>(Arrays.asList(cookieData.get("movieSeat").split("-")));
		
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
		
		connection.setAutoCommit(false);
		
		String query1= "insert into booked_seat (u_id,c_id,t_id,date,m_id,time,seat_no) values (?,?,?,?,?,?,?)";
		String query2= "insert into booked_history (u_id,c_id,t_id,date,m_id,time) values (?,?,?,?,?,?)";
		
		PreparedStatement statement = connection.prepareStatement(query1);
		PreparedStatement statement2 = connection.prepareStatement(query2);
		
		for(int i=0;i<seats.size();i++) {
			
			statement.setInt(1,user.getUserId());
			statement.setString(2, cookieData.get("cityId"));
			statement.setString(3, cookieData.get("theaterId"));
			statement.setString(4, cookieData.get("movieDate"));
			statement.setString(5, cookieData.get("movieId"));
			statement.setString(6, cookieData.get("movieTime"));
			statement.setString(7, seats.get(i));
			
			statement.addBatch();
		}
		statement.executeBatch();
		
		statement2.setInt(1,user.getUserId());
		statement2.setString(2, cookieData.get("cityId"));
		statement2.setString(3, cookieData.get("theaterId"));
		statement2.setString(4, cookieData.get("movieDate"));
		statement2.setString(5, cookieData.get("movieId"));
		statement2.setString(6, cookieData.get("movieTime"));
		
		statement2.execute();
		
		connection.commit();
		statement.close();
		statement2.close();
		connection.close();
		
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
}
