package pl.kowalczyk.maciej.spring.learn.config;

import org.springframework.stereotype.Controller;

import java.util.logging.Logger;

@Controller
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public String create() {
        LOGGER.info("create()");

        String result = null;

        LOGGER.info("create(...) = " + result);
        return result;
    }
}
