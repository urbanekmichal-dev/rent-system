package com.urbanek.michal.rentsystem.exception.rentobject;

public class RentObjectExistException extends RuntimeException {

    public RentObjectExistException(String message, Throwable cause){
        super(message,cause);
    }

    public RentObjectExistException(String message){
        super(message);
    }

}
