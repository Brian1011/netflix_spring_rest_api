package com.project.distributed.repositories;

import com.project.distributed.models.Category;
import com.project.distributed.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByIdAndMovies(long id, String type);
    //Category findByIdAndMovies(long id);

    //@Query("select * from categories inner join movies ON categories.id = movies.category_id where categories.id = ?1")
    @Query(value = "SELECT * from categories inner join movies ON categories.id = movies.category_id where categories.id = ?1 and movies.type=?2",
            nativeQuery = true
    )
    Category findAvailable(long id, String type);
    //@Query("select distinct c from categories")
    //Category allyall;
    //Category findAvailable(long id, String type);
}
