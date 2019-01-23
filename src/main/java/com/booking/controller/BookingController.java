package com.booking.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.enterprise.inject.New;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.booking.dao.UserDao;
import com.booking.dao.UserDaoImple;
import com.booking.dao.BookTicket;
import com.booking.dao.BookTicketImpl;
import com.booking.dao.TicketPage;
import com.booking.movieInfo.bean.BookingDetail;
import com.booking.user.bean.User;

@Controller
public class BookingController {
	
	/* ----------------------- Home Page Controller ---------------------------*/
	
	@RequestMapping(value="/", method=RequestMethod.GET)
		public ModelAndView home() {
			
		ModelAndView modelAndView = new ModelAndView("home");
			
			return modelAndView;
		}
		
		
	/*----------------------- Login Controller ---------------------------------*/
		
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public String studentLoggedIn(ModelMap model, HttpSession session) {
		if(session.getAttribute("user")==null) {
			return "redirect:/";
		}else {
			return "redirect:account";
		}
	}
	
	@Autowired
	public UserDao userDaoImple;
		
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String studentLogin(@ModelAttribute("user")User user,ModelMap model,HttpServletRequest req) throws ClassNotFoundException, SQLException {
		
		
//		UserDao userDaoImple = new UserDaoImple();
		HttpSession session= req.getSession(); 
		
		boolean loginKey;
			
		loginKey = userDaoImple.loginUser(user, session);
			
		if(loginKey) {
			return "redirect:selectInfo";
		}else {
			System.out.println("false");
			return "redirect:login";
		}
	}
	
	/*--------------------------Select Info -------------------------------*/
		
	@RequestMapping(value="/selectInfo", method=RequestMethod.GET)
	public String registerComplete(ModelMap model, HttpSession session,HttpServletResponse res) {
			
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			
		if(session.getAttribute("user")==null) {
			return "redirect:/";
				
		}else {

			return "cities";
		}
	}
		
	/*-----------------------------Select Seat---------------------------*/
	@RequestMapping(value="/selectSeat" ,method=RequestMethod.POST)
	public String  getSeat(@ModelAttribute ("bookingDetail") BookingDetail bookingDetail,HttpServletResponse res,HttpServletRequest request,HttpSession session) {
		
		session.setAttribute("bookingInfo", bookingDetail);
		
		Cookie cityId= new Cookie("cityId", bookingDetail.getCityId());
		res.addCookie(cityId);
		cityId.setMaxAge(-1);
		Cookie theaterId= new Cookie("theaterId", bookingDetail.getTheaterId());
		res.addCookie(theaterId);
		theaterId.setMaxAge(-1);
		Cookie movieDate= new Cookie("movieDate", bookingDetail.getMovieDate());
		res.addCookie(movieDate);
		movieDate.setMaxAge(-1);
		Cookie movieId= new Cookie("movieId", bookingDetail.getMovieId());
		res.addCookie(movieId);
		movieId.setMaxAge(-1);
		Cookie movieTime= new Cookie("movieTime", bookingDetail.getMovieTime());
		res.addCookie(movieTime);
		movieTime.setMaxAge(-1);
		System.out.println(session.getAttributeNames().nextElement());
		
		User obj = (User)session.getAttribute("user");
		
		System.out.println(obj.getUserEmail());
		return "seat"; 
	}
	
	/*----------------------------Booking -------------------------------*/
		
	@RequestMapping(value="/payment" ,method=RequestMethod.POST)
	public String  getHistory(ModelMap model, HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ClassNotFoundException, SQLException {
			
		Map <String, String[]> seats= request.getParameterMap();
			
		BookingDetail bookingDetail = new BookingDetail();
			
		for(String key[]: seats.values()) {
				for(int i=0;i<key.length;i++) {
					bookingDetail.setSeat(key[i]);
				}
		}
			
		ArrayList<String> arrayListofSeat= bookingDetail.getSeat();
			
		String totalSeat= String.join("-" , arrayListofSeat);
			
		Cookie movieSeat= new Cookie("movieSeat", totalSeat);
		response.addCookie(movieSeat);
		movieSeat.setMaxAge(-1);
		
		return "payment";
	}
		
	/*---------------------------- Confirm -------------------------------*/
		
	@RequestMapping(value="/successful" , method=RequestMethod.POST)
	public String confirm (ModelMap model,HttpServletRequest request,HttpSession session) throws SQLException {
			
		BookTicket bookTicketImpl = new BookTicketImpl();
		bookTicketImpl.bookingSeats(session,request);
		
		TicketPage ticketPage= new TicketPage();
		ticketPage.getDetailsofBookedTicket(request, model);
			
		return "success";
			
	}
		
	/*-----------------------------Logout --------------------------------*/
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String getLogout(ModelMap model,HttpSession session)
	{
		session.removeAttribute("user");
		return "redirect:login";
	}
		
}
