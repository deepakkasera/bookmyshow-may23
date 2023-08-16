package com.scaler.bookmyshowmay23.dto;

import com.scaler.bookmyshowmay23.models.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDto {
    private Long showId;
    private Long userId;
    private List<Long> showSeatIds;
}
