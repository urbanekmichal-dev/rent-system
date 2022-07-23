package com.urbanek.michal.rentsystem.exception.tenant;

public class TenantExistException extends RuntimeException {

    public TenantExistException(String message, Throwable cause){
        super(message,cause);
    }

    public TenantExistException(String message){
        super(message);
    }

}
