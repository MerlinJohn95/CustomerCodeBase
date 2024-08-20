package com.example.customer.exception;

public class ServiceException extends Exception {

    public ServiceException(String errorCode) {
        super(errorCode);
    }
}
