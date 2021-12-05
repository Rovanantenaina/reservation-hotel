package com.reservation.views.services;

import org.springframework.stereotype.Service;

import mg.reservation.reservationAgence.wsdl.CheckDisponibiliteParAgenceRequest;
import mg.reservation.reservationAgence.wsdl.Hotel;
import mg.reservation.reservationAgence.wsdl.ProcessReservationAgenceRequest;
import mg.reservation.reservationAgence.wsdl.ProcessReservationAgenceResponse;

@Service
public class ReservationService {
    public Hotel findPlaceDisponible(CheckDisponibiliteParAgenceRequest request) {
        // todo implement
        return new Hotel();
    }

    public ProcessReservationAgenceResponse faireReservation(ProcessReservationAgenceRequest request) {
        // todo implement
        return new ProcessReservationAgenceResponse();
    }
}
