package com.mykola.pagesmanager.api.controller;

import com.mykola.pagesmanager.exception.NotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller of exceptions
 */
@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(value = NotFoundException.class)
    public ModelAndView exception(NotFoundException exception, WebRequest request) {
        ModelAndView modelAndView = new ModelAndView("image/exception/notFoundObject");
        modelAndView.addObject("errorMessage", exception.getMessage());
        return modelAndView;
    }
}
