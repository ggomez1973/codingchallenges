package com.gamesys.timetravel.controller;

import java.time.LocalDateTime;

/**
 * Value Object to prevent exposing domain objects
 */
public class TravelValueObject {
    private String pgi;
    private String place;
    private LocalDateTime date;

    public TravelValueObject() {
    }

    public TravelValueObject(String pgi, String place, LocalDateTime date) {
        this.pgi = pgi;
        this.place = place;
        this.date = date;
    }

    public String getPgi() {
        return pgi;
    }

    public void setPgi(String pgi) {
        this.pgi = pgi;
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
}
