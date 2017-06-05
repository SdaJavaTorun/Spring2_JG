package com.example.bookstore.repository;

import com.example.bookstore.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * Created by RENT on 2017-06-05.
 */
public class BookRepositoryImpl implements BookRepositoryCustom {

    @Autowired
    private MongoOperations mongoOperations;

    @Override
    public List<Book> searchSpringBooks() {
        return mongoOperations.find(
                Query.query(where("title").is("Spring")), Book.class);

    }
}
