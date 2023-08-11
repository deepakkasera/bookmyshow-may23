package com.scaler.bookmyshowmay23.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
// @Data -> To provide getter and setters both.
public class Movie extends BaseModel {
    private String name;

    @ManyToMany
    private List<Actor> actors;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Feature> movieFeatures;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Genre> genre;
}

//Lombok -> Provides a way to add Getter & Setter methods
// for all the fields of a class using annotations.

//Spring Data JPA.

/*
Movie - Actor
1 -----M
M ----- 1
 */