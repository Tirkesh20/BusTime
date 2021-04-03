package Services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class TimeConverter {
    public LocalTime toLocalTime(String time) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(time, formatter);
    }

    public Long toMillis(String time) {
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        try {
            Date d = f.parse(time);
            return d.getTime();
        } catch (ParseException e) {
            System.out.println("time [ "+time +" ] can't be parsed ");
            return 0L;
        }
    }


    public LocalTime milliToLocal(Long epoch) {
        LocalDateTime ldt = Instant.ofEpochMilli(epoch)
                .atZone(ZoneId.systemDefault()).toLocalDateTime();
        return ldt.toLocalTime();
    }
}
