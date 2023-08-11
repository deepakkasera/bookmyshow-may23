package com.scaler.bookmyshowmay23.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
//@Table(name = "users")
public class User extends BaseModel {
    private String email;
}