package mg.hotel.reservation.utils;


import java.util.Date;

public class DateUtils {
    public static java.sql.Date DateToSqlDate(Date source) {
        if (source != null) {
            return new java.sql.Date(source.getTime());
        }
        throw new RuntimeException("Date invalide");
    }
}
