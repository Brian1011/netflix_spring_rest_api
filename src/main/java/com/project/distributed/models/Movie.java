package com.project.distributed.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(groups = Update.class)
    @Column(name = "id")
    private long id;

    @NotNull(groups = Create.class)
    @NotNull(groups = Update.class)
    @Column(name = "name")
    private String name;

//
//    @ManyToOne
//    @JsonIgnore
//    @NotNull(groups = Create.class)
//    @NotNull(groups = Update.class)
//    @JoinColumn(name = "category_id")
//    private Category category;


    @NotNull(groups = Create.class)
    @NotNull(groups = Update.class)
    @Column(name = "type")
    private String type; // original or suggested)

    @JsonIgnore
    @ManyToMany(mappedBy = "movies")
    private Set<Category> category;

    public Movie(){

    }

    public Movie(@NotNull(groups = Create.class) @NotNull(groups = Update.class) String name, @NotNull(groups = Create.class) @NotNull(groups = Update.class) String type) {
        this.name = name;
        //this.category = category;
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

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }

    //    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public interface Create{

    }

    public interface Update{

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
