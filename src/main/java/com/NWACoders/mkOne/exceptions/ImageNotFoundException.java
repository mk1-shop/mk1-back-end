package com.NWACoders.mkOne.exceptions;

//This handles image errors when going to the database
public class ImageNotFoundException extends RuntimeException {
    public ImageNotFoundException(String message) {
        super(message);
    }
}
