package pl.kowalczyk.maciej.spring.learn.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import pl.kowalczyk.maciej.spring.learn.api.exception.apartment.ApartmentException;
import pl.kowalczyk.maciej.spring.learn.api.exception.author.AuthorException;

import java.util.logging.Logger;

@ControllerAdvice
public class ExceptionHandlingController {

    private static final Logger LOGGER = Logger.getLogger(ExceptionHandlingController.class.getName());

    public static final String DEFAULT_ERROR_VIEW = "error";

    //    @ExceptionHandler(Exception.class)
    public ModelAndView handleException() {
        LOGGER.info("handleException()");

        LOGGER.info("handleException(...) = ");
        return null;
    }

    @ExceptionHandler(value = ApartmentException.class)
    public ModelAndView apartmentErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        LOGGER.info("apartmentErrorHandler(" + req + ", " + e + ")");

        // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it - like the OrderNotFoundException example
        // at the start of this post.
        // AnnotationUtils is a Spring Framework utility class.
        if (AnnotationUtils.findAnnotation
                (e.getClass(), ResponseStatus.class) != null)
            throw e;

        // Otherwise setup and send the user to a default error-view.
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);

        LOGGER.info("apartmentErrorHandler(...) = " + mav);
        return mav;
    }

    @ExceptionHandler(value = AuthorException.class)
    public ModelAndView authorErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        LOGGER.info("authorErrorHandler(" + req + ", " + e + ")");

        // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it - like the OrderNotFoundException example
        // at the start of this post.
        // AnnotationUtils is a Spring Framework utility class.
        if (AnnotationUtils.findAnnotation
                (e.getClass(), ResponseStatus.class) != null)
            throw e;

        // Otherwise setup and send the user to a default error-view.
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);

        LOGGER.info("authorErrorHandler(...) = " + mav);
        return mav;
    }
}
