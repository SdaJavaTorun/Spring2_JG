package com.example.bookstore.service;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bookDescriptionDummy")
public class BookDescritionDummy implements BookDescriptionClient {


    @Override
    public String getDescription(String bookId) {
        return "book description";
    }
}
