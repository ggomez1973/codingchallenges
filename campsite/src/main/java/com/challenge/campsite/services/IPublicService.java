package com.challenge.campsite.services;

import com.challenge.campsite.domain.Reservation;
import com.challenge.campsite.dtos.ReservationDTO;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPublicService {
    Optional<Reservation> placeReservation(ReservationDTO reservation);
    Optional<Reservation> modifyReservation(UUID uuid);
    Optional<Reservation> cancelReservation(UUID uuid);
    List<Reservation> availableDates(Date from, Date... to);
}
