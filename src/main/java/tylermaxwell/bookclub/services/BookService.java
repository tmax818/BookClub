package tylermaxwell.bookclub.services;

import org.springframework.stereotype.Service;
import tylermaxwell.bookclub.models.Book;
import tylermaxwell.bookclub.models.User;
import tylermaxwell.bookclub.repositories.BookRepository;
import tylermaxwell.bookclub.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    //! CREATE
    public void create(Book book) {
        bookRepository.save(book);
    }

    //! READ ALL
    public List<Book> getAll() {
        return (List<Book>) bookRepository.findAll();

    }
    //! READ ONE
    public Book getOne(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    //
    public Book findBook(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    public void update(Book book) {
        bookRepository.save(book);
    }

    public void destroy(Book book) {
        bookRepository.delete(book);
    }

    public List<Book> getBooksVotedByUser(User user) {
        return bookRepository.findAllByUsers(user);
    }
}
