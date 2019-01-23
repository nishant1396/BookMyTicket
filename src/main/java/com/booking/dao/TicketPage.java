package com.booking.dao;

import java.awt.image.RescaleOp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.enterprise.inject.Model;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import com.mysql.cj.PreparedQuery;

public class TicketPage {
	
	public void getDetailsofBookedTicket(HttpServletRequest request,ModelMap model) throws SQLException {
		
		Cookie[] cookies = request.getCookies();
		HashMap<String, String> cookieData= new HashMap<String, String>();
		
		for(Cookie cookie: cookies) {
			
			cookieData.put(cookie.getName(), cookie.getValue());
		}
		
		String dbUrl= "jdbc:mysql://localhost:3306/reservation_system";
		String dbUser= "root";
		String dbPassword = "root.root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		Connection connection ;
		
		connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		
		PreparedStatement stMovieName= connection.prepareStatement("select m_name from movie where m_id= ?");
		PreparedStatement stTheater = connection.prepareStatement("select t_name from theater where t_id= ?");
		
		stMovieName.setString(1, cookieData.get("movieId"));
		stTheater.setString(1, cookieData.get("theaterId"));
		
		ResultSet result1= stMovieName.executeQuery();
		ResultSet result2= stTheater.executeQuery();
		
		while(result1.next()) {
			model.put("movieName", result1.getString("m_name"));
		}
		
		while(result2.next()) {
			model.put("movieTheater", result2.getString("t_name"));
		}
		
		result1.close();
		result2.close();
		stMovieName.close();
		stTheater.close();
		connection.close();
		
		model.put("movieDate", cookieData.get("movieDate"));
		model.put("seats", cookieData.get("movieSeat"));
		model.put("movieTime", cookieData.get("movieTime"));
		}

}
