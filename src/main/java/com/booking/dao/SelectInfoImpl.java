package com.booking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.booking.movieInfo.bean.GetDetail;
import com.mysql.cj.protocol.Resultset;

@Repository
public class SelectInfoImpl  implements SelectInfo{
	
	@Autowired
	public GetDetail getDetail;


	@Override
	public void getInfo(ModelMap model) {
		
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
		
		String qGetCities= "select c_name from city";
		String qGetTheaters= "select t_name from theater";
		String qGetMovies= "select m_name from movie";
		String qGetDates= "select date from movie_date";
		String qGetTimings= "select time from show_time";
		
		PreparedStatement statement1 = connection.prepareStatement(qGetCities);
		PreparedStatement statement2 = connection.prepareStatement(qGetTheaters);
		PreparedStatement statement3 = connection.prepareStatement(qGetMovies);
		PreparedStatement statement4 = connection.prepareStatement(qGetDates);
		PreparedStatement statement5 = connection.prepareStatement(qGetTimings);

		ResultSet resultSet1= statement1.executeQuery();
		ResultSet resultSet2= statement2.executeQuery();
		ResultSet resultSet3= statement3.executeQuery();
		ResultSet resultSet4= statement4.executeQuery();
		ResultSet resultSet5= statement5.executeQuery();
		
		while(resultSet1.next()) {
			getDetail.setCities(resultSet1.getString("c_name"));
		}
		
		while(resultSet2.next()) {
			getDetail.setTheaters(resultSet2.getString("t_name"));
		}
		
		while(resultSet3.next()) {
			getDetail.setMovies(resultSet3.getString("m_name"));
		}
		
		while(resultSet4.next()) {
			getDetail.setDates(resultSet4.getString("date"));
		}
		
		while(resultSet5.next()) {
			getDetail.setTimings(resultSet5.getString("time"));
		}
		
		
		statement1.close();
		statement2.close();
		statement3.close();
		statement4.close();
		statement5.close();
		
		connection.close();
		
		
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}

	
	
}
