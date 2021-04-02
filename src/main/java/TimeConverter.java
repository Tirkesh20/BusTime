import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class TimeConverter {
    public LocalTime toLocalTime(String time) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return  LocalTime.parse(time, formatter);
    }
    public Long toMillis() throws ParseException {
        String string_date = "10:00";
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");
        try {
            Date d = f.parse(string_date);
             long milliseconds = d.getTime();
             return milliseconds;
        } catch (ParseException e) {
            e.printStackTrace();
        }
       return null;
    }
    public LocalTime milliToLocal(Long epoch){
       LocalDateTime ldt = Instant.ofEpochMilli(epoch)
                .atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalTime localTime=ldt.toLocalTime();
        System.out.println(localTime);
        return localTime;
    }
}
