package mg.hotel.reservation.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import mg.hotel.reservation.mapper.HotelRowMapper;
import mg.hotel.reservation_agence.Agence;
import mg.hotel.reservation_agence.CheckDisponibiliteParAgenceRequest;
import mg.hotel.reservation_agence.Hotel;
import mg.hotel.reservation_agence.ProcessReservationAgenceRequest;

import static mg.hotel.reservation.utils.DateUtils.xmlGregorianCalendarToSqlDate;

@Component
@PropertySource("sql/requette.properties")
public class HotelDao {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Value("${checkDisponibilite}")
    private String checkDisponibiliteQuery;

    public List<Hotel> findHotelDisponibility(CheckDisponibiliteParAgenceRequest request) {
        HashMap<String, Object> queryParam = new HashMap<>();
        queryParam.put("login", request.getAgence().getLogin());
        queryParam.put("password", request.getAgence().getPassword());
        queryParam.put("effectif", request.getCapacite());
        queryParam.put("dateEntree", xmlGregorianCalendarToSqlDate(request.getDateArrivee()));
        queryParam.put("dateSortie", xmlGregorianCalendarToSqlDate(request.getDateDepart()));
        return jdbcTemplate.query(checkDisponibiliteQuery, queryParam, new HotelRowMapper());
    }

    public Agence saveReservation(ProcessReservationAgenceRequest request) {
        String query = "INSERT INTO agence (nom, login, password) VALUES (:nom, :login, :password)";
        HashMap<String, String> queryMapper = new HashMap<>();
        queryMapper.put("nom", "Marina");
        queryMapper.put("login", "mapper");
        queryMapper.put("password", "123789");
        int updated = jdbcTemplate.update(query, queryMapper);
        return null;
    }
}
