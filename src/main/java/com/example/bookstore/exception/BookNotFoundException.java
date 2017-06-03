package com.example.bookstore.exception;

import com.example.bookstore.model.Book;


public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String s){
        super(s);
    }
}
