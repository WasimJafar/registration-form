package com.sapient.movieBooking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.movieBooking.entity.Feedback;
import com.sapient.movieBooking.interfaces.IFeedbackDAO;
import com.sapient.movieBooking.utilities.GetConnection;



public class FeedbackDao implements IFeedbackDAO{

	public boolean saveFeedbac(Feedback feedback) {
		String sql ="insert into Feedback values(?,?,?,?)"; 

		
		try {
			PreparedStatement ps = GetConnection.getMySQL().prepareStatement(sql);
			ps.setInt(1, feedback.getfId());
			ps.setString(2, feedback.getType());
			ps.setString(3, feedback.getComment());
			ps.setString(4, feedback.getStatus());
			
			return ps.executeUpdate()> 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return false;
	}

	public Feedback getFeedback(int fId) {
		
		try {
			String sql ="select fid,type,comment,status from Feedback where fid = ?"; 
			PreparedStatement ps = GetConnection.getMySQL().prepareStatement(sql); 
			ps.setInt(1, fId);
			
			ResultSet rs = ps.executeQuery(); 
			
			if(rs.next()) {
				Feedback f = new Feedback(); 
				f.setfId(rs.getInt(1));
				f.setType(rs.getString(2));
				f.setComment(rs.getString(3));
				f.setStatus(rs.getString(4));
				
				return f; 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	public List<Feedback> getAllFeedback() {

		String sql ="select fid,type,comment,status from Feedback"; 
		List<Feedback> feedbacks = null;
		try {
			PreparedStatement ps = GetConnection.getMySQL().prepareStatement(sql);
			feedbacks = new ArrayList<Feedback>(); 
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next()) {
				
				Feedback f = new Feedback(); 
				f.setfId(rs.getInt(1));
				f.setType(rs.getString(2));
				f.setComment(rs.getString(3));
				f.setStatus(rs.getString(4));
				
				feedbacks.add(f); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return feedbacks;
	}
	
}

















