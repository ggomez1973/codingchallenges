package com.gamesys.timetravel.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class NoSuchPlaceException extends RuntimeException {
    public NoSuchPlaceException() {
        super("No such place");
    }
}
