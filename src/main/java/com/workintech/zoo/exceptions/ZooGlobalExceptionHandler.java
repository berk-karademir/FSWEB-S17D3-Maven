package com.workintech.zoo.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/* uygulamanın herhangi bir yeridne oluşabilecek tüm exceptionları
merkezi bir noktadan yönetmemizi sağlayan class */
@Slf4j
@ControllerAdvice
public class ZooGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> handleException(ZooException exception) {
        ZooErrorResponse zooErrorResponse = new ZooErrorResponse(exception.getHttpStatus().value(), exception.getLocalizedMessage(), System.currentTimeMillis());
        log.error("An error has occurred!", exception);
        return new ResponseEntity<>(zooErrorResponse, exception.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ZooErrorResponse> handleException(Exception exception) {
        ZooErrorResponse zooErrorResponse = new ZooErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getLocalizedMessage(), System.currentTimeMillis());
        log.error("An unexpected error has occurred!", exception);
        return new ResponseEntity<>(zooErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
