package com.booking.dao;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.booking.user.bean.User;

public interface UserDao {
	
	public boolean loginUser (User user, HttpSession session)  throws ClassNotFoundException, SQLException ;
	
}
