package com.kshitija.demo.Repository;

import com.kshitija.demo.Model.Books;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends MongoRepository<Books, String> {
    List<Books> findByName(String Author);
}
