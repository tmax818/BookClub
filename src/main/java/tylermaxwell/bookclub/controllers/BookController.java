package tylermaxwell.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tylermaxwell.bookclub.models.Book;
import tylermaxwell.bookclub.models.User;
import tylermaxwell.bookclub.services.BookService;
import tylermaxwell.bookclub.services.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    // CREATE
    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book, Model model, HttpSession session){
        List<Book> books = bookService.allBooks();
        User user = (User) session.getAttribute("user");
        model.addAttribute("books", books);
        model.addAttribute("user", user);

        return "/books/new.jsp";
    }

    @PostMapping("/books")
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model, HttpSession session) {
        System.out.println(book);
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        if (result.hasErrors()) {
            List<Book> books = bookService.allBooks();
            model.addAttribute("books", books);
            return "/books/new.jsp";
        } else {
            book.setUser(user);
            bookService.createBook(book);
            return "redirect:/books";
        }
    }

    // READ ALL

    @GetMapping("/books")
    public String books(@ModelAttribute("Book") Book book, Model model, HttpSession session){
        List<Book> books = bookService.allBooks();
        Long id = (Long)session.getAttribute("userId");
        User user = userService.findById(id);
        model.addAttribute("books", books);
        model.addAttribute("user", user);
        session.setAttribute("user", user);
        return "books/index.jsp";

    }
}
