package fr.codereviewers.back.core.exception;

import javassist.NotFoundException;

public class ArticleNotFoundException extends NotFoundException {
    public ArticleNotFoundException(String msg) {
        super(msg);
    }

    public ArticleNotFoundException(String msg, Exception e) {
        super(msg, e);
    }
}
