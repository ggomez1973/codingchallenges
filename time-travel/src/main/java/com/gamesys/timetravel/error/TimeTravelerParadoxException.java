package com.gamesys.timetravel.error;

public class TimeTravelerParadoxException extends RuntimeException {
    public TimeTravelerParadoxException() {
        super("You can't travel to the same place and date twice");
    }
}
