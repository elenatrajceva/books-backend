package mk.ukim.finki.booksbackend.controller;

import mk.ukim.finki.booksbackend.model.Book;
import mk.ukim.finki.booksbackend.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/categories")
public class CategoryController{

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(Arrays.asList(Category.values()));
    }
}
