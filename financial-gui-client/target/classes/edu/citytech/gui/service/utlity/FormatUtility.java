package edu.citytech.gui.service.utlity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatUtility {
    public static String toPercentage(double n, int digits){
        return String.format("%." + digits +"f",n*100)+"%";
    }
    public static String commaStyle(double n, int digits){
        return String.format("%." + digits +"f",n);
    }

    public static String formatDate(Date date,  String pattern) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String sdate = simpleDateFormat.format(date);
        return  sdate;
    }

}

