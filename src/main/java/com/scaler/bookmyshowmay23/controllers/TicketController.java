package com.scaler.bookmyshowmay23.controllers;

import com.scaler.bookmyshowmay23.dto.BookTicketRequestDto;
import com.scaler.bookmyshowmay23.dto.BookTicketResponseDto;
import com.scaler.bookmyshowmay23.exceptions.ShowSeatNotFoundException;
import com.scaler.bookmyshowmay23.models.Ticket;
import com.scaler.bookmyshowmay23.services.TicketService;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) throws ShowSeatNotFoundException {
         Ticket ticket = ticketService.bookTicket(bookTicketRequestDto.getShowSeatIds(),
                 bookTicketRequestDto.getUserId(), bookTicketRequestDto.getShowId());

         BookTicketResponseDto responseDto = new BookTicketResponseDto();
         responseDto.setTicket(ticket);
         return responseDto;
        //return null;
    }
}
