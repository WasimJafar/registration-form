package com.sapient.movieBooking.interfaces;

import com.sapient.movieBooking.entity.User;

public interface IUserDao {

	int saveUser(User user);

	User getUserById(int usrId);

	User getUserByEmailAndPassword(String email, String password);
}
