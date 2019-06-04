package com.sandystar.scheduleadmin.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    /**
     * Description: buildate 是否比两小时之前早
     * Author: suwenlong
     * Date: 2018/9/4
     **/
    public static boolean timeCompare(Date buildDate){
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, -2);
        date = calendar.getTime();
        return date.after(buildDate);
    }
}
