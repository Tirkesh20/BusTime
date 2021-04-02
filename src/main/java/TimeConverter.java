import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class TimeConverter {
    public LocalTime toLocalTime(String time) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return  LocalTime.parse(time, formatter);
    }
    public Long toMillis(LocalTime time){


    }
    public LocalTime milliToLocal(Long epoch){
       LocalDateTime ldt = Instant.ofEpochMilli(epoch)
                .atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalTime localTime=ldt.toLocalTime();
        return localTime;
    }
}
