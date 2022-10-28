package com.polarbear.franc.main.DTO;

import com.polarbear.franc.main.DAO.DAO;
import com.polarbear.franc.reservation.Reservation;
import com.polarbear.franc.restaurant.Restaurant;

public abstract class menuChange {
	Reservation rsv = null;
	String result = null;
	DAO dao = new DAO();
	Restaurant res = null;
	
	public abstract void click() throws Exception;
}
