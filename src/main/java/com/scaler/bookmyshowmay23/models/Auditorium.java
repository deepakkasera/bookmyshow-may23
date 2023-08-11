package com.scaler.bookmyshowmay23.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel {
    private String name;

    @OneToMany
    private List<Seat> seats;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Feature> auditoriumFeatures;
}

//Audi - Seat
// 1 ---- M
// 1 ---- 1

/*
Audi - Features -> Many to Many
1 ---- M
M ---- M
 */

