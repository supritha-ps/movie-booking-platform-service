package com.java.booking.entity;

import com.java.booking.enums.SeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Data
public class ShowSeat {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private Show show;

  private String seatNumber;

  @Enumerated(EnumType.STRING)
  private SeatStatus status;

  private LocalDateTime lockedUntil;
}
