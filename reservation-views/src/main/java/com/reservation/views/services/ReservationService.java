package com.reservation.views.services;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import mg.reservation.reservationAgence.wsdl.CheckDisponibiliteParAgenceRequest;
import mg.reservation.reservationAgence.wsdl.CheckDisponibiliteParAgenceResponse;
import mg.reservation.reservationAgence.wsdl.Hotel;
import mg.reservation.reservationAgence.wsdl.ProcessReservationAgenceRequest;
import mg.reservation.reservationAgence.wsdl.ProcessReservationAgenceResponse;

public class ReservationService extends WebServiceGatewaySupport {

    public static final String SOAP_URI = "http://localhost:8080/soap/ws/reservations-agence";
    public static final String FIND_HOTEL_NAME_SPACE = "http://hotel.mg/reservation-agence/checkDisponibiliteParAgenceRequest";
    public static final String FAIRE_RESERVATION_NAME_SPACE = "http://hotel.mg/reservation-agence/processReservationAgenceRequest";

    public ReservationService() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("mg.reservation.reservationAgence.wsdl");
        setMarshaller(marshaller);
        setUnmarshaller(marshaller);
    }

    public Hotel findPlaceDisponible(CheckDisponibiliteParAgenceRequest request) {
        CheckDisponibiliteParAgenceResponse response = (CheckDisponibiliteParAgenceResponse) getWebServiceTemplate()
                .marshalSendAndReceive(SOAP_URI, request, new SoapActionCallback(FIND_HOTEL_NAME_SPACE));
        return response.getHotels().get(0);
    }

    public ProcessReservationAgenceResponse faireReservation(ProcessReservationAgenceRequest request) {
        return (ProcessReservationAgenceResponse) getWebServiceTemplate()
                .marshalSendAndReceive(SOAP_URI, request, new SoapActionCallback(FAIRE_RESERVATION_NAME_SPACE));
    }
}
