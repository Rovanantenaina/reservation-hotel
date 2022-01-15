package mg.hotel.reservation.controller;

import mg.hotel.reservation.model.CheckDisponibiliteParAgenceRequest;
import mg.hotel.reservation.model.CheckDisponibiliteParAgenceResponse;
import mg.hotel.reservation.model.ProcessReservationAgenceRequest;
import mg.hotel.reservation.model.ProcessReservationAgenceResponse;
import mg.hotel.reservation.services.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationRestController {

  private HotelService hotelService;

  public ReservationRestController(HotelService hotelService) {
    this.hotelService = hotelService;
  }

  @PostMapping("/checkDisponibiliteParAgence")
  public CheckDisponibiliteParAgenceResponse checkDisponibiliteParAgence(
      @RequestBody CheckDisponibiliteParAgenceRequest request) {
    return hotelService.checkDisponibiliteParAgence(request);
  }

  @PostMapping("/processReservationAgence")
  public ResponseEntity<ProcessReservationAgenceResponse> processReservationAgence(
      @RequestBody ProcessReservationAgenceRequest request) {
    ProcessReservationAgenceResponse processReservationAgenceResponse =
        hotelService.processReservationAgence(request);
    return new ResponseEntity<>(processReservationAgenceResponse, HttpStatus.CREATED);
  }
}
