package com.urbanek.michal.rentsystem.exception.reservation;

public class ReservationNotFoundException extends RuntimeException {

    public ReservationNotFoundException(String message, Throwable cause){
        super(message,cause);
    }

    public ReservationNotFoundException(String message){
        super(message);
    }

}
