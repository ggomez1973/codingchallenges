package com.gamesys.timetravel.domain;

import com.gamesys.timetravel.controller.TravelValueObject;
import com.gamesys.timetravel.error.InvalidTravelDataException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.Assert.*;

public class TravelTest {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void createTravelNullPgi() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("pgi should not be null");
        Travel travel = Travel.createTravel(null, "", null);
    }

    @Test
    public void createTravelNullPlace() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("place should not be null");
        Travel travel = Travel.createTravel("", null, null);
    }

    @Test
    public void createTravelNullDate() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("date should not be null");
        Travel travel = Travel.createTravel("", "", null);
    }

    @Test
    public void isValidPgiWithNull() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("pgi should not be null");
        Travel.isValidPgi(null);
    }

    @Test
    public void isValidPgiWithEmpty() {
        assertFalse(Travel.isValidPgi(""));
    }

    @Test
    public void isValidPgiStartsWithNumber() {
        assertFalse(Travel.isValidPgi("2invalid"));
    }

    @Test
    public void isValidPgiTooShort() {
        assertFalse(Travel.isValidPgi("shu"));
    }

    @Test
    public void isValidPgiTooLong() {
        assertFalse(Travel.isValidPgi("waytoooooolong"));
    }

    @Test
    public void isValidPgi() {
        assertTrue(Travel.isValidPgi("a1234d"));
    }

    @Test
    public void fromValueObjectWithNullPgi() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("pgi should not be null");
        Travel.fromValueObject(null, new TravelValueObject("place", LocalDateTime.now()));
    }

    @Test
    public void fromValueObjectWithNullValueObject() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("valueObject should not be null");
        Travel.fromValueObject("", null);
    }
}