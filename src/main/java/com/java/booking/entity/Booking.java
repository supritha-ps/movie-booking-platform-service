package com.java.booking.entity;

import com.java.booking.enums.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Booking {
  @Id
  @GeneratedValue
  private Long id;

  private Long userId;

  @ManyToOne
  private Show show;

  @Enumerated(EnumType.STRING)
  private BookingStatus status;

  private Double totalAmount;
}
