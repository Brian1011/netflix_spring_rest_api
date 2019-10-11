package com.project.distributed.controller;

import com.project.distributed.models.Movie;
import com.project.distributed.services.MovieService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    // add new movie
    @PostMapping
    Movie createMovie(
            @Validated(Movie.Create.class)
            @RequestBody Movie movie
            )
    {
        return movieService.createMovie(movie);
    }

    //get all movies
    @GetMapping
    public List<Movie> findAll(){
        return movieService.findAll();
    }

    // get movie by id
    @GetMapping(value = "{id}")
    Movie findById(@PathVariable long id){
        return movieService.findById(id);
    }

    // update movie
    @PatchMapping
    public Movie updateMovie(
            @Validated(Movie.Update.class)
            @RequestBody Movie movie
    )
    {
        return movieService.update(movie);
    }

    // query available movies

}
