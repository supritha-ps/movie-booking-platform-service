package com.java.booking.dto;

import java.util.List;
import lombok.Data;

@Data
public class BookingRequest {
  private Long userId;
  private Long showId;
  private List<String> seats;
}
