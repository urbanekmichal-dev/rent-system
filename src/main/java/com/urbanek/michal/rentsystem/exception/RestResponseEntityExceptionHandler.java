package com.urbanek.michal.rentsystem.exception;

import com.urbanek.michal.rentsystem.exception.landlord.LandlordExistException;
import com.urbanek.michal.rentsystem.exception.landlord.LandlordNotFoundException;
import com.urbanek.michal.rentsystem.exception.rentobject.RentObjectExistException;
import com.urbanek.michal.rentsystem.exception.rentobject.RentObjectNotFoundException;
import com.urbanek.michal.rentsystem.exception.reservation.ReservationExistException;
import com.urbanek.michal.rentsystem.exception.reservation.ReservationNotFoundException;
import com.urbanek.michal.rentsystem.exception.tenant.TenantExistException;
import com.urbanek.michal.rentsystem.exception.tenant.TenantNotFoundException;
import org.hibernate.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RentObjectNotFoundException.class})
    public ResponseEntity<Object> handleRentObjectNotFoundException(Exception ex, WebRequest webRequest){
        Map<String,String> exResponse= new HashMap<>();
        exResponse.put("message",ex.getMessage());
        return new ResponseEntity<>(exResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({TenantNotFoundException.class})
    public ResponseEntity<Object> handleTenantNotFoundException(Exception ex, WebRequest webRequest){
        Map<String,String> exResponse= new HashMap<>();
        exResponse.put("message",ex.getMessage());
        return new ResponseEntity<>(exResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({LandlordNotFoundException.class})
    public ResponseEntity<Object> handleLandLordNotFoundException(Exception ex, WebRequest webRequest){
        Map<String,String> exResponse= new HashMap<>();
        exResponse.put("message",ex.getMessage());
        return new ResponseEntity<>(exResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ReservationNotFoundException.class})
    public ResponseEntity<Object> handleReservationNotFoundException(Exception ex, WebRequest webRequest){
        Map<String,String> exResponse= new HashMap<>();
        exResponse.put("message",ex.getMessage());
        return new ResponseEntity<>(exResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({LandlordExistException.class})
    public ResponseEntity<Object> handleLandlordExistException(Exception ex, WebRequest webRequest){
        Map<String,String> exResponse= new HashMap<>();
        exResponse.put("message",ex.getMessage());
        return new ResponseEntity<>(exResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({RentObjectExistException.class})
    public ResponseEntity<Object> handleRentObjectExistException(Exception ex, WebRequest webRequest){
        Map<String,String> exResponse= new HashMap<>();
        exResponse.put("message",ex.getMessage());
        return new ResponseEntity<>(exResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({TenantExistException.class})
    public ResponseEntity<Object> handleTenantExistException(Exception ex, WebRequest webRequest){
        Map<String,String> exResponse= new HashMap<>();
        exResponse.put("message",ex.getMessage());
        return new ResponseEntity<>(exResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({ReservationExistException.class})
    public ResponseEntity<Object> handleReservationExistException(Exception ex, WebRequest webRequest){
        Map<String,String> exResponse= new HashMap<>();
        exResponse.put("message",ex.getMessage());
        return new ResponseEntity<>(exResponse, HttpStatus.CONFLICT);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request)
    {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
}
