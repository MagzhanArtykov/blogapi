package com.epam.demo.blogapi.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BlogApiExceptionHandler {
    @ExceptionHandler(BlogApiException.class)
    public ResponseEntity<Response> handleAPIError(BlogApiException exception){
        return new ResponseEntity<>(new Response(false, HttpStatus.BAD_REQUEST.value(), exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
