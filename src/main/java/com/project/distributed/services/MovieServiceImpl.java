package com.project.distributed.services;

import com.project.distributed.NotFoundException;
import com.project.distributed.models.Movie;
import com.project.distributed.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(long id) {
        return movieRepository.findById(id).orElseThrow(()
            ->new NotFoundException("No movie with the id "+id)
        );
    }

    @Override
    public Movie update(Movie movie) {
        //look for the object
        Movie found = findById(movie.getId());

        //update movie
        found.setName(movie.getName());
        found.setCategory(movie.getCategory());
        found.setType(movie.getType());
        return movieRepository.save(found);
    }

    @Override
    public void delete(long id) {
        //look for the object first
        Movie found = findById(id);
        //erase movie
        movieRepository.deleteById(id);
    }
}
