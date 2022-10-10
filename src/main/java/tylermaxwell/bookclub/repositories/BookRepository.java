package tylermaxwell.bookclub.repositories;


import org.springframework.data.repository.CrudRepository;
import tylermaxwell.bookclub.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {}

