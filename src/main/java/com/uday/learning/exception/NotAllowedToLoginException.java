package com.uday.learning.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class NotAllowedToLoginException extends RuntimeException {
    public NotAllowedToLoginException(String msg) {
        super(msg);
    }
}
