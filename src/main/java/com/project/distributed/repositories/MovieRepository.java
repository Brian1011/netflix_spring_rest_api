package com.project.distributed.repositories;

import com.project.distributed.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByNameIgnoreCaseContaining(String name);
}
