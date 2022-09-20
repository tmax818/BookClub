package tylermaxwell.bookclub.repositories;

import org.springframework.data.repository.CrudRepository;
import tylermaxwell.bookclub.models.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
}
