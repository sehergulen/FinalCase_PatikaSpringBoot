package com.credit.approval.app.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExceptionCreator {

    public CustomerAlreadyDefinedException createCustomerAlreadyDefinedException(long tc) {
        String message = "Customer is already defined at database with tc:"+tc;
        return new CustomerAlreadyDefinedException(message);
    }

    public CustomerDoesNotExistException createCustomerDoesNotExistException(long tc) {
        String message = "Customer does not exist at database with tc:"+tc;
        return new CustomerDoesNotExistException(message);
    }
}
