package com.gamesys.timetravel.domain;

import com.gamesys.timetravel.controller.TravelValueObject;
import com.gamesys.timetravel.error.InvalidPersonalGalacticIdentifierException;
import com.gamesys.timetravel.error.InvalidTravelDataException;
import com.gamesys.timetravel.error.NoSuchPlaceException;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Travel {
    private static final String pgi_format_regex = "^\\D{1}\\w{4,9}";
    private final String pgi;
    private final String place;
    private final LocalDateTime date;

    private Travel(String pgi, String place, LocalDateTime date) {
        this.pgi = pgi;
        this.place = place;
        this.date = date;
    }

    public static Travel createTravel(String pgi, String place, LocalDateTime date) {
        Objects.requireNonNull(pgi, "pgi should not be null");
        Objects.requireNonNull(place, "place should not be null");
        Objects.requireNonNull(date, "date should not be null");
        if (isValidPgi(pgi)) {
            if (!place.isEmpty()) {
                return new Travel(pgi, place, date);
            } else {
                throw new NoSuchPlaceException();
            }
        } else {
            throw new InvalidPersonalGalacticIdentifierException();
        }
    }

    public static boolean isValidPgi(String pgi) {
        Objects.requireNonNull(pgi, "pgi should not be null");
        Pattern pattern = Pattern.compile(pgi_format_regex);
        Matcher matcher = pattern.matcher(pgi);
        return matcher.matches();
    }

    public static Travel fromValueObject(String pgi, TravelValueObject valueObject) {
        Objects.requireNonNull(pgi, "pgi should not be null");
        Objects.requireNonNull(valueObject, "valueObject should not be null");
        if (valueObject.getPlace() == null) {
            throw new InvalidTravelDataException("place should not be null");
        } else {
            if (valueObject.getDate() == null) {
                throw new InvalidTravelDataException("date should not be null");
            } else {
                return createTravel(pgi, valueObject.getPlace(), valueObject.getDate());
            }
        }
    }

    public final TravelValueObject toValueObject() {
        return new TravelValueObject(place, date);
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
}
