package mk.ukim.finki.booksbackend.service;

import mk.ukim.finki.booksbackend.model.Book;
import mk.ukim.finki.booksbackend.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies);

    void markAsTaken(Long id);

    void deleteById(Long id);
}
