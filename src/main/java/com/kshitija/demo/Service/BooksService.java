package com.kshitija.demo.Service;

import com.kshitija.demo.Model.Books;
import com.kshitija.demo.Repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;

@Service
public class BooksService {
    @Autowired
    public BooksRepository repository;

    public Books addBooks(Books books){
        books.setBook_id(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(books);
    }
    public List<Books> findALlBooks(){
        return repository.findAll();
    }
    public List<Books> getBookByAuthor (String Author){
        return repository.findByName(Author);
    }
    public String updateBook (Books BookRequest){
        Books existingBooks = repository.findById(BookRequest.getBook_id()).get();
        existingBooks.setName(BookRequest.getName());
        existingBooks.setAuthor(BookRequest.getAuthor());
        existingBooks.setPrice(BookRequest.getPrice());
        repository.save(BookRequest);
        return "Data Saved Successfully";
    }
    public String deleteBook(String book_id){
        repository.deleteById(book_id);
        return book_id + "Book data deleted";
    }

}
