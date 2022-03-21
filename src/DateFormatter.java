import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public static String localDateFormat(LocalDate d) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return d.format(formatter);
    }
}
