package com.project.distributed.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull(groups = Create.class)
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JsonIgnore
    @NotNull(groups = Create.class)
    @JoinColumn(name = "category_id")
    private Category category;

    @NotNull(groups = Create.class)
    @Column(name = "type")
    private String type;

    public Movie(){

    }

    public Movie(@NotNull String name, @NotNull Category category, @NotNull String type) {
        this.name = name;
        this.category = category;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public interface Create{

    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", type='" + type + '\'' +
                '}';
    }
}
