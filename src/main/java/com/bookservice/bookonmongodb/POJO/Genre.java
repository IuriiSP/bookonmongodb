package com.bookservice.bookonmongodb.POJO;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Genres")
@Data
public class Genre {
    @Id
    private long id;
    String genreName;

    public Genre(long id, String genreName) {
        this.id = id;
        this.genreName = genreName;
    }
}
