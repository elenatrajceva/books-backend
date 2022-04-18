package mk.ukim.finki.booksbackend.service;

import mk.ukim.finki.booksbackend.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
}
