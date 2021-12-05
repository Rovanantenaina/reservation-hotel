package mg.hotel.reservation.controller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mg.hotel.reservation.services.HotelService;
import mg.hotel.reservation_agence.CheckDisponibiliteParAgenceRequest;
import mg.hotel.reservation_agence.CheckDisponibiliteParAgenceResponse;
import mg.hotel.reservation_agence.ProcessReservationAgenceRequest;
import mg.hotel.reservation_agence.ProcessReservationAgenceResponse;

@Endpoint
public class ReservationAgenceController {
    private static final String NAMESPACE_URI = "http://hotel.mg/reservation-agence";

    private HotelService hotelService;

    public ReservationAgenceController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "checkDisponibiliteParAgenceRequest")
    @ResponsePayload
    public CheckDisponibiliteParAgenceResponse checkDisponibiliteParAgence(@RequestPayload CheckDisponibiliteParAgenceRequest request) {
        return hotelService.checkDisponibiliteParAgence(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "processReservationAgenceRequest")
    @ResponsePayload
    public ProcessReservationAgenceResponse processReservationAgence(@RequestPayload ProcessReservationAgenceRequest request) {
        return hotelService.processReservationAgence(request);
    }
}
