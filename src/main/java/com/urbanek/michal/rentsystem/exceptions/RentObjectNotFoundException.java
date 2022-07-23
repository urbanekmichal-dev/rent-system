package com.urbanek.michal.rentsystem.exceptions;

import net.bytebuddy.implementation.bytecode.Throw;

public class RentObjectNotFoundException extends RuntimeException {

    public RentObjectNotFoundException(String message, Throwable cause){
        super(message,cause);
    }

    public RentObjectNotFoundException(String message){
        super(message);
    }

}
