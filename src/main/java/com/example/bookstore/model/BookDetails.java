package com.example.bookstore.model;

/**
 * Created by RENT on 2017-06-03.
 */
public class BookDetails {
    private final String title;
    private final String author;
    private final String description;

    public BookDetails(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "BookDetails{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static BookDetailsDto toDto (BookDetails bookDetails){
        return new BookDetailsDto(bookDetails.getTitle(), bookDetails.getAuthor(), bookDetails.getDescription());
    }
}
