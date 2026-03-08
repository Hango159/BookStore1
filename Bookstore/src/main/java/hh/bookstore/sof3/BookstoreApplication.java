package hh.bookstore.sof3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hh.bookstore.sof3.domain.Book;
import hh.bookstore.sof3.domain.BookRepository;
import hh.bookstore.sof3.domain.Category;
import hh.bookstore.sof3.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner seedBooks(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return args -> {
			log.info("Save some sample categories");
			Category category1 = new Category("Philosophy");
			categoryRepository.save(category1);
			Category category2 = new Category("Fantasy");
			categoryRepository.save(category2);
			Category category3 = new Category("Action");
			categoryRepository.save(category3);

			log.info("Save some sample books");
			bookRepository
					.save(new Book("The Myth of Sisyphus", "Albert Camus", 1942, "9780525564454", 12.99F, category1));
			bookRepository
					.save(new Book("The Sickness unto Death", "Søren Kierkegaard", 1849, "9781324091240", 10.99F,
							category1));

			log.info("Fetch all the books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

			log.info("Fetch all the categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}
		};
	}

}
