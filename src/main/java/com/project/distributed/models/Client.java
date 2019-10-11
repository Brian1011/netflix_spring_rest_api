package com.project.distributed.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
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
    @Column(name = "national_id")
    private long nationalId;

    @NotNull(groups = Create.class)
    @NotNull(groups = Update.class)
    @Column(name = "name")
    private String name;

    //@OneToMany(mappedBy = "clients")
    //private Set<SuggestedMovie> suggestedMovies = new HashSet<>();

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

    /*
    public Set<SuggestedMovie> getSuggestedMovies() {
        return suggestedMovies;
    }

    public void setSuggestedMovies(Set<SuggestedMovie> suggestedMovies) {
        this.suggestedMovies = suggestedMovies;
    }
     */

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
                //", suggestedMovies=" + suggestedMovies +
                '}';
    }
}
