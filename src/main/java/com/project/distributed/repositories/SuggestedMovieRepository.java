package com.project.distributed.repositories;

import com.project.distributed.models.Client;
import com.project.distributed.models.Movie;
import com.project.distributed.models.SuggestedMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestedMovieRepository extends JpaRepository<SuggestedMovie, Long> {
    SuggestedMovie findByMovieAndClient(Movie movie, Client client);
}
