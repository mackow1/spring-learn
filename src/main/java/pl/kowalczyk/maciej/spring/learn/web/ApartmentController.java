package pl.kowalczyk.maciej.spring.learn.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kowalczyk.maciej.spring.learn.service.ApartmentService;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/apartments")
public class ApartmentController {

    private static final Logger LOGGER = Logger.getLogger(ApartmentController.class.getName());

    private ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping
//    public String list(String name, Integer price) {
    public String list(ApartmentModel apartmentModel, ModelMap modelMap) {
//        LOGGER.info("list(" + name + ", " + price + ") ");
        LOGGER.info("list(" + apartmentModel + ") ");

        String result = null;
        modelMap.addAttribute("hello", "greetings from backend");
//        modelMap.addAttribute("apartments", )

        LOGGER.info("list(...) = " + result);
        return "apartments.html";
    }

    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("createView()");
        LOGGER.info("createView(...) = " + null);
        return "create-apartment.html";
    }

    @PostMapping
    public String create(
            @Valid ApartmentModel apartmentModel, BindingResult bindingResult) {
        LOGGER.info("create(" + apartmentModel + ")");

        if (bindingResult.hasErrors()) {
            LOGGER.log(Level.SEVERE, "form error: " + bindingResult.getAllErrors());
            return "create-apartment.html";
        }

        apartmentService.create(apartmentModel);
        String result = null;

        LOGGER.info("create(...) = " + result);
        return "apartments.html";
    }

    public ApartmentModel read(ApartmentModel apartmentModel) {
        LOGGER.info("read()");

        apartmentService.read(apartmentModel);
        ApartmentModel result = null;

        LOGGER.info("read(...) = " + result);
        return result;
    }
}
