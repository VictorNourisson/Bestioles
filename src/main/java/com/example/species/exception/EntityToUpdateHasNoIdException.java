package com.example.species.exception;

public class EntityToUpdateHasNoIdException extends RuntimeException {
    public EntityToUpdateHasNoIdException(String message) {
        super(message);
    }
} 