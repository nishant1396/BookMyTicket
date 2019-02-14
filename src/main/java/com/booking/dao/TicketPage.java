package com.booking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.enterprise.inject.Model;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;

import com.booking.movieInfo.bean.BookingDetail;
import com.mysql.cj.PreparedQuery;
import com.mysql.cj.Session;

public class TicketPage {
	
	public void getDetailsofBookedTicket(HttpServletRequest request,ModelMap model,HttpSession session) throws SQLException {
	
		BookingDetail bookingDetail= (BookingDetail)session.getAttribute("bookingInfo");
		
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
		
		PreparedStatement movie_name_query= connection.prepareStatement("select m_name from movie where m_id= ?");
		PreparedStatement theater_name_query= connection.prepareStatement("select t_name from theater where t_id= ?");
		PreparedStatement date_query= connection.prepareStatement("select date from movie_date where date= ?");
		PreparedStatement time_query= connection.prepareStatement("select t_name from theater where t_id= ?");

		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
	}
	
}
