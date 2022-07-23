package com.urbanek.michal.rentsystem.exception.reservation;

public class ReservationExistException extends RuntimeException {

    public ReservationExistException(String message, Throwable cause){
        super(message,cause);
    }

    public ReservationExistException(String message){
        super(message);
    }

}
