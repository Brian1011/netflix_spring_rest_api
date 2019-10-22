package com.project.distributed.repositories;

import com.project.distributed.models.Category;
import com.project.distributed.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    //Category findByIdAndMovies(long id, String type);

    // select category then select a movie type
    @Query(value = "SELECT * from categories inner join movies ON categories.id = movies.category_id where categories.id = :id and movies.type=:type",
            nativeQuery = true
    )
    Category findCatBySuggested(
            @Param("id") long id,
            @Param("type") String type
    );

    //Category findByIdAndMovieSet(long id, String type);
    Category findByIdAndMovies(long id, Movie movie);
}
