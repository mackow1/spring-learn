package pl.kowalczyk.maciej.spring.learn.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kowalczyk.maciej.spring.learn.service.AuthorService;
import pl.kowalczyk.maciej.spring.learn.web.model.AuthorModel;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//@Component
@Controller
@RequestMapping(value = "/authors")
public class AuthorController {

    private static final Logger LOGGER = Logger.getLogger(AuthorController.class.getName());

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String list(ModelMap modelMap) {
        LOGGER.info("list()");

        List<AuthorModel> authorModelList = authorService.list();

        modelMap.addAttribute("authors", authorModelList);

        LOGGER.info("list(...) = ");
        return "authors.html";
    }

    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("createView()");
        LOGGER.info("createView(...) = ");
        return "create-author.html";
    }

    @PostMapping
    public String create(
            @Valid @ModelAttribute(name = "authorModel") AuthorModel authorModel, BindingResult bindingResult) {
        LOGGER.info("create(" + authorModel + ")");

        if (bindingResult.hasErrors()) {
            LOGGER.log(Level.SEVERE, "form error: " + bindingResult.getAllErrors());
            return "create-author.html";
        }

        authorService.create(authorModel);

        LOGGER.info("create(...) = ");
        return "authors.html";
    }
}
