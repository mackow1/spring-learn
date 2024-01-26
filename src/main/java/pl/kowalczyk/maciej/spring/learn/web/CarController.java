package pl.kowalczyk.maciej.spring.learn.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kowalczyk.maciej.spring.learn.service.CarService;
import pl.kowalczyk.maciej.spring.learn.web.model.CarModel;

import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/cars")
public class CarController {

    private static final Logger LOGGER = Logger.getLogger(CarController.class.getName());

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String list(ModelMap modelMap) {
        LOGGER.info("list()");

        List<CarModel> carModels = carService.list();

        modelMap.addAttribute("cars", carModels);

        LOGGER.info("list(...) = ");
        return "cars.html";
    }

    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("createView()");

        String result = "/create-car.html";

        LOGGER.info("createView(...) = " + result);
        return result;
    }

    @PostMapping
    public String create(CarModel carModel) {
        LOGGER.info("create(" + carModel + ")");

        carService.create(carModel);
        String result = "cars.html";

        LOGGER.info("create(...) = " + result);
        return result;
    }
}
