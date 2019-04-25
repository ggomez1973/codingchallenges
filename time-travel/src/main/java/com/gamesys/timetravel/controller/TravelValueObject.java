package com.gamesys.timetravel.controller;

import java.time.LocalDateTime;

public class TravelValueObject {
    private String place;
    private LocalDateTime date;

    public TravelValueObject() {
    }

    public TravelValueObject(String place, LocalDateTime date) {
        this.place = place;
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
