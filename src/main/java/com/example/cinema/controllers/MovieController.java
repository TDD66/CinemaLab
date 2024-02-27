package com.example.cinema.controllers;

import com.example.cinema.models.Movie;
import com.example.cinema.models.Reply;
import com.example.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping
    public ResponseEntity<Reply> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        Reply reply = new Reply("Movie has been added!");
        return new ResponseEntity<>(reply, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable long id){
        Optional<Movie> movie = movieService.getMovieById(id);

        if(movie.isEmpty()){
            return new ResponseEntity<>(movie, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
}