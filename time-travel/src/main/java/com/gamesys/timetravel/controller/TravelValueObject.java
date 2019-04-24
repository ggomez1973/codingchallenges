package com.gamesys.timetravel.controller;

import java.time.LocalDateTime;

/**
 * Value Object to prevent exposing domain objects
 */
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

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TravelValueObject{" +
                "place='" + place + '\'' +
                ", date=" + date +
                '}';
    }
}
