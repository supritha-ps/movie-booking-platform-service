package com.java.booking.repository;

import com.java.booking.entity.Show;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Long> {
  List<Show> findByMovieIdAndTheatreCity(Long movieId, String city);
}