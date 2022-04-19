package mk.ukim.finki.booksbackend.controller;

import mk.ukim.finki.booksbackend.model.Author;
import mk.ukim.finki.booksbackend.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> findAll() {
        return ResponseEntity.ok(this.authorService.findAll());
    }
}
