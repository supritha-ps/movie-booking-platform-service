package com.java.booking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Movie {
  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private String language;
  private String genre;
}
