package com.example.bookstore.model;

/**
 * Created by RENT on 2017-06-03.
 */
public class ErrorResponse {
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
