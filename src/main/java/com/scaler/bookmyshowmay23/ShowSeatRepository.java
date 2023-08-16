package com.scaler.bookmyshowmay23;

import com.scaler.bookmyshowmay23.models.Show;
import com.scaler.bookmyshowmay23.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Override
    Optional<ShowSeat> findById(Long showSeatId);
    //select * from show_seat where id = showSeatId

    List<ShowSeat> findAllByIdIn(List<Long> showSeatId);
    //select * from show_seat where id IN (4,5,6,7);

    ShowSeat save(ShowSeat showSeat); // UPSERT -> UPDATE + INSERT
}
