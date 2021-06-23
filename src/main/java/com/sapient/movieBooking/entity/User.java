package com.sapient.movieBooking.entity;

import java.util.Date;
import java.util.Objects;

public class User {
	private int userId;
	private String userName;
	private String gender;
	private String email;
	private String password;
	private String phoneNumber;
	private Date dateOfBirth;
	private Date createdAt;
	private String userType;

	public User() {
		userType = "regular";
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user = (User) o;
		return userId == user.userId && Objects.equals(userName, user.userName) && Objects.equals(gender, user.gender)
				&& Objects.equals(email, user.email) && Objects.equals(password, user.password)
				&& Objects.equals(phoneNumber, user.phoneNumber) && isDateEqual(dateOfBirth, user.dateOfBirth);
	}

	private boolean isDateEqual(Date a, Date b) {
		return a.getDay() == b.getDay() && a.getMonth() == b.getMonth() && a.getYear() == b.getYear();
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, userName, gender, email, password, phoneNumber, dateOfBirth);
	}

	@Override
	public String toString() {
		return "User{" + "userId=" + userId + ", userName='" + userName + '\'' + ", gender='" + gender + '\''
				+ ", email='" + email + '\'' + ", password='" + password + '\'' + ", phoneNumber='" + phoneNumber + '\''
				+ ", dateOfBirth=" + dateOfBirth + ", createdAt=" + createdAt + '}';
	}
}
