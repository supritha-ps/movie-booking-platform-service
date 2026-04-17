package com.java.booking.repository;

import com.java.booking.entity.ShowSeat;
import jakarta.persistence.LockModeType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("SELECT s FROM ShowSeat s WHERE s.show.id = :showId AND s.seatNumber IN :seats")
  List<ShowSeat> findSeatsForUpdate(Long showId, List<String> seats);
}
