package com.java.booking.exception;

import com.java.booking.dto.ErrorResponse;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(SeatAlreadyBookedException.class)
  public ResponseEntity<ErrorResponse> handleSeatException(SeatAlreadyBookedException ex) {
    return new ResponseEntity<>(
        new ErrorResponse(ex.getMessage(), 400, LocalDateTime.now()),
        HttpStatus.BAD_REQUEST
    );
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex) {
    return new ResponseEntity<>(
        new ErrorResponse(ex.getMessage(), 404, LocalDateTime.now()),
        HttpStatus.NOT_FOUND
    );
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
    return new ResponseEntity<>(
        new ErrorResponse("Something went wrong", 500, LocalDateTime.now()),
        HttpStatus.INTERNAL_SERVER_ERROR
    );
  }
}
