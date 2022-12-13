package com.kshitija.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.kshitija.demo.Model.Books;
import com.kshitija.demo.Service.BooksService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private BooksService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Books createBook (@RequestBody Books books){
        return service.addBooks(books);
    }
    @GetMapping
    public List<Books> getBooks(){
        return service.findALlBooks();
    }
    @GetMapping("/{book_id}")
    public Books getBook(@PathVariable String book_id){
        return service.findByBook_id(book_id);
    }
    @GetMapping("/{name}")
    public Books getBooks(@PathVariable String Name){
        return service.getBookByName(Name);
    }
    @PutMapping
    public String updateBook(@RequestBody Books books){
        return service.updateBook(books);
    }
    @DeleteMapping("/{book_id}")
    public String deleteBook(@PathVariable String book_id){
        return service.deleteBook(book_id);
    }

}
