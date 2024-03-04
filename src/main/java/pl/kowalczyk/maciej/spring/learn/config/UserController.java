package pl.kowalczyk.maciej.spring.learn.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kowalczyk.maciej.spring.learn.api.exception.user.UserException;

import java.util.List;
import java.util.logging.Level;
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

        LOGGER.info("list(...) = " + users);
        return "users.html";
    }

    @GetMapping(value = "/create")
    public String createView(@RequestParam(value = "id", required = false) Long id, ModelMap modelMap) {
        LOGGER.info("createView(" + id + ")");

        modelMap.addAttribute("read", true);
        modelMap.addAttribute("userModel", new UserModel());

        String result = "manage-user.html";

        LOGGER.info("createView(...) = " + result);
        return result;
    }

    @PostMapping
    public String create(UserModel userModel, BindingResult bindingResult) throws UserException {
        LOGGER.info("create(" + userModel + ")");

        if (bindingResult.hasErrors()) {
            LOGGER.log(Level.SEVERE, "form error: " + bindingResult.getAllErrors());
            return "manage-user.html";
        }

        userService.create(userModel);

        String result = "redirect:/users";

        LOGGER.info("create(...) = " + result);
        return result;
    }

    @GetMapping(value = "/{id}")
    public String read(@PathVariable Long id, ModelMap modelMap) throws UserException {
        LOGGER.info("read(" + id + ")");

        UserModel readUserModel = userService.read(id);
        modelMap.addAttribute("userModel", readUserModel);

        String result = "manage-user.html";

        LOGGER.info("read(...) = " + null);
        return "result";
    }

    @GetMapping(value = "/update/{id}")
    public String updateView(@PathVariable Long id, ModelMap modelMap) throws UserException {
        LOGGER.info("updateView(" + id + ")");

        UserModel readUserModel = userService.read(id);

        modelMap.addAttribute("read", false);
        modelMap.addAttribute("userModel", readUserModel);

        LOGGER.info("updateView(...) = ");
        return "manage-user.html";
    }

    @PostMapping(value = "/{id}")
    public String update(UserModel userModel) throws UserException {
        LOGGER.info("update(" + userModel + ")");

        userService.update(userModel);

        String result = "redirect:/users";

        LOGGER.info("update(...) = " + result);
        return result;
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) throws UserException {
        LOGGER.info("delete(" + id + ")");

        userService.delete(id);
        String result = "redirect:/users";

        LOGGER.info("delete(...) = " + result);
        return result;
    }
}
