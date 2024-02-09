package pl.kowalczyk.maciej.spring.learn.web;

import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kowalczyk.maciej.spring.learn.api.exception.ApartmentException;
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
    public String createView(@RequestParam(value = "id", required = false) Long id, ModelMap modelMap) {
        LOGGER.info("createView(" + id + ")");

        modelMap.addAttribute("read", true);
        modelMap.addAttribute("apartmentModel", new ApartmentModel());

        LOGGER.info("createView(...) = " + id);
        return "manage-apartment.html";
    }

    @PostMapping
    public String create(
            @Valid ApartmentModel apartmentModel, BindingResult bindingResult) throws ApartmentException {
        LOGGER.info("create(" + apartmentModel + ")");

        if (bindingResult.hasErrors()) {
            LOGGER.log(Level.SEVERE, "form error: " + bindingResult.getAllErrors());
            return "manage-apartment.html";
        }

        apartmentService.create(apartmentModel);

        LOGGER.info("create(...) = ");
//        return "apartments.html";
        return "redirect:/apartments";
    }

    @GetMapping(value = "/{id}")
    public String read(@PathVariable Long id, ModelMap modelMap) throws ApartmentException {
        LOGGER.info("read(" + id + ")");

        ApartmentModel readApartmentModel = apartmentService.read(id);
        modelMap.addAttribute("apartmentModel", readApartmentModel);

        String result = "details-apartment.html";

        LOGGER.info("read(...) = " + null);
        return "result";
    }

    @GetMapping(value = "/update/{id}")
    public String updateView(@PathVariable Long id, ModelMap modelMap) throws ApartmentException {
        LOGGER.info("updateView(" + id + ")");

        ApartmentModel readApartmentModel = apartmentService.read(id);

        modelMap.addAttribute("read", false);
        modelMap.addAttribute("apartmentModel", readApartmentModel);

        LOGGER.info("updateView(...) = ");
        return "manage-apartment.html";
    }

    @PostMapping(value = "/{id}")
    public String update(ApartmentModel apartmentModel) throws ApartmentException {
        LOGGER.info("update(" + apartmentModel + ")");

        apartmentService.update(apartmentModel);

        String result = "redirect:/apartments";

        LOGGER.info("update(...) = " + result);
        return result;
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) throws ApartmentException {
        LOGGER.info("delete(" + id + ")");

        apartmentService.delete(id);
        String result = "redirect:/apartments";

        LOGGER.info("delete(...) = " + result);
        return result;
    }
}
