package com.dernekapp.advice;


import com.dernekapp.exception.AnnouncementNotFoundException;
import com.dernekapp.exception.ApiError;
import com.dernekapp.exception.NewsNotFoundException;
import com.dernekapp.exception.SubjectUniqueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(NewsNotFoundException.class)
    public ResponseEntity<?> newsNotfoundHandler(NewsNotFoundException newsNotFoundException, WebRequest request)
    {
        ApiError apiError=new ApiError();
        apiError.setMessage(newsNotFoundException.getMessage());
        apiError.setDate(new Date(System.currentTimeMillis()));
        apiError.setPath(request.getDescription(true));

        return new ResponseEntity(apiError, HttpStatus.NOT_FOUND);
    }

   @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> newsNotfoundHandler(MethodArgumentNotValidException ex, WebRequest request)
    {
        ApiError apiError=new ApiError();
        apiError.setDate(new Date(System.currentTimeMillis()));
        apiError.setMessage(ex.getMessage());
        apiError.setStatus(request.getDescription(true));
        apiError.setValidationErrors(new HashMap<>());
        for(FieldError fieldError:ex.getBindingResult().getFieldErrors())
        {
         apiError.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());
        }

        return new ResponseEntity(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SubjectUniqueException.class)
    public ResponseEntity<?> newsNotfoundHandler(SubjectUniqueException ex, WebRequest request)
    {
        ApiError apiError=new ApiError();
        apiError.setMessage(ex.getMessage());
        apiError.setPath(request.getDescription(true));
        apiError.setDate(new Date(System.currentTimeMillis()));

        return new ResponseEntity(apiError,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AnnouncementNotFoundException.class)
    public ResponseEntity<?> notFoundException(AnnouncementNotFoundException ex, WebRequest request)
    {
        ApiError apiError=new ApiError();
        apiError.setMessage(ex.getMessage());
        apiError.setDate(new Date(System.currentTimeMillis()));
        apiError.setPath(request.getDescription(true));

        return new ResponseEntity(apiError, HttpStatus.NOT_FOUND);
    }
}
