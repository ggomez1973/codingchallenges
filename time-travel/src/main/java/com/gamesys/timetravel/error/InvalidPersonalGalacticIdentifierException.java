package com.gamesys.timetravel.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidPersonalGalacticIdentifierException extends RuntimeException {
    public InvalidPersonalGalacticIdentifierException() {
        super("Invalid Personal Galactic Identifier");
    }
}
