package com.dernekapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SubjectUniqueException extends RuntimeException{

    public SubjectUniqueException(String message){
        super(message);


    }
}
