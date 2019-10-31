package com.project.distributed.services;

import com.project.distributed.models.Movie;

import java.util.List;

public interface MovieService {
    Movie createMovie(Movie movie, String type);

    List<Movie> findAll();

    Movie findById(long id);

    Movie update(Movie movie, String type);

    String delete(long id, String type);

    List<Movie> searchMovie(String movieName);

    // clients suggested
    Movie suggestedMovie(Movie movie, long id);
    Movie update(Movie movie, Long clientId);
    String delete(long clientId, long movieId);
}
