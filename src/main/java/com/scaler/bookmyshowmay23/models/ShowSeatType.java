package com.scaler.bookmyshowmay23.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
//@Table(name = "show_seattype_mapping")
public class ShowSeatType extends BaseModel {
    @ManyToOne
    private Show show;

    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;

    private double price;
}


/*
(123, Recliner)
(123, Gold)
(156, Recliner)
ShowSeatType ------- Show
     1    -          1
     M                1

 */
