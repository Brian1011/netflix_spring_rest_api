package com.project.distributed.services;

import com.project.distributed.NotFoundException;
import com.project.distributed.UnauthorizedException;
import com.project.distributed.models.Category;
import com.project.distributed.models.Client;
import com.project.distributed.models.Movie;
import com.project.distributed.models.SuggestedMovie;
import com.project.distributed.repositories.CategoryRepository;
import com.project.distributed.repositories.ClientRepository;
import com.project.distributed.repositories.MovieRepository;
import com.project.distributed.repositories.SuggestedMovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final ClientRepository clientRepository;
    private final CategoryRepository categoryRepository;
    private final SuggestedMovieRepository suggestedMovieRepository;

    public MovieServiceImpl(MovieRepository movieRepository, ClientRepository clientRepository, CategoryRepository categoryRepository, SuggestedMovieRepository suggestedMovieRepository) {
        this.movieRepository = movieRepository;
        this.clientRepository = clientRepository;
        this.categoryRepository = categoryRepository;
        this.suggestedMovieRepository = suggestedMovieRepository;
    }


    @Override
    public Movie createMovie(Movie movie, String type) {
        if (type.equals("admin")){
            return movieRepository.save(movie);
        }else {
            throw new UnauthorizedException("You are not authorized to create a movie");
        }

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
    public Movie update(Movie movie, String type) {
        if(type.equals("admin")){
            //look for the object
            Movie found = findById(movie.getId());

            //update movie
            found.setName(movie.getName());
            found.setCategory(movie.getCategory());
            found.setType(movie.getType());
            return movieRepository.save(found);
        }else{
            throw new UnauthorizedException("You are not authorized to update this movie");
        }
    }

    @Override
    public String delete(long id, String type) {
        if (type.equals("admin")){
            String message = "Movie";
            //look for the object first
            Movie found = findById(id);

            //erase movie
            movieRepository.deleteById(id);

            return message;
        }else {
            throw new UnauthorizedException("You are not authorized to delete this movie");
        }

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
        suggestedMovieRepository.save(suggestedMovie);

        return new_movie;
    }

}
