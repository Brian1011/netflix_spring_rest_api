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
            @RequestParam String type, // type = admin
            @Validated(Movie.Create.class)
            @RequestBody Movie movie
            )
    {
        return movieService.createMovie(movie, type);
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
            @RequestParam String type, // type = admin
            @Validated(Movie.Update.class)
            @RequestBody Movie movie
    )
    {
        return movieService.update(movie, type);
    }

    // delete movie
    @DeleteMapping(value = "{id}")
    public String deleteMovie(
            @RequestParam String type, // type = admin
            @PathVariable long id
    ){
        return movieService.delete(id, type);
    }

    // search movie
    @GetMapping(value = "/search")
    public List<Movie> searchMovie(@RequestParam String movieName){
        return movieService.searchMovie(movieName);
    }

    // client suggest a movie
    // add new movie
    @PostMapping(value = "/suggest/{id}")
    Movie clientSuggestMovie(
            @Validated(Movie.Create.class)
            @PathVariable long id,
            @RequestBody Movie movie
    )
    {
        return movieService.suggestedMovie(movie, id);
    }

    // client edit movie
//    Movie clientEditMovie(
//            @Validated(Movie.Update.class)
//            @PATH
//    )

}
