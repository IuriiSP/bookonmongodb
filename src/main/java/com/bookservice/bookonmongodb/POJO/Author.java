package com.bookservice.bookonmongodb.POJO;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Authors")
@Data
public class Author {

    @Id
    private long id;
    private String name;

    public Author(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
