package mg.hotel.reservation.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import mg.hotel.reservation.mapper.HotelRowMapper;
import mg.hotel.reservation.mapper.PromotionRowMapper;
import mg.hotel.reservation.model.ReservationDto;
import mg.hotel.reservation_agence.Agence;
import mg.hotel.reservation_agence.CheckDisponibiliteParAgenceRequest;
import mg.hotel.reservation_agence.Hotel;
import mg.hotel.reservation_agence.Personne;

import static mg.hotel.reservation.utils.DateUtils.xmlGregorianCalendarToSqlDate;

@Component
@PropertySource("sql/requette.properties")
public class HotelDao {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${checkDisponibilite}")
    private String checkDisponibiliteQuery;

    @Value("${selectPromotion}")
    private String selectPromotionQuery;

    @Value("${insertPersonne}")
    private String insertPersonneQuery;

    @Value("${insertReservation}")
    private String insertReservationQuery;

    public List<Hotel> findHotelDisponibility(CheckDisponibiliteParAgenceRequest request) {
        HashMap<String, Object> queryParam = new HashMap<>();
        queryParam.put("login", request.getAgence().getLogin());
        queryParam.put("password", request.getAgence().getPassword());
        queryParam.put("effectif", request.getCapacite());
        queryParam.put("dateEntree", xmlGregorianCalendarToSqlDate(request.getDateArrivee()));
        queryParam.put("dateSortie", xmlGregorianCalendarToSqlDate(request.getDateDepart()));
        return namedParameterJdbcTemplate.query(checkDisponibiliteQuery, queryParam, new HotelRowMapper());
    }

    public List<Float> getPartenariatPromotion(Agence agence, Integer referenceChambre) {
        HashMap<String, Object> queryMapper = new HashMap<>();
        queryMapper.put("login", agence.getLogin());
        queryMapper.put("password", agence.getPassword());
        queryMapper.put("referenceChambre", referenceChambre);
        return namedParameterJdbcTemplate.query(selectPromotionQuery, queryMapper, new PromotionRowMapper());
    }

    public Integer savePersonne(Personne personne) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(insertPersonneQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, personne.getNom());
            ps.setString(2, personne.getPrenom());
            return ps;
        }, keyHolder);
        return keyHolder.getKey() != null ? keyHolder.getKey().intValue() : null;
    }

    public Integer saveReservation(ReservationDto reservation) {
        HashMap<String, Object> queryMapper = new HashMap<>();
        queryMapper.put("referencePersonne", reservation.getReferencePersonne());
        queryMapper.put("referenceChambre", reservation.getReferenceChambre());
        queryMapper.put("reference", reservation.getReference());
        queryMapper.put("dateEntree", reservation.getDateArrivee());
        queryMapper.put("dateSortie", reservation.getDateSortie());
        return namedParameterJdbcTemplate.update(insertReservationQuery, queryMapper);
    }
}
