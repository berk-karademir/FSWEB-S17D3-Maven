package com.workintech.zoo.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
public class ZooException extends RuntimeException {

  HttpStatus httpStatus;

  public ZooException(String message,  HttpStatus httpStatus) {
    super(message);
    this.httpStatus = httpStatus;
  }
}
