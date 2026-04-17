package com.java.booking.controller;

import com.java.booking.entity.Show;
import com.java.booking.repository.ShowRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

  private final ShowRepository showRepository;

  @GetMapping("/{movieId}/shows")
  public List<Show> getShows(
      @PathVariable Long movieId,
      @RequestParam String city) {

    return showRepository.findByMovieIdAndTheatreCity(movieId, city);
  }
}