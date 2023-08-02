package com.qf.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public String currentTime(){
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
        return date;
    }
}
