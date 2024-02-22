package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {
    @Override
    List<ShowSeat> findAllById(Iterable<Long> longs);

    // Upsert - Can act as both insert (id is not present, db generates and returns obj with ID) or Update (if id already given in object)
    @Override
    ShowSeat save(ShowSeat showSeat);
}
