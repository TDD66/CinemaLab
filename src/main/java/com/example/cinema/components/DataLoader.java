package com.example.cinema.components;

import com.example.cinema.models.Movie;
import com.example.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MovieService movieService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Movie sample = new Movie("Sample 1", "5", 300);
        movieService.addMovie(sample);
        sample = new Movie("Sample 2", "5", 30);
        movieService.addMovie(sample);
        sample = new Movie("Sample 3", "5", 200);
        movieService.addMovie(sample);
        sample = new Movie("Sample 4", "5", 100);
        movieService.addMovie(sample);
        sample = new Movie("Sample 5", "5", 50);
        movieService.addMovie(sample);
    }
}
