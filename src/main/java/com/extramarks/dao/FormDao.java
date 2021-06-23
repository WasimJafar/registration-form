package com.extramarks.dao;

import java.io.*;
import java.sql.*;
import java.util.*;

import com.extramarks.entity.Form;
import com.extramarks.utilities.GetConnection;

public class FormDao {

	private PreparedStatement ps = null;
	private Properties queries = null;

	public FormDao() {

		queries = new Properties();

		try {
			queries.load(new FileInputStream("src/main/resources/sql.properties"));

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public int saveForm(Form form) {

		String SQL = "INSERT INTO User (userName, gender, emailAddr, password, birthDate, phoneNo, userType) VALUE (?, ?, ?, ?, ?, ?,?)";

		try {

			ps = GetConnection.getMySQL().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

			// add values to placeholder
			ps.setString(1, form.getName());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();
			int userId = -1;

			if (rs != null && rs.next()) {
				userId = rs.getInt(1);
			}

			return userId;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

}
