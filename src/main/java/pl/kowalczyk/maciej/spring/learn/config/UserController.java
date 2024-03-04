package pl.kowalczyk.maciej.spring.learn.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String list(UserModel userModel, ModelMap modelMap) {
        LOGGER.info("list(" + userModel + ")");

        List<UserModel> users = userService.list();
        modelMap.addAttribute("users", users);

        LOGGER.info("list(...)");
        return "users.html";
    }

    public String create() {
        LOGGER.info("create()");

        String result = null;

        LOGGER.info("create(...) = " + result);
        return result;
    }
}
