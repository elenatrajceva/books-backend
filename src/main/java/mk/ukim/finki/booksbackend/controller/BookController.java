package mk.ukim.finki.booksbackend.controller;

import mk.ukim.finki.booksbackend.dto.BookDto;
import mk.ukim.finki.booksbackend.model.Book;
import mk.ukim.finki.booksbackend.model.Category;
import mk.ukim.finki.booksbackend.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(this.bookService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        Book book = this.bookService.save(
                bookDto.getName(),
                Category.valueOf(bookDto.getCategory()),
                bookDto.getAuthorId(),
                bookDto.getAvailableCopies()).get();
        return ResponseEntity.ok().body(book);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody BookDto bookDto) {
        Book book = this.bookService.edit(
                id,
                bookDto.getName(),
                Category.valueOf(bookDto.getCategory()),
                bookDto.getAuthorId(),
                bookDto.getAvailableCopies()).get();
        return ResponseEntity.ok().body(book);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/markAsTaken/{id}")
    public void markAsTaken(@PathVariable Long id) {
        this.bookService.markAsTaken(id);
    }

}
