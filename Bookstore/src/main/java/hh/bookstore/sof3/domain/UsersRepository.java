package hh.bookstore.sof3.domain;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<AppUsers, Long> {
    AppUsers findByUsername(String username);
}
