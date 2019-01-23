package com.booking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.booking.admin.bean.Admin;
import com.booking.dao.AdminDao;

@Controller
public class AdminController {

	/* ------------------------- Home Page -------------------------------- */

	@RequestMapping(value="/admin" ,method=RequestMethod.GET)
	public String adminLogin() {
		
		return "adminLogin";
	}
	
	/* ------------------------- Registration ------------------------ */
	
	@RequestMapping(value="/adminRegistration" ,method=RequestMethod.GET)
	public String adminRegistration() {
		
		return "adminRegistration";
	
	}
	
	/* ------------------------- Account detail ----------------------*/
	
	@Autowired
	@Qualifier("adminDaoImpl")
	private AdminDao adminDao;
	
	@RequestMapping(value="/account", method=RequestMethod.POST)
	public String adminAccount(@ModelAttribute("admin")Admin admin,ModelMap model) {
		
		adminDao.saveAdmin(admin);
		
		System.out.println("At controller--  "+admin);
		
		return "adminAccount";
	}
	
	
	/* ----------------------- Change details ------------------------ */
	
	
	
}
