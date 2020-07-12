package fr.codereviewers.back.controller;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = {"fr.codereviewers.back.controller.rest"})
public class RestExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({NotFoundException.class})
    protected ResponseStatusException handleNotFound(NotFoundException ex) {
        return new ResponseStatusException(HttpStatus.NOT_FOUND, "No data found", ex);
    }
}
