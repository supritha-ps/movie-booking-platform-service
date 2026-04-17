package com.java.booking.controller;

import com.java.booking.dto.BookingRequest;
import com.java.booking.entity.Booking;
import com.java.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

  private final BookingService bookingService;

  @PostMapping
  public Booking book(@RequestBody BookingRequest request) {
    return bookingService.bookTickets(
        request.getUserId(),
        request.getShowId(),
        request.getSeats()
    );
  }
}
