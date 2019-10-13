package com.project.distributed.services;

import com.project.distributed.NotFoundException;
import com.project.distributed.models.Category;
import com.project.distributed.models.Client;
import com.project.distributed.models.Movie;
import com.project.distributed.models.SuggestedMovie;
import com.project.distributed.repositories.CategoryRepository;
import com.project.distributed.repositories.ClientRepository;
import com.project.distributed.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final ClientRepository clientRepository;
    private final CategoryRepository categoryRepository;

    public MovieServiceImpl(MovieRepository movieRepository, ClientRepository clientRepository, CategoryRepository categoryRepository) {
        this.movieRepository = movieRepository;
        this.clientRepository = clientRepository;
        this.categoryRepository = categoryRepository;
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

    @Override
    public List<Movie> searchMovie(String movieName) {
        return movieRepository.findByNameIgnoreCaseContaining(movieName);
    }

    @Override
    public Movie suggestedMovie(Movie movie, long id) {
        // create the movie
        Category cat = new Category("Animation");
        categoryRepository.save(cat);

        //Movie movie = new Movie("x-men",cat,"suggested");
        Movie new_movie = movieRepository.save(movie);

        // get client by id
        Client found = clientRepository.findById(id).orElseThrow(()
                ->new NotFoundException("No client with the id: "+id));

        // suggest a new movie
        SuggestedMovie suggestedMovie = new SuggestedMovie(found, new_movie);

        return new_movie;
    }

}
