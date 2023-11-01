package org.carRental.execption;

import lombok.Getter;

public class ClientNotFoundException extends RuntimeException{
    @Getter
    private final String message;

    public ClientNotFoundException (String message) {
        super(message);
        this.message =  message;
    }
}
