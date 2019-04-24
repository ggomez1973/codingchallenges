package com.gamesys.timetravel.controller;

import com.gamesys.timetravel.controller.exceptions.NoSuchTravelException;
import com.gamesys.timetravel.domain.InvalidPersonalGalacticIdentifierException;
import com.gamesys.timetravel.domain.Travel;
import com.gamesys.timetravel.repository.TravelRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@RestController
@RequestMapping(TimeTravelController.BASE_URL)
public class TimeTravelController {
    public static final Logger logger = Logger.getLogger(TimeTravelController.class.getName());
    public static final String BASE_URL = "/api/v1/travels";
    private final TravelRepository repository;

    public TimeTravelController(TravelRepository repository) {
        this.repository = repository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Travel saveTravelForCharacter(@RequestBody TravelValueObject valueObject){
        try {
            Travel travel = Travel.of(valueObject);
            repository.saveTravelForCharacter(travel);
            return travel;
        } catch (InvalidPersonalGalacticIdentifierException e) {
            logger.info(e.getMessage());
            // Bad Request
            throw new NoSuchTravelException(); // sacar
        }
    }

    @GetMapping("/{id}")
    public Set<Travel> getTravelForCharacter(@PathVariable String id){
        return repository.getTravelsForCharacter(id).orElseThrow(() -> new NoSuchTravelException());
    }

}
