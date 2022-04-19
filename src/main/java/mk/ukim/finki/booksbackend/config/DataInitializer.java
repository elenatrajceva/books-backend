package mk.ukim.finki.booksbackend.config;

import mk.ukim.finki.booksbackend.model.Author;
import mk.ukim.finki.booksbackend.model.Book;
import mk.ukim.finki.booksbackend.model.Category;
import mk.ukim.finki.booksbackend.model.Country;
import mk.ukim.finki.booksbackend.repository.AuthorRepository;
import mk.ukim.finki.booksbackend.repository.BookRepository;
import mk.ukim.finki.booksbackend.repository.CountryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    private final BookRepository bookRepository;

    public DataInitializer(AuthorRepository authorRepository, CountryRepository countryRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void initDate() {
        //Countries
        Country macedonia = new Country("Macedonia", "Europe");
        Country usa = new Country("USA", "North America");
        Country france = new Country("France", "Europe");
        Country england = new Country("England", "Europe");
        countryRepository.save(macedonia);
        countryRepository.save(usa);
        countryRepository.save(france);
        countryRepository.save(england);

        //Authors
        Author test1 = new Author("PM Narendra", "Modi", macedonia);
        Author test2 = new Author("Suresh", "Raina", usa);
        Author test3 = new Author("Meghan", "Markle", france);
        Author test4 = new Author("Kalki", "Koechlin", england);
        Author test5 = new Author("Shakoor", "Rather", macedonia);
        Author test6 = new Author("Neena", "Gupta", usa);
        authorRepository.save(test1);
        authorRepository.save(test2);
        authorRepository.save(test3);
        authorRepository.save(test4);
        authorRepository.save(test5);
        authorRepository.save(test6);

        //Books
        Book book1 = new Book("The Braille edition of the book Exam Warriors", Category.CLASSICS, test1, 15);
        Book book2 = new Book("Believe-What Life and Cricket Taught Me", Category.BIOGRAPHY, test2, 10);
        Book book3 = new Book("The Bench", Category.FANTASY, test3, 40);
        Book book4 = new Book("Elephant in the Womb", Category.THRILLER, test4, 30);
        Book book5 = new Book("Life in the Clock Tower Valley", Category.NOVEL, test5, 30);
        Book book6 = new Book("Sach Kahun Toh", Category.DRAMA, test6, 30);
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
        bookRepository.save(book5);
        bookRepository.save(book6);
    }
}
