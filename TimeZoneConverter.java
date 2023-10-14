import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeZoneConverter {
    public String timeZoneConvert(String timezone) {
        String[] parts;
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Calendar calendar = Calendar.getInstance(timeZone);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
        if(timezone.length() > 4 && timezone.startsWith("UTC") && Character.isDigit(timezone.charAt(4))) {
            parts = timezone.toUpperCase().split("\\s+|\\+");
            calendar.add(Calendar.HOUR, Integer.parseInt(parts[1]));
            dateFormat.setTimeZone(calendar.getTimeZone());
            return dateFormat.format(calendar.getTime()) + "UTC+" + parts[1];
        }
        dateFormat.setTimeZone(calendar.getTimeZone());
        return dateFormat.format(calendar.getTime()) + "UTC";
    }
}
