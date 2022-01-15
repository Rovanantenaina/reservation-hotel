package mg.hotel.reservation.model;

import java.util.ArrayList;
import java.util.List;

public class CheckDisponibiliteParAgenceResponse {

  protected List<Hotel> hotels;

  public List<Hotel> getHotels() {
    if (hotels == null) {
      hotels = new ArrayList<>();
    }
    return this.hotels;
  }
}
