package com.scaler.bookmyshowmay23.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseModel {
    @Id // used to define the PK.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "identity")
    private Long id;
}

/*
@MappedSuperClass -> This is the parent class of all the classes which are extending this
also the column within this class will be propagated in every child class as their column.
 */

//Spring Data JPA -> Java Persistence API.

//Hw -

/*
1. MappedSupoerClass.
2. GenerationType.Identity
3.
 */