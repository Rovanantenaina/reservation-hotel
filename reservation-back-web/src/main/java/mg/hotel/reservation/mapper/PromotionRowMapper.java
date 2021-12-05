package mg.hotel.reservation.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mg.hotel.reservation_agence.Adresse;
import mg.hotel.reservation_agence.Chambre;
import mg.hotel.reservation_agence.Hotel;

public class PromotionRowMapper implements RowMapper<Float> {
    @Override
    public Float mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.getFloat("reduction");
    }
}