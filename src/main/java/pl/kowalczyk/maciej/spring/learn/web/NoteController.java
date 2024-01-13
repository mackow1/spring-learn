package pl.kowalczyk.maciej.spring.learn.web;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

//@Component
@Controller
@RequestMapping(value="/notes")
public class NoteController {

    private static final Logger LOGGER = Logger.getLogger(NoteController.class.getName());

    @GetMapping
    public String list() {
        LOGGER.info("list()");
        LOGGER.info("list(...) = ");
        return "notes.html";
    }
}
