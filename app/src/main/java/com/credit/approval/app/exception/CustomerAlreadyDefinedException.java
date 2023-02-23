package com.credit.approval.app.exception;

public class CustomerAlreadyDefinedException extends RuntimeException {
    public CustomerAlreadyDefinedException(String message){
        super(message);
    }

}
