package com.example.bookstore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDto {
    private String id;

    @JsonProperty("title")
    private String name;
    private String author;

    public BookDto() {
    }

    public BookDto(String name, String author) {
        this.name = name;
        this.author = author;
    }
    public BookDto(String id, String name, String author ){
        this.name = name;
        this.author = author;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book fromDto() {
        return new Book(name, author);
    }

    public static BookDto toDto(Book book) {
        return new BookDto(book.getTitle(), book.getAuthor());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookDto bookDto = (BookDto) o;

        if (name != null ? !name.equals(bookDto.name) : bookDto.name != null) return false;
        return author != null ? author.equals(bookDto.author) : bookDto.author == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}
