package com.java.booking.service;

import com.java.booking.entity.Booking;
import com.java.booking.entity.ShowSeat;
import com.java.booking.enums.BookingStatus;
import com.java.booking.enums.SeatStatus;
import com.java.booking.exception.ResourceNotFoundException;
import com.java.booking.exception.SeatAlreadyBookedException;
import com.java.booking.repository.BookingRepository;
import com.java.booking.repository.ShowSeatRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookingService {

  private final ShowSeatRepository showSeatRepository;
  private final BookingRepository bookingRepository;

  @Transactional
  public Booking bookTickets(Long userId, Long showId, List<String> seats) {

    List<ShowSeat> showSeats =
        showSeatRepository.findSeatsForUpdate(showId, seats);

    if (showSeats.isEmpty()) {
      throw new ResourceNotFoundException("Seats not found");
    }

    for (ShowSeat seat : showSeats) {
      if (seat.getStatus() != SeatStatus.AVAILABLE) {
        throw new SeatAlreadyBookedException(
            "Seat already booked: " + seat.getSeatNumber());
      }
      seat.setStatus(SeatStatus.LOCKED);
      seat.setLockedUntil(LocalDateTime.now().plusMinutes(5));
    }

    double total = showSeats.size() * showSeats.get(0).getShow().getPrice();

    Booking booking = new Booking();
    booking.setUserId(userId);
    booking.setShow(showSeats.get(0).getShow());
    booking.setStatus(BookingStatus.PENDING);
    booking.setTotalAmount(total);

    bookingRepository.save(booking);

    // Simulate payment success
    booking.setStatus(BookingStatus.CONFIRMED);

    for (ShowSeat seat : showSeats) {
      seat.setStatus(SeatStatus.BOOKED);
    }

    return booking;
  }
}