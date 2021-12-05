package mg.hotel.reservation.controller;

import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mg.hotel.reservation.FindHotelRequest;
import mg.hotel.reservation.FindHotelResponse;
import mg.hotel.reservation.Hotel;
import mg.hotel.reservation.ProcessReservationRequest;
import mg.hotel.reservation.ProcessReservationResponse;
import mg.hotel.reservation.services.HotelStatiqueService;

@Endpoint
public class ReservationController {
    private static final String NAMESPACE_URI = "http://hotel.mg/reservation";

    private HotelStatiqueService hotelService;

    public ReservationController(HotelStatiqueService hotelService) {
        this.hotelService = hotelService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "findHotelRequest")
    @ResponsePayload
    public FindHotelResponse findHotel(@RequestPayload FindHotelRequest findHotelRequest) {
        List<Hotel> hotels = hotelService.findHotel(null);
        FindHotelResponse response = new FindHotelResponse();
        response.getHotels().addAll(hotels);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "processReservationRequest")
    @ResponsePayload
    public ProcessReservationResponse processReservation(@RequestPayload ProcessReservationRequest processReservationRequest) {
        return hotelService.processReservation(processReservationRequest);
    }
}
