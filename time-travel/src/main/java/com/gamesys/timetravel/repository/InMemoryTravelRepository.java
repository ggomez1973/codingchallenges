package com.gamesys.timetravel.repository;

import com.gamesys.timetravel.domain.Travel;
import com.gamesys.timetravel.error.InvalidPersonalGalacticIdentifierException;
import com.gamesys.timetravel.error.TimeTravelerParadoxException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public final class InMemoryTravelRepository implements TravelRepository {

    private ConcurrentHashMap<String, Set<Travel>> travels;

    private InMemoryTravelRepository() {
        this.travels = new ConcurrentHashMap<>();
    }

    public static InMemoryTravelRepository createInMemoryTravelRepository() {
        return new InMemoryTravelRepository();
    }

    @Override
    public Optional<Set<Travel>> getTravelsForCharacter(String pgi){
        Objects.requireNonNull(pgi, "pgi");
        if(Travel.isValidPgi(pgi)) {
            return Optional.ofNullable(travels.get(pgi));
        } else {
            throw new InvalidPersonalGalacticIdentifierException();
        }
    }

    @Override
    public void saveTravelForCharacter(Travel travel) {
        Objects.requireNonNull(travel, "travel");
        Set<Travel> currentTravels = travels.get(travel.getPgi());
        if(currentTravels == null){
            currentTravels = new HashSet<>();
            currentTravels.add(travel);
            travels.put(travel.getPgi(), currentTravels);
        } else {
            boolean successfullyAdded = currentTravels.add(travel);
            if(!successfullyAdded) {
                throw new TimeTravelerParadoxException();
            }
        }
    }
}
