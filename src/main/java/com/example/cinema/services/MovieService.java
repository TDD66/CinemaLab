package com.example.cinema.services;

import com.example.cinema.models.Movie;
import com.example.cinema.models.MovieDTO;
import com.example.cinema.models.Reply;
import com.example.cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public MovieService(){
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void deleteMovie(Movie movie){
        movieRepository.delete(movie);
    }

    public Movie updateMovie(MovieDTO movie, long id){
        Movie movieToUpdate = movieRepository.findById(id).get();
        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setDuration(movie.getDuration());
        movieToUpdate.setRating(movie.getRating());
        movieRepository.save(movieToUpdate);

        return movieToUpdate;
    }

    public Optional<Movie> getMovieById(long id){
        return movieRepository.findById(id);
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public List<Movie> getFilteredByTimeMovies(int maxDuration){
        return movieRepository.findByDurationLessThanEqual(maxDuration);
    }
}
