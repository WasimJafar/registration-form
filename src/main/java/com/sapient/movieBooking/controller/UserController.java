package com.sapient.movieBooking.controller;

import org.springframework.web.bind.annotation.*;

import com.sapient.movieBooking.dao.UserDao;
import com.sapient.movieBooking.entity.User;
import com.sapient.movieBooking.interfaces.IUserDao;

@RestController
@RequestMapping("/api")
public class UserController {

	IUserDao dao = new UserDao();

	@GetMapping("/user/{userId}")
	public User getUserByUserId(@PathVariable int userId) {
		return dao.getUserById(userId);
	}

	@GetMapping("user/{email}/{password}")
	public User getUserByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
		return dao.getUserByEmailAndPassword(email, password);
	}

	@PostMapping("/user")
	public String saveUser(@RequestBody User user) {
		return dao.saveUser(user) != -1 ? "Inserted" : "Sorry not inserted";
	}

}
