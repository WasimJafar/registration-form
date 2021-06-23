package com.sapient.movieBooking.interfaces;

import java.util.List;

import com.sapient.movieBooking.entity.Feedback;


public interface IFeedbackDAO {
	public boolean saveFeedbac(Feedback feedback);
	public Feedback getFeedback(int fId); 
	public List<Feedback> getAllFeedback(); 
}
