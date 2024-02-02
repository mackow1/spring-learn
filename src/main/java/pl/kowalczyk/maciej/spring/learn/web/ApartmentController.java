package pl.kowalczyk.maciej.spring.learn.web;

import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kowalczyk.maciej.spring.learn.service.ApartmentService;
import pl.kowalczyk.maciej.spring.learn.web.model.ApartmentModel;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/apartments")
public class ApartmentController {

    private static final Logger LOGGER = Logger.getLogger(ApartmentController.class.getName());

    private final ApartmentService apartmentService;
    private final MessageSource messageSource;

    public ApartmentController(ApartmentService apartmentService, MessageSource messageSource1) {
        this.apartmentService = apartmentService;
        this.messageSource = messageSource1;
    }

    @GetMapping
//    public String list(String name, Integer price) {
    public String list(ApartmentModel apartmentModel, ModelMap modelMap) {
//        LOGGER.info("list(" + name + ", " + price + ") ");
        LOGGER.info("list(" + apartmentModel + ") ");

        List<ApartmentModel> apartmentModels = apartmentService.list();

        String result = null;
        modelMap.addAttribute("hello", "greetings from backend");
        modelMap.addAttribute("apartments", apartmentModels);

        LOGGER.info("list(...) = " + result);
        return "apartments.html";
    }

    @GetMapping(value = "/create")
    public String createView(ModelMap modelMap) {
        LOGGER.info("createView()");

        modelMap.addAttribute("apartmentModel", new ApartmentModel());

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

        LOGGER.info("create(...) = ");
//        return "apartments.html";
        return "redirect:/apartments";
    }

    public ApartmentModel read(Long id) {
        LOGGER.info("read(" + id + ")");

        apartmentService.read(id);
        ApartmentModel result = null;

        LOGGER.info("read(...) = " + result);
        return result;
    }
}
