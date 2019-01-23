package com.booking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.booking.user.bean.User;
@Repository
public class UserDaoImple implements UserDao {
	
	@Override
	public boolean loginUser(User user, HttpSession session) throws ClassNotFoundException, SQLException  {
		
		String dbUrl= "jdbc:mysql://localhost:3306/reservation_system";
		String dbUser= "root";
		String dbPassword = "root.root";
		
		int u_id=0;
		String u_email="";
		String u_password="";
		
		String userEmail = user.getUserEmail();
		String userPassword = user.getUserPassword();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		
		PreparedStatement statement = connection.prepareStatement("select u_id,u_email,u_password from user where u_email = ?");

		statement.setString(1,userEmail);
		
		ResultSet result = statement.executeQuery();
		
		while(result.next()) {
			
			u_id=result.getInt("u_id");
			u_email=result.getString("u_email");
			u_password=result.getString("u_password");
			
		}
		result.close();
		statement.close();
		connection.close();
		
		user.setUserId(u_id);
		user.setUserEmail(u_email);
 
		if(userPassword.equals(u_password)) {
			session.setAttribute("user", user);
			return true;
		}else {
			return false;
		}
	}
}
