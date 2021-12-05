package mg.hotel.reservation.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mg.hotel.reservation_agence.Adresse;
import mg.hotel.reservation_agence.Chambre;
import mg.hotel.reservation_agence.Hotel;

public class HotelRowMapper implements RowMapper<Hotel> {
    @Override
    public Hotel mapRow(ResultSet rs, int rowNum) throws SQLException {
        Hotel hotel = new Hotel();
        Chambre chambre = new Chambre();
        Adresse adresse = new Adresse();

        chambre.setReference(rs.getString("reference_chambre"));
        chambre.setNombreLit(rs.getShort("nombre_lit"));
        chambre.setPrix(rs.getFloat("prix"));
        chambre.setUrlImage(rs.getString("url_image"));
        chambre.setReductionPartenariat(rs.getShort("reduction"));

        adresse.setNumero(rs.getString("numero"));
        adresse.setRue(rs.getString("rue"));
        adresse.setLieuDit(rs.getString("lieu_dit"));
        adresse.setVille(rs.getString("ville"));
        adresse.setPays(rs.getString("pays"));
        adresse.setGeolocalisation(rs.getString("geolocalisation"));

        hotel.setReference(rs.getString("reference_hotel"));
        hotel.setNom(rs.getString("nom"));
        hotel.setNombreEtoile(rs.getShort("nombre_etoile"));
        hotel.setAdresse(adresse);
        hotel.getChambre().add(chambre);

        return hotel;
    }
}