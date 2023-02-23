package com.credit.approval.app.exception;

public class CustomerDoesNotExistException extends RuntimeException {
    public CustomerDoesNotExistException(String message){
        super(message);
    }

}
