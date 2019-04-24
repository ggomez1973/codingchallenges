package com.gamesys.timetravel.controller;

public class TravelValueObject {
    private String pgi;
    private String place;
    private String date;

    public TravelValueObject() {
    }

    public TravelValueObject(String pgi, String place, String date) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
