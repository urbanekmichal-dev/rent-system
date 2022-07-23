package com.urbanek.michal.rentsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RentObjectNotFoundException.class})
    public ResponseEntity<Object> handleRentObjectNotFoundException(Exception ex, WebRequest webRequest){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({TenantNotFoundException.class})
    public ResponseEntity<Object> handleTenantNotFoundException(Exception ex, WebRequest webRequest){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({LandLordNotFoundException.class})
    public ResponseEntity<Object> handleLandLordNotFoundException(Exception ex, WebRequest webRequest){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
