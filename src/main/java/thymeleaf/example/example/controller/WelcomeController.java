package thymeleaf.example.example.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import thymeleaf.example.example.domain.Book;

import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {

    @Value("${welcome.message}")
    private String message;


    private List<String> tasks = Arrays.asList("fa teme","gateste", "spala masina", "cumpara masina");

    private List<Book> emptyList = Arrays.asList();
    private List<Book> bookList = Arrays.asList(new Book("Asong", "Martin"),
            new Book("Lipan", "Bogdan"),
            new Book("Carte3", "Marius"));

    @GetMapping("/")
    public String getMessage(Model model) {
         model.addAttribute("message", message);
         model.addAttribute("tasks", tasks);
         return "welcome";
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookList);
        return "books";
    }



}
