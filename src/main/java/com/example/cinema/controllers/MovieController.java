package com.example.cinema.controllers;

import com.example.cinema.models.Movie;
import com.example.cinema.models.MovieDTO;
import com.example.cinema.models.Reply;
import com.example.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Reply> deleteMovie(@RequestBody Movie movie){
        movieService.deleteMovie(movie);
        Reply reply = new Reply("Movie has been deleted!");
        return new ResponseEntity<>(reply, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Reply> updateMovie(@RequestBody MovieDTO movieDTO, @PathVariable long id){
        Movie updatedMovie = movieService.updateMovie(movieDTO, id);
        if(updatedMovie == null){
            Reply reply = new Reply("Movie not found!");
            return new ResponseEntity<>(reply, HttpStatus.NOT_FOUND);
        }
        Reply reply = new Reply("Movie has been updated!");
        return new ResponseEntity<>(reply, HttpStatus.OK);
    }
}
