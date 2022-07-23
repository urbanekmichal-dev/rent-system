package com.urbanek.michal.rentsystem.exception;

import com.urbanek.michal.rentsystem.exception.landlord.LandlordExistException;
import com.urbanek.michal.rentsystem.exception.landlord.LandlordNotFoundException;
import com.urbanek.michal.rentsystem.exception.rentobject.RentObjectExistException;
import com.urbanek.michal.rentsystem.exception.rentobject.RentObjectNotFoundException;
import com.urbanek.michal.rentsystem.exception.reservation.ReservationExistException;
import com.urbanek.michal.rentsystem.exception.tenant.TenantExistException;
import com.urbanek.michal.rentsystem.exception.tenant.TenantNotFoundException;
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

    @ExceptionHandler({LandlordNotFoundException.class})
    public ResponseEntity<Object> handleLandLordNotFoundException(Exception ex, WebRequest webRequest){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({LandlordExistException.class})
    public ResponseEntity<Object> handleLandlordExistException(Exception ex, WebRequest webRequest){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({RentObjectExistException.class})
    public ResponseEntity<Object> handleRentObjectExistException(Exception ex, WebRequest webRequest){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({TenantExistException.class})
    public ResponseEntity<Object> handleTenantExistException(Exception ex, WebRequest webRequest){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({ReservationExistException.class})
    public ResponseEntity<Object> handleReservationExistException(Exception ex, WebRequest webRequest){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

}
