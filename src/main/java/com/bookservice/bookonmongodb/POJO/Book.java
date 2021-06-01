package com.bookservice.bookonmongodb.POJO;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Optional;

@Document(collection = "Books")
@Data
public class Book {
    @Id
    private long id;
    private String name;
    private int yearOfPublishing;
    @DBRef
    private Author author;
    @DBRef
    private Genre genre;

    public Book(long id, String name, int yearOfPublishing, Author author, Genre genre) {
        this.id = id;
        this.name = name;
        this.yearOfPublishing = yearOfPublishing;
        this.author = author;
        this.genre = genre;
    }
}
