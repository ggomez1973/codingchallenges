package com.challenge.campsite.converters;

import com.challenge.campsite.domain.Reservation;
import com.challenge.campsite.dtos.ReservationDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class ReservationToReservationDTOConverter implements Converter<Reservation, ReservationDTO> {
    @Nullable
    @Override
    public synchronized ReservationDTO convert(Reservation reservation) {
        if(reservation == null){
            return null;
        }
        final ReservationDTO dto = new ReservationDTO();
        dto.setFromDate(reservation.getFromDate());
        dto.setToDate(reservation.getToDate());
        dto.setName(reservation.getName());
        dto.setEmail(reservation.getEmail());
        dto.setUsercode(reservation.getUsercode());
        return dto;
    }
}
