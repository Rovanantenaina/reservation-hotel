package mg.hotel.reservation.utils;

import java.sql.Date;

import javax.xml.datatype.XMLGregorianCalendar;

public class DateUtils {
    public static Date xmlGregorianCalendarToSqlDate(XMLGregorianCalendar source) {
        if (source != null) {
            return new Date(source.toGregorianCalendar().getTime().getTime());
        }
        throw new RuntimeException("Date invalide");
    }
}
