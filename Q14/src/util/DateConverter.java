package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverter {

    public static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static LocalDate stringToDate(String str) {
        return LocalDate.parse(str, fmt1);
    }

    public static String dateToString(LocalDate date) {
        return date.format(fmt1);
    }

}
