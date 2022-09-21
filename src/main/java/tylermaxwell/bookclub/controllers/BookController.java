package tylermaxwell.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/books/{id}")
    public String show_book(@PathVariable("id") Long id, Model model){
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "books/show.jsp";
    }

    @GetMapping("/books/edit/{id}")
    public String edit_book(@PathVariable("id") Long id, Model model){
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "books/edit.jsp";
    }

    @RequestMapping(value = "/books/{id}", method=RequestMethod.PUT)
    public String update_book(@Valid @ModelAttribute("book") Book book, BindingResult result){
        if (result.hasErrors()) {
            return "/books/edit.jsp";
        } else {
            bookService.updateBook(book);
            return "redirect:/books";
        }
    }
}
