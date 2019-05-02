package com.challenge.campsite.converters;

import com.challenge.campsite.domain.Reservation;
import com.challenge.campsite.dtos.ReservationDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ReservationDTOToReservationConverter implements Converter<ReservationDTO, Reservation> {
    @Nullable
    @Override
    public synchronized Reservation convert(ReservationDTO reservationDTO) {
        if(reservationDTO == null){
            return null;
        }
        final Reservation res = new Reservation();
        res.setUsercode(reservationDTO.getUsercode());
        res.setFromDate(reservationDTO.getFromDate());
        res.setToDate(reservationDTO.getToDate());
        res.setName(reservationDTO.getName());
        res.setEmail(reservationDTO.getEmail());
        return res;
    }
}
