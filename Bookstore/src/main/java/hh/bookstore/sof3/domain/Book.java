package hh.bookstore.sof3.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private int publishedYear;
    private String isbn;
    private float price;

    @JsonIgnoreProperties("books")
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    public Book() {
        title = null;
        author = null;
        publishedYear = 0;
        isbn = null;
        price = 0.0F;
        category = null;
    }

    public Book(String title, String author, int publishedYear, String isbn, float price, Category category) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public float getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        String categoryName = (category != null) ? category.getName() : null;
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publishedYear=" + publishedYear
                + ", isbn=" + isbn + ", price=" + price + ", category=" + categoryName + "]";
    }
}
