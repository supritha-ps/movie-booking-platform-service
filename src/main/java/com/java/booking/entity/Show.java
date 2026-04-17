package com.java.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Data
public class Show {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  private Movie movie;

  @ManyToOne
  private Theatre theatre;

  private LocalDateTime startTime;
  private Double price;
}
