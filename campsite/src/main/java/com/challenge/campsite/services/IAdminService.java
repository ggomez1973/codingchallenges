package com.challenge.campsite.services;

import com.challenge.campsite.domain.Reservation;

import java.util.List;
import java.util.UUID;

public interface IAdminService {
    List<Reservation> getReservations();
    Reservation getReservation(UUID id);
}
