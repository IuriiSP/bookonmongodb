package com.bookservice.bookonmongodb.Repository;

import com.bookservice.bookonmongodb.POJO.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthorRepository extends MongoRepository<Author, Long> {
}
