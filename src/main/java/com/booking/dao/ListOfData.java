package com.booking.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ListOfData {

	public ArrayList<String> listOfCities()  throws ClassNotFoundException , SQLException ;
	
	public ArrayList<String> listOfTheaters()  throws ClassNotFoundException , SQLException ;
	
}
