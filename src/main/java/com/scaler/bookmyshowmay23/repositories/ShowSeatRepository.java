package com.scaler.bookmyshowmay23.repositories;

import com.scaler.bookmyshowmay23.models.Show;
import com.scaler.bookmyshowmay23.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Override
    Optional<ShowSeat> findById(Long showSeatId);
    //select * from show_seat where id = showSeatId

    //select * from show_seat where Id in (....) for update.
    @Lock(LockModeType.PESSIMISTIC_READ)
    List<ShowSeat> findAllByIdIn(List<Long> showSeatId);
    //select * from show_seat where id IN (4,5,6,7);

    ShowSeat save(ShowSeat showSeat); // UPSERT -> UPDATE + INSERT
}
