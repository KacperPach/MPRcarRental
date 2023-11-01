package org.carRental.execption;

import lombok.Getter;

public class ValidationException extends RuntimeException{
    @Getter private final String field;
    @Getter private final String message;

    public ValidationException (String field, String message) {
        super(message);
        this.field = field;
        this.message =  message;
    }
}
