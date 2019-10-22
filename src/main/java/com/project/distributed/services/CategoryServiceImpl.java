package com.project.distributed.services;

import com.project.distributed.NotFoundException;
import com.project.distributed.models.Category;
import com.project.distributed.models.Movie;
import com.project.distributed.repositories.CategoryRepository;
import com.project.distributed.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final MovieRepository movieRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, MovieRepository movieRepository) {
        this.categoryRepository = categoryRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category update(Category category) {
        // look for the object first
        Category found = findById(category.getId());

        // update the object
        found.setCategoryName(category.getCategoryName());
        return categoryRepository.save(found);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()
        ->new NotFoundException("No category with the id" + id));
    }

    @Override
    public Category findAvailableMovie(long id, String type) {
        //get the category based on the id
        Category foundCategory = categoryRepository.findById(id).orElseThrow(()
                ->new NotFoundException("No category with the id" + id));

        // create a new category
        Category new_cat = new Category(foundCategory.getCategoryName());
        //System.out.println(foundCategory.getMovieSet());

        // get the movies from the category
        Set<Movie> myMovie = foundCategory.getMovieSet();

        // create a new set
        Set<Movie> foundMovies = new HashSet<>();

        // filter and add movie to new set if its found
        for(Movie m : myMovie){
            if(m.getType().equals(type)){
                foundMovies.add(m);
                new_cat.addMovie(m);
            }
        }

        // set the movie set of the category
        foundCategory.setMovieSet(foundMovies);
        return foundCategory;
    }

    @Override
    public Category addMovieToCategory(long id, long movieId) {
        Movie foundMovie = movieRepository.findById(movieId).orElseThrow(()
                ->new NotFoundException("No movie with the id "+id)
        );

        Category foundCategory = categoryRepository.findById(id).orElseThrow(()
                ->new NotFoundException("No category with the id" + id));

        foundCategory.addMovie(foundMovie);
        return categoryRepository.save(foundCategory);
    }
}
