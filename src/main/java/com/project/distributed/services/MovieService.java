package com.project.distributed.services;

import com.project.distributed.models.Movie;

import java.util.List;

public interface MovieService {
    Movie createMovie(Movie movie);

    List<Movie> findAll();

    Movie findById(long id);

    Movie update(Movie movie);

    void delete(long id);

    List<Movie> searchMovie(String movieName);
}
