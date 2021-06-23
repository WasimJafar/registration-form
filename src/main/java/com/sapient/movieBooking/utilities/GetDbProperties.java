package com.sapient.movieBooking.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDbProperties {
	public static Properties property() {
		Properties queries = new Properties();		
		try {
			queries.load(new FileInputStream("src/main/resources/sql.properties"));
			
			// Create Booking table if does not exit
			//GetConnection.getMySQL().prepareStatement(queries.getProperty("CREATE_BOOKING_TABLE")).executeUpdate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queries;
	}
}