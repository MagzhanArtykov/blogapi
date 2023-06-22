package com.epam.demo.blogapi.util.exceptions;

public class BlogApiException extends Exception{
    public BlogApiException() {
    }

    public BlogApiException(String message) {
        super(message);
    }
}
