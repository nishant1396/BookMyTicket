package com.booking.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;

import javax.enterprise.inject.New;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.booking.dao.UserDao;
import com.booking.dao.UserDaoImple;
import com.booking.dao.BookTicket;
import com.booking.dao.BookTicketImpl;
import com.booking.dao.SelectInfo;
import com.booking.dao.TicketPage;
import com.booking.movieInfo.bean.BookingDetail;
import com.booking.movieInfo.bean.GetDetail;
import com.booking.user.bean.User;


@Controller
public class BookingController {
	
	/**
	 *  * * * * * * * * * Home Page  * * * * * * * * *
	 */
	
	@RequestMapping(value="/", method=RequestMethod.GET)
		public ModelAndView home() {
			
		ModelAndView modelAndView = new ModelAndView("home");
			return modelAndView;
		}
	
	/**
	 *  * * * * * * * * * Login  * * * * * * * * *
	 * 
	 */
	
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
		
		HttpSession session= req.getSession(); 
		
		boolean loginKey;
			
		loginKey = userDaoImple.loginUser(user, session);
			
		if(loginKey) {
			return "redirect:selectInfo";
		}else {
			return "redirect:login";
		}
	}
	
	/**
	 * 
	 *  * * * * * * * * * Select Info  * * * * * * * * *
	 * 
	 */
	@Autowired
	private SelectInfo selectInfo;
	
	@Autowired
	public GetDetail getDetails;
	
	@RequestMapping(value="/selectInfo", method=RequestMethod.GET)
	public String registerComplete(ModelMap model,HttpSession session,HttpServletResponse res) {
		
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			
		if(session.getAttribute("user")==null) {
			return "redirect:/";
				
		}else { 	
			selectInfo.getInfo(model);
			
			model.put("cities", getDetails.getCities());
			model.put("theaters", getDetails.getTheaters());
			model.put("movies", getDetails.getMovies());
			model.put("dates", getDetails.getDates());
			model.put("timings", getDetails.getTimings());
		
			return "cities";
		}
	
	}
	
	/*@RequestMapping(value="/selectDetail", method=RequestMethod.GET)
	public String registerCompleteGet(ModelMap model, HttpSession session,HttpServletResponse res) {
			
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			
		return "redirect:selectInfo";
	}*/
	
	/**
	 *  * * * * * * * * * Select Seat  * * * * * * * * *
	 *
	 */
	
	@RequestMapping(value="/selectSeat" ,method=RequestMethod.POST)
	public String  getSeat(@ModelAttribute ("bookingDetail") BookingDetail bookingDetail,HttpServletResponse res,HttpServletRequest request,HttpSession session) {
		
		session.setAttribute("bookingInfo", bookingDetail);
		
		return "seat"; 
	}
		
	/**
	 *  * * * * * * * * * Booking  * * * * * * * * *
	 * 
	 */
	
	@RequestMapping(value="/payment" ,method=RequestMethod.POST)
	public String  getHistory(ModelMap model, HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ClassNotFoundException, SQLException {
			
		Map <String, String[]> seats= request.getParameterMap();
		BookingDetail bDetail= (BookingDetail) session.getAttribute("bookingInfo");
		for(String key[]: seats.values()) {
				for(int i=0;i<key.length;i++) {
					bDetail.setSeat(key[i]);
				}
		}
		
		ArrayList<String> arrayListofSeat= bDetail.getSeat();
		
		System.out.println(String.join("-" , arrayListofSeat));
		bDetail.setTotalSeat(String.join("-" , arrayListofSeat));
		
		return "redirect:payment";
	}
	
	@RequestMapping(value="/payment", method=RequestMethod.GET)
	public String paymentPage() {
		return "payment";
	}
		
	
	/**
	 *  * * * * * * * * * Confirm  * * * * * * * * *
	 *
	 */
	
	@Autowired
	@Qualifier("bookTicketImpl")
	public BookTicket bookTicketImpl;
	
	@RequestMapping(value="/successful" , method=RequestMethod.POST)
	public String confirm (ModelMap model,HttpServletRequest request,HttpSession session) throws SQLException {
		
		BookingDetail bDetail	= (BookingDetail)session.getAttribute("bookingInfo");
		
		bookTicketImpl.bookingSeats(session,request);
		
		TicketPage ticketPage= new TicketPage();
		ticketPage.getDetailsofBookedTicket(request, model,session);
			
		return "success";
			
	}
	
	 
	/**
	 *  * * * * * * * * * Logout  * * * * * * * * *
	 */
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String getLogout(ModelMap model,HttpSession session)
	{
		session.removeAttribute("user");
		return "redirect:login";
	}
		
}
