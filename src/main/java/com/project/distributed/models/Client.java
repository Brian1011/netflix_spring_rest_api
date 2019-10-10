package com.project.distributed.models;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "national_id")
    private long nationalId;

    @Column(name = "name")
    private String name;

    public Client(){

    }

    public Client(long nationalId, String name) {
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nationalId=" + nationalId +
                ", name='" + name + '\'' +
                '}';
    }
}
