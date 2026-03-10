package hh.bookstore.sof3.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hh.bookstore.sof3.domain.Book;
import hh.bookstore.sof3.domain.BookRepository;

@RestController
public class BookRestController {
    private final BookRepository repository;

    public BookRestController(BookRepository bookRepository) {
        this.repository = bookRepository;
    }

    @GetMapping("/books")
    public @ResponseBody List<Book> bookListRest() {
        return (List<Book>) repository.findAll();
    }

    @GetMapping("/books/{id}")
    public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {
        return repository.findById(bookId).orElse(null);
    }
}
