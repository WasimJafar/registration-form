package com.sapient.movieBooking.utilities;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {

        System.out.println(GetConnection.getMySQL());

    }


}
