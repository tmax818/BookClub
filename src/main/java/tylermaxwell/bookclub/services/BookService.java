package tylermaxwell.bookclub.services;

import org.springframework.stereotype.Service;
import tylermaxwell.bookclub.models.Book;
import tylermaxwell.bookclub.models.User;
import tylermaxwell.bookclub.repositories.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> allBooks(){
        return repo.findAll();
    }

    public void createBook(Book book, User user) {
        book.setUser(user);
        repo.save(book);
    }

    public Book findBook(Long id) {
        Optional<Book> optionalBook = repo.findById(id);
        return optionalBook.orElse(null);
    }

    public void updateBook(Book book, User user) {
        book.setUser(user);
        repo.save(book);
    }

    public void destroy(Long id){
        repo.deleteById(id);
    }
}
