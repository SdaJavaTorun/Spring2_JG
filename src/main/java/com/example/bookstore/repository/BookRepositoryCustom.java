package com.example.bookstore.repository;


import com.example.bookstore.model.Book;

import java.util.List;

public interface BookRepositoryCustom {                 // musi się nazywać tak jak nasze repo plus Custom
    List<Book> searchSpringBooks();


}
