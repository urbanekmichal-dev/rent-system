package com.urbanek.michal.rentsystem.exceptions;

public class LandLordNotFoundException extends RuntimeException {

    public LandLordNotFoundException(String message, Throwable cause){
        super(message,cause);
    }

    public LandLordNotFoundException(String message){
        super(message);
    }

}
