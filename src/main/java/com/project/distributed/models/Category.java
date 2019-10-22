package com.project.distributed.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(groups = Update.class)
    @Column(name = "id")
    private long id;

    @Column(name = "category_name")
    @NotNull(groups = Create.class)
    private String categoryName;

    //@JsonIgnore
   // @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
   // private List<Movie> movies;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "movie_categories",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private Set<Movie> movies = new HashSet<>();

    private Category(){

    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

//    public List<Movie> getMovies() {
//        return movies;
//    }
//
//    public void setMovies(List<Movie> movies) {
//        this.movies = movies;
//    }

    public Set<Movie> getMovieSet() {
        return movies;
    }

    public void setMovieSet(Set<Movie> movieSet) {
        this.movies = movieSet;
    }

    public interface Create{

    }

    public interface Update{}

    public void addMovie(Movie movie){
        movies.add(movie);
    }
}
