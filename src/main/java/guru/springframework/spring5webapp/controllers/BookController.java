package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// this is a Spring stereotype
@Controller
public class BookController {
    private final BookRepository bookRepository;
// when spring instantiates this, it will inject an instance of that bookrepository
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());

        //this "books/list" is showing where under templates and what file(template) to use
        //where: books directory under resources/templates directory
        //what: list.html
        return "books/list";
    }
}
