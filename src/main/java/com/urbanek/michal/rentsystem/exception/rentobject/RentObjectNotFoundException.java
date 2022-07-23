package com.urbanek.michal.rentsystem.exception.rentobject;

public class RentObjectNotFoundException extends RuntimeException {

    public RentObjectNotFoundException(String message, Throwable cause){
        super(message,cause);
    }

    public RentObjectNotFoundException(String message){
        super(message);
    }

}
