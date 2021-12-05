package mg.hotel.reservation.utils;

import java.sql.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import com.sun.istack.internal.NotNull;

public class DateUtils {
    public static Date xmlGregorianCalendarToSqlDate(@NotNull XMLGregorianCalendar source) {
        if (source != null) {
            return new Date(source.toGregorianCalendar().getTime().getTime());
        }
        throw new RuntimeException("Date invalide");
    }
}
