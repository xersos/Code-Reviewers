package fr.codereviewers.back.shared.exception;

import javassist.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(String msg) {
        super(msg);
    }

    public UserNotFoundException(String msg, Exception e) {
        super(msg, e);
    }
}
