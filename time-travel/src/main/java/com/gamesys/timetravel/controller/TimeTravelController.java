package com.gamesys.timetravel.controller;

import com.gamesys.timetravel.error.NoSuchTravelException;
import com.gamesys.timetravel.error.InvalidPersonalGalacticIdentifierException;
import com.gamesys.timetravel.domain.Travel;
import com.gamesys.timetravel.repository.TravelRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
    public TravelValueObject saveTravelForCharacter(@RequestBody TravelValueObject travelVO){
        try {
            Travel travel = Travel.of(travelVO);
            repository.saveTravelForCharacter(travel);
            return travelVO;
        } catch (InvalidPersonalGalacticIdentifierException e) {
            logger.info(e.getMessage());
            // Bad Request
            throw new NoSuchTravelException(); // sacar
        }
    }

    @GetMapping(value = "/{pgi}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TravelValueObject> getTravelsForCharacter(@PathVariable String pgi){
        Set<Travel> st = repository.getTravelsForCharacter(pgi).orElseThrow(() -> new NoSuchTravelException());
        return st.stream().map(travel -> travel.to()).collect(Collectors.toList());
    }

}
