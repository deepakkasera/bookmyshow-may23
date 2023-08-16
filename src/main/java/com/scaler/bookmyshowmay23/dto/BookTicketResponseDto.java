package com.scaler.bookmyshowmay23.dto;

import com.scaler.bookmyshowmay23.models.Ticket;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.tool.schema.extract.spi.TableInformation;

@Getter
@Setter
public class BookTicketResponseDto {
    private Ticket ticket;
}
