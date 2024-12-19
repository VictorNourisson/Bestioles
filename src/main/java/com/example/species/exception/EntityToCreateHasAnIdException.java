package com.example.species.exception;

public class EntityToCreateHasAnIdException extends RuntimeException {
    public EntityToCreateHasAnIdException(String message) {
        super(message);
    }
} 