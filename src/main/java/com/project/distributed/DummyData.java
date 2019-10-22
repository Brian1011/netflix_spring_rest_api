package com.project.distributed;

import com.project.distributed.models.Category;
import com.project.distributed.models.Movie;
import com.project.distributed.repositories.CategoryRepository;
import com.project.distributed.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DummyData implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final CategoryRepository categoryRepository;

    public DummyData(MovieRepository movieRepository, CategoryRepository categoryRepository) {
        this.movieRepository = movieRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        Movie movie = new Movie("Amazing Spiderman", "original");
//        movieRepository.save(movie);
//
//        // Category
//        Category new_cat = categoryRepository.save(new Category("Comedy"));
//        new_cat.addMovie(movie);
//        categoryRepository.save(new_cat);
//
//        Category cat2 = categoryRepository.save(new Category("Action"));
//        cat2.addMovie(movie);
//        categoryRepository.save(cat2);
    }
}
