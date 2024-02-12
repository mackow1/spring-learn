package pl.kowalczyk.maciej.spring.learn.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kowalczyk.maciej.spring.learn.api.exception.author.AuthorException;
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
    public String createView(ModelMap modelMap) {
        LOGGER.info("createView()");

        modelMap.addAttribute("authorModel", new AuthorModel());

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
        return "redirect:/authors";
    }

    @GetMapping(value = "/{id}")
    public String read(@PathVariable Long id, ModelMap modelMap) throws AuthorException {
        LOGGER.info("read(" + id + ")");

        AuthorModel readAuthorModel = authorService.read(id);
        modelMap.addAttribute("authorModel", readAuthorModel);

        String result = "manage-author.html";

        LOGGER.info("read(...) = " + result);
        return result;
    }

    @GetMapping(value = "/update/{id}")
    public String updateView(@PathVariable Long id, ModelMap modelMap) throws AuthorException {
        LOGGER.info("updateView(" + id + ")");

        AuthorModel readAuthorModel = authorService.read(id);
        modelMap.addAttribute("read", false);
        modelMap.addAttribute("authorModel", readAuthorModel);

        String result = "manage-apartment.html";

        LOGGER.info("updateView(...) = " + result);
        return result;
    }

    @PostMapping(value = "/{id}")
    public String update(AuthorModel authorModel) throws AuthorException {
        LOGGER.info("update(" + authorModel + ")");

        authorService.update(authorModel);

        String result = "redirect:/authors";

        LOGGER.info("update(...) = " + result);
        return result;
    }
}
