package com.scaler.bookmyshowmay23.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private String name;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    private int row;
    private int column;

    @Enumerated(EnumType.ORDINAL)
    private SeatStatus seatStatus;
}
