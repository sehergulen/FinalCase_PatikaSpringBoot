package com.credit.approval.app.controller.rest;


import com.credit.approval.app.dto.output.ExceptionResponseDto;
import com.credit.approval.app.exception.CustomerAlreadyDefinedException;
import com.credit.approval.app.exception.CustomerDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CustomerAlreadyDefinedException.class)
    public ResponseEntity<Object> handleCustomerAlreadyDefinedException(CustomerAlreadyDefinedException exception) {
        logExceptionTrace(exception);
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto();
        exceptionResponseDto.setMessage(exception.getMessage());
        exceptionResponseDto.setStatus("ERROR");
        exceptionResponseDto.setDateTime(LocalDateTime.now());
        ResponseEntity<Object> entity = new ResponseEntity<>(exceptionResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }

    @ExceptionHandler(CustomerDoesNotExistException.class)
    public ResponseEntity<Object> handleCustomerAlreadyDefinedException(CustomerDoesNotExistException exception) {
        logExceptionTrace(exception);
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto();
        exceptionResponseDto.setMessage(exception.getMessage());
        exceptionResponseDto.setStatus("ERROR");
        exceptionResponseDto.setDateTime(LocalDateTime.now());
        ResponseEntity<Object> entity = new ResponseEntity<>(exceptionResponseDto, HttpStatus.NOT_FOUND);
        return entity;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception exception) {
        logExceptionTrace(exception);
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto();
        exceptionResponseDto.setMessage(exception.getMessage());
        exceptionResponseDto.setStatus("ERROR");
        exceptionResponseDto.setDateTime(LocalDateTime.now());
        ResponseEntity<Object> entity = new ResponseEntity<>(exceptionResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
        return entity;
    }

    public void logExceptionTrace(Exception exception) {
        logger.error("exception caught:", exception);
    }
}

