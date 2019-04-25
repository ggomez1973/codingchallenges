package com.gamesys.timetravel.repository;

import com.gamesys.timetravel.controller.TravelValueObject;
import com.gamesys.timetravel.domain.Travel;
import com.gamesys.timetravel.error.InvalidPersonalGalacticIdentifierException;
import com.gamesys.timetravel.error.TimeTravelerParadoxException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;

public class InMemoryTravelRepositoryTest {

    TravelRepository travelRepository;

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        travelRepository = InMemoryTravelRepository.createInMemoryTravelRepository();
    }

    @Test
    public void saveTravelForCharacterNull() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("travel should not be null");
        travelRepository.saveTravelForCharacter(null);
    }

    @Test
    public void saveTravelForCharacterToSamePlaceAndTime() {
        LocalDateTime date = LocalDateTime.now();
        Travel travel = Travel.createTravel("aValidPgi", "London", date);
        travelRepository.saveTravelForCharacter(travel);
        thrown.expect(TimeTravelerParadoxException.class);
        thrown.expectMessage("You can't travel to the same place and date twice");
        travelRepository.saveTravelForCharacter(travel);
    }

    @Test
    public void saveTravelForCharacter() {
        Travel travel = Travel.createTravel("aValidPgi", "London", LocalDateTime.now());
        travelRepository.saveTravelForCharacter(travel);
        Optional<Set<Travel>> results = travelRepository.getTravelsForCharacter("aValidPgi");
        assertNotNull(results.get());
        assertEquals(results.get().size(),1);
    }

    @Test
    public void getTravelsForCharacterDoesNotExist() {
        Optional<Set<Travel>> results = travelRepository.getTravelsForCharacter("newPgi");
        assertFalse(results.isPresent());
    }

    @Test
    public void getTravelsForCharacterWithInvalidPgi() {
        thrown.expect(InvalidPersonalGalacticIdentifierException.class);
        thrown.expectMessage("Invalid Personal Galactic Identifier");
        Optional<Set<Travel>> results = travelRepository.getTravelsForCharacter("2invalidPgi");
    }

}