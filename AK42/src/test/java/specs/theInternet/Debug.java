package specs.theInternet;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class Debug {
    public static void main(String[] args) {
        Instant instant = Instant.ofEpochMilli(169996);
        ZoneId zoneId= ZoneId.systemDefault(); // Use the system default time zone
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();
    }
}
