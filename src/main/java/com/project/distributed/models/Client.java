package com.project.distributed.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(groups = Update.class)
    @Column(name = "id")
    private long id;

    @NotNull(groups = Create.class)
    @NotNull(groups = Update.class)
    @Column(name = "national_id", unique = true)
    private long nationalId;

    @NotNull(groups = Create.class)
    @NotNull(groups = Update.class)
    @Column(name = "name")
    private String name;

    //@JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<SuggestedMovie> suggestedMovies;

    public Client(){

    }

    public Client(@NotNull(groups = Create.class) @NotNull(groups = Update.class) long nationalId, @NotNull(groups = Create.class) @NotNull(groups = Update.class) String name) {
        this.nationalId = nationalId;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNationalId() {
        return nationalId;
    }

    public void setNationalId(long nationalId) {
        this.nationalId = nationalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SuggestedMovie> getSuggestedMovies() {
        return suggestedMovies;
    }

    public void setSuggestedMovies(List<SuggestedMovie> suggestedMovies) {
        this.suggestedMovies = suggestedMovies;
    }

    public interface Create{

    }

    public interface Update{

    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nationalId=" + nationalId +
                ", name='" + name + '\'' +
                ", suggestedMovies=" + suggestedMovies +
                '}';
    }
}
