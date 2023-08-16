package com.scaler.bookmyshowmay23.services;

import com.scaler.bookmyshowmay23.models.*;
import com.scaler.bookmyshowmay23.repositories.ShowSeatRepository;
import com.scaler.bookmyshowmay23.exceptions.ShowSeatNotFoundException;
import com.scaler.bookmyshowmay23.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private ShowSeatRepository showSeatRepository;
    private UserRepository userRepository;

    TicketService(ShowSeatRepository showSeatRepository,
                  UserRepository userRepository) {
        this.showSeatRepository = showSeatRepository;
        this.userRepository = userRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Long> showSeatIds,
                             Long userId,
                             Long showId) throws ShowSeatNotFoundException {
        //Steps:-

        //1. Fetch show Seats from the list of showSeatIds. (No lock)
        List<ShowSeat> showSeats = showSeatRepository.findAllByIdIn(showSeatIds);

        //2. Check the status of Show Seats.
        //3. If any one of them is not AVAILABLE then throw an exception.
        for (ShowSeat showSeat : showSeats) {
            if (!showSeat.getState().equals(ShowSeatState.AVAILABLE)) {
                //throw an exception
                throw new ShowSeatNotFoundException(showSeat.getId());
            }
        }

        //4. Acquire the lock. -> call findAllByIdIn() with LOCK.
        //5. Check the status of Show Seats again.
        showSeats = showSeatRepository.findAllByIdIn(showSeatIds); //WITH LOCK.

        //Check the status again for the all the show seats.

        for (ShowSeat showSeat : showSeats) {
            showSeat.setState(ShowSeatState.LOCKED);
            showSeatRepository.save(showSeat);
        }
        //6. If all the seats are AVAILABLE, then generate the Ticket.

        Ticket ticket = new Ticket();

        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty()) {
            //
        }

        ticket.setBookedBy(userOptional.get());
        ticket.setTicketStatus(TicketStatus.PENDING); //Ticket Status will be CONFIRMED only after payment.
        ticket.setShowSeats(showSeats);

        //PaymentService.

//        if (paymentStatus != SUCCESS) {
//            rollback the entire transaction.
//        }
        return ticket;
    }
}
