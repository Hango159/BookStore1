package hh.bookstore.sof3.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import hh.bookstore.sof3.domain.Category;
import hh.bookstore.sof3.domain.CategoryRepository;

@Controller
public class CategoryController {
    private final CategoryRepository repository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.repository = categoryRepository;
    }

    @GetMapping("/categorylist")
    public String getCategories(Model model) {
        model.addAttribute("categories", repository.findAll());
        return "categorylist"; // categorylist.html
    }

    @GetMapping("/category/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory"; // addcategory.html
    }

    @PostMapping("/category/save")
    public String save(Category category) {
        repository.save(category);
        return "redirect:/categorylist";
    }
}
