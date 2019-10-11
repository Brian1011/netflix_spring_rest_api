package com.project.distributed.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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
    @OneToMany(mappedBy = "category")
    private List<Movie> movies;

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

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public interface Create{

    }

    public interface Update{}

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", movies=" + movies +
                '}';
    }
}
