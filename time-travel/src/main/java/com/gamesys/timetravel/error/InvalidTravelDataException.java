package com.gamesys.timetravel.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidTravelDataException extends RuntimeException {
    public InvalidTravelDataException(String message) {
        super(message);
    }
}
