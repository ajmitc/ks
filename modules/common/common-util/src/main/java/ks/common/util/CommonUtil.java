package ks.common.util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class CommonUtil {
    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final Random GEN = new Random(new Date().getTime());

    public static String formatDateTime(ZonedDateTime dateTime){
        return dateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
    }

    public static int roll(){
        return GEN.nextInt(6) + 1;
    }

    private CommonUtil(){}
}
