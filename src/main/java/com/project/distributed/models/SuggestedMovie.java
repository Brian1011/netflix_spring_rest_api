package com.project.distributed.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "suggestions")
public class SuggestedMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonIgnore
    @OneToOne
    @NotNull(groups = Create.class)
    @JoinColumn(name = "client_id")
    private Client client;

    //@JsonIgnore
    @OneToOne
    @NotNull(groups = Create.class)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public SuggestedMovie(){

    }

    public SuggestedMovie(@NotNull(groups = Create.class) Client client, @NotNull(groups = Create.class) Movie movie) {
        this.client = client;
        this.movie = movie;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public interface Create{

    }

    @Override
    public String toString() {
        return "SuggestedMovie{" +
                "id=" + id +
                ", client=" + client +
                ", movie=" + movie +
                '}';
    }
}
