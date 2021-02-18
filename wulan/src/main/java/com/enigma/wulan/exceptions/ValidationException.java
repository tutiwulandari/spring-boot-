package com.enigma.wulan.exceptions;

public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String message;

    public ValidationException(String msg) {
        this.message = msg;
    }

    public String getMsg() {
        return message;
    }

}
