package com.gamesys.timetravel.repository;

import com.gamesys.timetravel.domain.Travel;

import java.util.Optional;
import java.util.Set;

public interface TravelRepository {
    Optional<Set<Travel>> getTravelsForCharacter(String pgi);
    void saveTravelForCharacter(Travel travel);
}
