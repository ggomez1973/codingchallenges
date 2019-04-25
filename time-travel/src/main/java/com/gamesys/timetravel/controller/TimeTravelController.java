package com.gamesys.timetravel.controller;

import com.gamesys.timetravel.domain.Travel;
import com.gamesys.timetravel.error.NoSuchTravelerException;
import com.gamesys.timetravel.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(TimeTravelController.BASE_URL)
public class TimeTravelController {
    public static final String BASE_URL = "/api/v1/travelers";

    @Autowired
    private TravelRepository repository;

    @PostMapping(value = "/{pgi}/travels", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TravelValueObject saveTravelForCharacter(@PathVariable String pgi, @RequestBody TravelValueObject travelVO){
        Travel travel = Travel.fromValueObject(pgi, travelVO);
        repository.saveTravelForCharacter(travel);
        return travelVO;
    }

    @GetMapping(value = "/{pgi}/travels", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TravelValueObject> getTravelsForCharacter(@PathVariable String pgi){
        Set<Travel> travelsSet = repository.getTravelsForCharacter(pgi).orElseThrow(NoSuchTravelerException::new);
        return travelsSet.stream().map(Travel::toValueObject).collect(Collectors.toList());
    }
}
