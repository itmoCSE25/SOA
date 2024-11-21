package com.yuiko.soa.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotFoundException extends IllegalArgumentException {

    public NotFoundException(String s) {
        super(s);
    }
}
