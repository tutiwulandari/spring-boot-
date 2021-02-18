package com.enigma.wulan.exceptions;

import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends ApplicationException {

    public EntityNotFoundException() {
        super(HttpStatus.NOT_FOUND, "error." + HttpStatus.NOT_FOUND.value() + ".entity");


    }
}
