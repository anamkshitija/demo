package com.kshitija.demo.Repository;

import com.kshitija.demo.Model.Books;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepository extends MongoRepository<Books, String> {
    Books findByName(String Name);
}
