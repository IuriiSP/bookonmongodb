package com.bookservice.bookonmongodb.Repository;

import com.bookservice.bookonmongodb.POJO.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends MongoRepository<Genre, Long> {
}
