package com.booking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListOfDataImpl implements ListOfData{

	@Override
	public ArrayList<String> listOfCities() throws ClassNotFoundException, SQLException {
		
		ArrayList<String> listOfCity = new ArrayList<String>();
		
		String dbUrl= "jdbc:mysql://localhost:3306/reservation_system";
		String dbUser= "root";
		String dbPassword = "root.root";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		
		PreparedStatement statement = connection.prepareStatement("select * from city");
		
		ResultSet result = statement.executeQuery();
		
		while(result.next()) {
			listOfCity.add(result.getString("c_name"));
		}
		
		result.close();
		statement.close();
		connection.close();
		
		return listOfCity;
	}

	@Override
	public ArrayList<String> listOfTheaters() throws ClassNotFoundException, SQLException {
		
		ArrayList<String> listOfTheater = new ArrayList<String>();
		
		String dbUrl= "jdbc:mysql://localhost:3306/reservation_system";
		String dbUser= "root";
		String dbPassword = "root.root";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		
		PreparedStatement statement = connection.prepareStatement("select * from theater");
		
		ResultSet result = statement.executeQuery();
		
		while(result.next()) {
			listOfTheater.add(result.getString("t_name"));
		}
		
		result.close();
		statement.close();
		connection.close();
		
		return listOfTheater;
	}
	
	

}
