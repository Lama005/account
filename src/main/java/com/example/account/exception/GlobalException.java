package com.example.account.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorObject> accountNotFound(AccountNotFoundException e, WebRequest request) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setMessage(e.getMessage());
        errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorObject.setTimeStamp(new Date());
        return new ResponseEntity<ErrorObject>(errorObject,
                HttpStatus.NOT_FOUND);
    }
}
