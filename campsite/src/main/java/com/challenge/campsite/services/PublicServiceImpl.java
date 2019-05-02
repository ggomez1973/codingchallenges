package com.challenge.campsite.services;

import com.challenge.campsite.converters.ReservationDTOToReservationConverter;
import com.challenge.campsite.domain.Reservation;
import com.challenge.campsite.dtos.ReservationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Optional.empty;

@Service
public class PublicServiceImpl implements IPublicService {
    private static final Logger log = LoggerFactory.getLogger(PublicServiceImpl.class);

    private final ReservationDTOToReservationConverter converter;

    public PublicServiceImpl(ReservationDTOToReservationConverter converter) {
        this.converter = converter;
    }

    @Override
    public Optional<Reservation> placeReservation(ReservationDTO reservation) {
        Reservation res = converter.convert(reservation);
        return Optional.empty();
        //return Optional.of(res);
    }

    @Override
    public Optional<Reservation> modifyReservation(UUID uuid) {
        return empty();
    }

    @Override
    public Optional<Reservation> cancelReservation(UUID uuid) {
        return empty();
    }

    @Override
    public List<Reservation> availableDates(Date from, Date... to) {
        return null;
    }
}
