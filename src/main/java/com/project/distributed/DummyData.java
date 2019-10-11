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
        // Category
        //Category new_cat = new Category("Cartoon");
        //categoryRepository.save(new_cat);

       //Movie movie = new Movie("Dexter",new_cat,"original");
       //movieRepository.save(movie);
        // System.out.println(movie);


    }
}
