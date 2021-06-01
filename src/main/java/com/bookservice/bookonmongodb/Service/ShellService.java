package com.bookservice.bookonmongodb.Service;

import com.bookservice.bookonmongodb.POJO.Author;
import com.bookservice.bookonmongodb.POJO.Book;
import com.bookservice.bookonmongodb.POJO.Genre;
import com.bookservice.bookonmongodb.Repository.AuthorRepository;
import com.bookservice.bookonmongodb.Repository.BookRepository;
import com.bookservice.bookonmongodb.Repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

@ShellComponent
@RequiredArgsConstructor
/**
 * Методы для работы с Жанрами
 */
public class ShellService {
    private final GenreRepository genreRep;
    private final AuthorRepository authorRep;
    private final BookRepository bookRep;
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @ShellMethod(key = "genreCount", value = "число жанров")
    public void genreCount() {
        System.out.println("Число жанров: " + genreRep.count());
    }

    @ShellMethod(key = "findGenre", value = "найти жанр по id")
    public void findGenreById() {
        try {
            long id = Long.parseLong(reader.readLine());
            Optional<Genre> genre = genreRep.findById(id);
            System.out.println(genre);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "findGenres", value = "жанры")
    public void findGenres() {
        List<Genre> genres = genreRep.findAll();
        if (genres.size() < 1) System.out.println("Empty");
        else genres.forEach(System.out::println);
    }

    @ShellMethod(key = "saveGenre", value = "сохранить жанр в БД")
    public void saveGenre() {
        try {
            long id = Long.parseLong(reader.readLine());
            String genreName = reader.readLine();
            genreRep.save(new Genre(id, genreName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "deleteGenre", value = "Удалить жанр")
    public void deleteGenre() {
        try {
            long id = Long.parseLong(reader.readLine());
            genreRep.deleteById(id);
            System.out.println("delete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Методы для работы с авторами
     */

    @ShellMethod(key = "authorCount", value = "получить число авторов")
    public void authorCount(){
        System.out.println("Число авторов: " + authorRep.count());
    }

    @ShellMethod(key = "findAuthor", value = "Найти автора по id")
    public void findAuthorById(){
        try {
            long id = Long.parseLong(reader.readLine());
            Optional<Author> author = authorRep.findById(id);
            System.out.println(author);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "findAllAuthors", value = "Найти всех авторов")
    public void findAuthors(){
        List<Author> authors = authorRep.findAll();
        if (authors.size() < 1) System.out.println("Empty");
        authors.forEach(System.out::println);
    }

    @ShellMethod(key = "saveAuthor", value = "соранить автоа в БД")
    public void saveAuthor(){
        try {
            long id = Long.parseLong(reader.readLine());
            String name = reader.readLine();
            authorRep.save(new Author(id, name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = "deleteAuthor", value = "Удалить автора")
    public void deleteAuthor(){
        try {
            long id = Long.parseLong(reader.readLine());
            authorRep.deleteById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Методы для работы с книгами
     */

    @ShellMethod (key = "bookCount", value = "количество книг")
    public void bookCount(){
        System.out.println("Число книг: " + bookRep.count());
    }

    @ShellMethod (key = "findBookById", value = "найти книгу по id")
    public void findBookById(){
        try {
            long id = Long.parseLong(reader.readLine());
            Optional<Book> book = bookRep.findById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ShellMethod (key = "findBooks", value = "найти все книги")
    public void findAllBooks(){
        List<Book> books = bookRep.findAll();
        books.forEach(System.out::println);
    }

    @ShellMethod (key = "saveBook", value = "добавить книгу в бд")
    public void saveBook(){
        try {
            long id = Long.parseLong(reader.readLine());
            String bookName = reader.readLine();
            int year = Integer.parseInt(reader.readLine());
            System.out.println("Введите id автора");
            long authorId = Long.parseLong(reader.readLine());
            Optional<Author> author = authorRep.findById(authorId);
            System.out.println("Введите id жанра");
            long genreId = Long.parseLong(reader.readLine());
            Optional<Genre> genre = genreRep.findById(genreId);
            Author author1 = author.get();
            Genre genre1 = genre.get();
            bookRep.save(new Book(id, bookName, year, author1, genre1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ShellMethod (key = "deleteBook", value = "удалить книгу")
    public void deleteBook() {
        try {
            long id = Long.parseLong(reader.readLine());
            bookRep.deleteById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
