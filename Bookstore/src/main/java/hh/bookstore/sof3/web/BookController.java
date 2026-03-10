package hh.bookstore.sof3.web;

import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import hh.bookstore.sof3.domain.Book;
import hh.bookstore.sof3.domain.BookRepository;
import hh.bookstore.sof3.domain.CategoryRepository;

@Controller
public class BookController {

    private final BookRepository repository;
    private final CategoryRepository cRepository;

    public BookController(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.repository = bookRepository;
        this.cRepository = categoryRepository;
    }

    @GetMapping("/booklist")
    public String getBooks(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist"; // booklist.html
    }

    @GetMapping("/addbook")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categories", cRepository.findAll());
        return "addbook"; // addbook.html
    }

    @PostMapping("/save")
    public String save(Book book) {
        repository.save(book);
        return "redirect:booklist";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        Optional<Book> bookOpt = repository.findById(id);
        if (bookOpt.isEmpty()) {
            return "redirect:/booklist";
        }
        model.addAttribute("book", bookOpt.get());
        model.addAttribute("categories", cRepository.findAll());
        return "editbook"; // editbook.html
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteBook(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:../booklist";
    }

    @GetMapping("login")
    public String login() {
        return "login"; // login.html
    }

}
