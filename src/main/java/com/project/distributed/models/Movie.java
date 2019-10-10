package com.project.distributed.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
    private long id;
    private String name;
    private long category_id;
    private String type;
}
