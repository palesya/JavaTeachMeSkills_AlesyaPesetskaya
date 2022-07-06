package com.exceptions;

public class SaveUserException extends RuntimeException{

    public SaveUserException(String message) {
        super(message);
    }
}
