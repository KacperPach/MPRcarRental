package org.carRental.execption;

import lombok.Getter;

public class CarNotFoundException  extends RuntimeException{
    @Getter
    private final String message;

    public CarNotFoundException (String message) {
        super(message);
        this.message =  message;
    }
}
