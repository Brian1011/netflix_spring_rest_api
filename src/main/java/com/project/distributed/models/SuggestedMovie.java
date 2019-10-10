package com.project.distributed.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "suggestions")
public class SuggestedMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(groups = Create.class)
    @Column(name = "client_id")
    private long clientId;

    @NotNull(groups = Create.class)
    @Column(name = "movie_id")
    private long movieId;

    public SuggestedMovie(){

    }

    public SuggestedMovie(@NotNull(groups = Create.class) long clientId, @NotNull(groups = Create.class) long movieId) {
        this.clientId = clientId;
        this.movieId = movieId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public interface Create{

    }

    @Override
    public String toString() {
        return "SuggestedMovie{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", movieId=" + movieId +
                '}';
    }
}
