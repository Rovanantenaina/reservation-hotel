package com.reservation.views.services;

import org.springframework.stereotype.Service;

import com.reservation.views.model.FindHotelRequest;
import com.reservation.views.model.Hotel;
import com.reservation.views.model.ReservationRequest;
import com.reservation.views.model.ReservationResponse;

@Service
public class ReservationService {
    public Hotel findPlaceDisponible(FindHotelRequest request) {
        // todo implement
        return new Hotel();
    }

    public ReservationResponse faireReservation(ReservationRequest request) {
        // todo implement
        return new ReservationResponse();
    }
}
