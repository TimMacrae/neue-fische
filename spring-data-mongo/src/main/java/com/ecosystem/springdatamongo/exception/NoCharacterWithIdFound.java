package com.ecosystem.springdatamongo.exception;

public class NoCharacterWithIdFound extends RuntimeException {
    public NoCharacterWithIdFound(String id) {
        super("No character with id " + id + " found");
    }
}
