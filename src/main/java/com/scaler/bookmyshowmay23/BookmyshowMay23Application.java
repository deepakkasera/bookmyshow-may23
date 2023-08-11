package com.scaler.bookmyshowmay23;

import com.scaler.bookmyshowmay23.models.Movie;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class BookmyshowMay23Application {

    public static void main(String[] args) {
        SpringApplication.run(BookmyshowMay23Application.class, args);

        Movie movie = new Movie();
        movie.setName("XYZ");
        movie.setActors(new ArrayList<>());
    }

}
