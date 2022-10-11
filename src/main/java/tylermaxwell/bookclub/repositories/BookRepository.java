package tylermaxwell.bookclub.repositories;


import org.springframework.data.repository.CrudRepository;
import tylermaxwell.bookclub.models.Book;
import tylermaxwell.bookclub.models.User;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
    Book findByIdIs(Long id);
    List<Book> findAllByUsers(User user);
    List<Book> findByUsersNotContains(User user);

}

