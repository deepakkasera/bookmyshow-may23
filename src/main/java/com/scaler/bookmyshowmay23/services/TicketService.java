package com.scaler.bookmyshowmay23.services;

import com.scaler.bookmyshowmay23.ShowSeatRepository;
import com.scaler.bookmyshowmay23.exceptions.ShowSeatNotFoundException;
import com.scaler.bookmyshowmay23.models.ShowSeat;
import com.scaler.bookmyshowmay23.models.ShowSeatState;
import com.scaler.bookmyshowmay23.models.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private ShowSeatRepository showSeatRepository;

    TicketService(ShowSeatRepository showSeatRepository) {
        this.showSeatRepository = showSeatRepository;
    }
    public Ticket bookTicket(List<Long> showSeatIds,
                             Long userId,
                             Long showId) throws ShowSeatNotFoundException {
        //Steps:-

        //1. Fetch show Seats from the list of showSeatIds.
        List<ShowSeat> showSeats = showSeatRepository.findAllByIdIn(showSeatIds);

        //2. Check the status of Show Seats.
        //3. If any one of them is not AVAILABLE then throw an exception.
        for (ShowSeat showSeat : showSeats) {
            if (!showSeat.getState().equals(ShowSeatState.AVAILABLE)) {
                //throw an exception
                throw new ShowSeatNotFoundException(showSeat.getId());
            }
        }

        //4. Acquire the lock.
        for (ShowSeat showSeat : showSeats) {
            showSeat.setState(ShowSeatState.LOCKED);
            showSeatRepository.save(showSeat);
        }

        //5. Check the status of Show Seats again.
        //6. If all the seats are AVAILABLE, then generate the Ticket.

        return null;
    }
}
