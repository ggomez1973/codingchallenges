package com.gamesys.timetravel.domain;

import com.gamesys.timetravel.controller.TravelValueObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Travel {
    private static final String regex = "^\\D{1}\\w{4,9}";
    private final String pgi;
    private final String place;
    private final LocalDateTime date;

    private Travel(String pgi, String place, LocalDateTime date) {
        this.pgi = pgi;
        this.place = place;
        this.date = date;
    }

    public static Travel createTravel(String pgi, String place, LocalDateTime date) throws InvalidPersonalGalacticIdentifierException {
        Objects.requireNonNull(pgi, "pgi");
        Objects.requireNonNull(place, "place");
        Objects.requireNonNull(date, "date");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pgi);
        if(matcher.matches()){
            return new Travel(pgi, place, date);
        } else {
            throw new InvalidPersonalGalacticIdentifierException();
        }
    }

    public static Travel of(TravelValueObject valueObject) {
        LocalDateTime date = LocalDateTime.parse(valueObject.getDate(), DateTimeFormatter.ISO_DATE_TIME);
        return createTravel(valueObject.getPgi(),valueObject.getPlace(), date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Travel travel = (Travel) o;
        return pgi.equals(travel.pgi) &&
                place.equals(travel.place) &&
                date.equals(travel.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pgi, place, date);
    }

    public String getPgi() {
        return pgi;
    }

    public String getPlace() {
        return place;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "pgi='" + pgi + '\'' +
                ", place='" + place + '\'' +
                ", date=" + date +
                '}';
    }
}
