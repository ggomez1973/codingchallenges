package com.gamesys.timetravel.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class TimeTravelerParadoxException extends RuntimeException {
    public TimeTravelerParadoxException() {
        super("You can't travel to the same place and date twice");
    }
}
