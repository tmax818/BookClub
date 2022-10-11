package tylermaxwell.bookclub.repositories;

import org.springframework.data.repository.CrudRepository;
import tylermaxwell.bookclub.models.Book;
import tylermaxwell.bookclub.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findAll();
    User findByIdIs(Long id);
    List<User> findAllByBooks(Book book);
    List<User> findByBooksNotContains(Book book);
}
