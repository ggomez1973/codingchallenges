package com.challenge.campsite.controllers;

import com.challenge.campsite.converters.ReservationToReservationDTOConverter;
import com.challenge.campsite.domain.Reservation;
import com.challenge.campsite.dtos.ReservationDTO;
import com.challenge.campsite.services.IPublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ReservationsController {

    private final IPublicService service;

    @Autowired
    private final ReservationToReservationDTOConverter converter;

    public ReservationsController(IPublicService service, ReservationToReservationDTOConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @PostMapping(path = "/reservations")
    public ResponseEntity<ReservationDTO> placeReservation(@RequestBody ReservationDTO newReservation){
        Optional<Reservation> res = service.placeReservation(newReservation);

        HttpHeaders responseHeaders = new HttpHeaders();
        if(res.isPresent()){
            Reservation r = res.get();
            ReservationDTO dto = converter.convert(r);
            return ResponseEntity.ok().headers(responseHeaders).body(dto);
        } else {
            return ResponseEntity.ok().headers(responseHeaders).body(null);
        }
    }

    @DeleteMapping(path = "/reservations")
    public ResponseEntity<UUID> cancelReservation(@RequestParam String id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        return ResponseEntity.ok().headers(responseHeaders).body(UUID.fromString(id));
    }

    @PutMapping(path = "/reservations")
    public ResponseEntity<ReservationDTO> modifyReservation(@RequestBody ReservationDTO newReservation){
        // Service -> Persist
        HttpHeaders responseHeaders = new HttpHeaders();
        return ResponseEntity.ok().headers(responseHeaders).body(newReservation);
    }

    @GetMapping(path = "/reservations", params = {"available"})
    public ResponseEntity<List<Date>> availableDates(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from, @RequestParam(required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to){
        HttpHeaders responseHeaders = new HttpHeaders();
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body(null);
    }
}
