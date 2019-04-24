package com.gamesys.timetravel.repository;

import com.gamesys.timetravel.domain.Travel;
import com.gamesys.timetravel.error.TimeTravelerParadoxException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

@Component
public final class InMemoryTravelRepository implements TravelRepository {
    public static final Logger logger = Logger.getLogger(InMemoryTravelRepository.class.getName());
    private ConcurrentHashMap<String, Set<Travel>> travels;

    private InMemoryTravelRepository() {
        this.travels = new ConcurrentHashMap<String, Set<Travel>>();
    }

    public static InMemoryTravelRepository createInMemoryTravelRepository() {
        return new InMemoryTravelRepository();
    }

    @Override
    public Optional<Set<Travel>> getTravelsForCharacter(String pgi){
        return Optional.ofNullable(travels.get(pgi));
    }

    @Override
    public void saveTravelForCharacter(Travel travel) {
        Set set = travels.get(travel.getPgi());
        if(set == null){
            set = new HashSet<Travel>();
            travels.put(travel.getPgi(), set);
        }
        if(!set.add(travel)){
            throw new TimeTravelerParadoxException();
        }
    }
}
