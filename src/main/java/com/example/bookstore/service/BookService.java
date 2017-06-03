package com.example.bookstore.service;

import com.example.bookstore.exception.BookNotFoundException;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.BookDetails;
import com.example.bookstore.model.BookListing;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookDescriptionClient bookDescriptionClient;

    @Autowired
    public BookService(BookRepository bookRepository, @Qualifier("bookDescriptionLoripsum") BookDescriptionClient bookDescriptionClient ) {

        this.bookRepository = bookRepository;
        this.bookDescriptionClient = bookDescriptionClient;
    }

    public BookListing getListingData() {
        List<Book> books = bookRepository.findAll();

        return new BookListing(
                books,
                books.size()
        );
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBookById(String id) {
        Optional<Book> book = bookRepository.findById(id);
        book.ifPresent(bookRepository::delete);
    }

    public BookDetails getBookDetailsById(String id) {
        Optional<Book> existingBook = bookRepository.findById(id);
        return existingBook.map(book -> new BookDetails(
                book.getTitle(), book.getAuthor(), bookDescriptionClient.getDescription(book.getId())))
                .orElseThrow(() -> new BookNotFoundException("Ksiażka o numerze" + id + "nie została odnaleziona"

                ));
    }
}
