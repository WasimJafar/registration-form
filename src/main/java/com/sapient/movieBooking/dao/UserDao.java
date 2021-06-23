package com.sapient.movieBooking.dao;

import com.sapient.movieBooking.entity.User;
import com.sapient.movieBooking.interfaces.IUserDao;
import com.sapient.movieBooking.utilities.*;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class UserDao implements IUserDao {

	private PreparedStatement ps = null;
	private Properties queries = null;
	
	public UserDao() {
		
		queries = new Properties();
		
		try {
			queries.load(new FileInputStream("src/main/resources/sql.properties"));
			
		} catch (IOException e) {

			e.printStackTrace();
		}
        
	}
	
	
	@Override
	public int saveUser(User user) {

		String SQL = GetDbProperties.property().getProperty("SAVE_USER");
		try {

			ps = GetConnection.getMySQL().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, user.getUserName());
			ps.setString(2, user.getGender());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());

			Calendar cal = Calendar.getInstance();
			cal.setTime(user.getDateOfBirth());

			java.sql.Date dob = new java.sql.Date(cal.getTime().getTime());

			ps.setDate(5, dob);
			ps.setString(6, user.getPhoneNumber());
			ps.setString(7, user.getUserType());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			int userId = -1;

            if(rs != null && rs.next()){
                userId = rs.getInt(1);
            } 

			return userId;

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return -1;
	}

	@Override
	public User getUserById(int usrId) {
		
		String SQL = GetDbProperties.property().getProperty("GET_USER_BY_USER_ID");

		try {
			
			ps = GetConnection.getMySQL().prepareStatement(SQL);
			ps.setInt(1, usrId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
			
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setGender(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setCreatedAt(rs.getDate(6));
				user.setDateOfBirth(rs.getDate(7));
				user.setPhoneNumber(rs.getString(8));
				return user;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		
		String SQL = GetDbProperties.property().getProperty("GET_USER_BY_EMAIL_AND_PASSWORD");

		try {

			ps = GetConnection.getMySQL().prepareStatement(SQL);
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				User user = new User();

				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setGender(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setCreatedAt(rs.getDate(6));
				user.setDateOfBirth(rs.getDate(7));
				user.setPhoneNumber(rs.getString(8));

				return user;

			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
