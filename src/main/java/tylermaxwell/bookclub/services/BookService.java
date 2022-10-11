package tylermaxwell.bookclub.services;

import org.springframework.stereotype.Service;
import tylermaxwell.bookclub.models.Book;
import tylermaxwell.bookclub.repositories.BookRepository;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public void create(Book book) {
        bookRepository.save(book);
    }

    public List<Book> getAll() {
        return (List<Book>) bookRepository.findAll();
    }
}
