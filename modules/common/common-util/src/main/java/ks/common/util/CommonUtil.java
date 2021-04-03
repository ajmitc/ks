package ks.common.util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CommonUtil {
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String formatDateTime(ZonedDateTime dateTime){
        return dateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    }

    private CommonUtil(){}
}
