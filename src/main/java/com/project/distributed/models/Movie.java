package com.project.distributed.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "category_id")
    private long categoryId;

    @NotNull
    @Column(name = "type")
    private String type;

    public Movie(){

    }

    public Movie(@NotNull String name, @NotNull long categoryId, @NotNull String type) {
        this.name = name;
        this.categoryId = categoryId;
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

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", type='" + type + '\'' +
                '}';
    }
}
