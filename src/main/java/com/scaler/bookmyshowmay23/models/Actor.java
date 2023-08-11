package com.scaler.bookmyshowmay23.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity //Create a table for this entity.
@Getter
@Setter
public class Actor extends BaseModel {
    private String name;
}
