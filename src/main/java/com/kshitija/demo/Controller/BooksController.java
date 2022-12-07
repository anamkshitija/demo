package com.kshitija.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.kshitija.demo.Model.Books;
import com.kshitija.demo.Service.BooksService;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class BooksController {
    @Autowired
    private BooksService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Books CreateBook (@RequestBody Books books){
        return service.addBooks(books);
    }
    @GetMapping
    public List<Books> GetBooks(){
        return service.findALlBooks();
    }
    @GetMapping("/book_id")
    public List<Books> getBooks(@PathVariable String BookAuthor){
        return service.getBookByAuthor(BookAuthor);
    }
    @PutMapping
    public String UpdateBook(@RequestBody Books books){
        return service.updateBook(books);
    }
    @DeleteMapping("/{book_id}")
    public String DeleteBook(@PathVariable String book_id){
        return service.deleteBook(book_id);
    }

}
