package com.bookservice.bookonmongodb.Repository;

import com.bookservice.bookonmongodb.POJO.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, Long> {
}
