package com.example.bookstore.endpoint;


import com.example.bookstore.model.*;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RestController
@RequestMapping("/api/books")
public class BookStoreEndpoint {

    private final BookService bookService;

    @Autowired
    public BookStoreEndpoint(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping (value="/hello", produces = MediaType.TEXT_PLAIN_VALUE) // domyslnie wypluje tekst w formie html
    public String hello(){
        return "<p>hello-world </p>";
    }
    @GetMapping("/book")  // jezeli podajemy objekt to domyslnie wypluje json
    public BookDto getBook() {
        return new BookDto("title", "author");
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public BookListingDto getBooks() {
        return BookListingDto.toDto(bookService.getListingData());
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)          // to co pobierze z POST
    public void addBooks(@RequestBody BookDto bookDto) {   // request mapping to to samo co model attribute
        bookService.addBook(bookDto.fromDto());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id,
                          RedirectAttributes redirectAttributes) {
        bookService.deleteBookById(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value= "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE )
    public BookDetailsDto getBookDetails(@PathVariable String id) {
        return BookDetails.toDto(bookService.getBookDetailsById(id));
    }

}
