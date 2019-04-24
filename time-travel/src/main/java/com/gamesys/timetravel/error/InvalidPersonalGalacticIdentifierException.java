package com.gamesys.timetravel.error;

public class InvalidPersonalGalacticIdentifierException extends RuntimeException {
    public InvalidPersonalGalacticIdentifierException() {
        super("Personal Galactic Identifier should be alphanumeric, always starts with a letter, between\n" +
                "5-10 characters long");
    }
}
