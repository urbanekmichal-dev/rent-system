package com.urbanek.michal.rentsystem.exception.landlord;

public class LandlordExistException extends RuntimeException {

    public LandlordExistException(String message, Throwable cause){
        super(message,cause);
    }

    public LandlordExistException(String message){
        super(message);
    }

}
