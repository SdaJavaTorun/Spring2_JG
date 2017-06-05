package com.example.bookstore.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)  // jezeli jakas dana z objektu nie bedie pasowac do pol tej klasy to je zignoruje
public class BookListingDto {

    private List<BookDto> books;
    private int count;

    public BookListingDto(List<BookDto> books, int count) {
        this.books = books;
        this.count = count;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public int getCount() {
        return count;
    }
    public static BookListingDto toDto(BookListing bookListing) {
        return new BookListingDto(
                bookListing.getBooks().stream().map(book -> BookDto.toDto(book)).collect(Collectors.toList()),
                bookListing.getCount());
    }


}
