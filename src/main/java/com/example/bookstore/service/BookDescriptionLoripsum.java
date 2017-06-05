package com.example.bookstore.service;


import com.example.bookstore.model.BookDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestOperations;

@Component
@Qualifier("bookDescriptionLoripsum")
public class BookDescriptionLoripsum implements BookDescriptionClient {

    private final RestOperations restOperations;
    private final String loripsumUrl;

    @Autowired
    public BookDescriptionLoripsum(RestOperations restOperations, @Value("${loripsum.url}") String loripsumUrl) {
        this.restOperations = restOperations;
        this.loripsumUrl = loripsumUrl;
    }

    @Override
    public String getDescription(String bookId) {
        restOperations.postForEntity("http://localhost:8090/api/books", new BookDto("title1", "ajfodsf21"),
                BookDto.class);    // wysylamy POST na podany URL (moze służyc do komunikacji między aplikacjami)
        return restOperations.getForEntity(loripsumUrl +"/api/plaintext", String.class).getBody();
    }
}
