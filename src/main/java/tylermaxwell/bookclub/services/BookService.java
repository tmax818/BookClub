package tylermaxwell.bookclub.services;

import org.springframework.stereotype.Service;
import tylermaxwell.bookclub.models.Book;
import tylermaxwell.bookclub.repositories.BookRepository;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> allBooks(){
        return repo.findAll();
    }

    public void createBook(Book book) { repo.save(book);
    }
}
