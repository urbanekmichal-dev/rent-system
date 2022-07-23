package com.urbanek.michal.rentsystem.exception.landlord;

public class LandlordNotFoundException extends RuntimeException {

    public LandlordNotFoundException(String message, Throwable cause){
        super(message,cause);
    }

    public LandlordNotFoundException(String message){
        super(message);
    }

}
