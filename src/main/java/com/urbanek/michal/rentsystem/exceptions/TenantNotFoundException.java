package com.urbanek.michal.rentsystem.exceptions;

public class TenantNotFoundException extends RuntimeException {

    public TenantNotFoundException(String message, Throwable cause){
        super(message,cause);
    }

    public TenantNotFoundException(String message){
        super(message);
    }

}
