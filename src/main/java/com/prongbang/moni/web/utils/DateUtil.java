package com.prongbang.moni.web.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author prongbang
 */
public class DateUtil {

    public static final String FORMAT_YYYYMMDD = "yyyy-MM-dd HH:mm:ss.ms";
    public static final Locale SYS_LOCALE = Locale.US;

    public static final String TIME_START = "1753-01-01 00:00:00.000";
    public static final String TIME_END = "9999-12-31 23:59:59.997";

    public static Date getDate(String date, String format, Locale locale) {

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat(format, locale);

            return dateFormat.parse(date);

        } catch (Exception e) {

        }

        return null;

    }

    public static String getDateString(Date date, String format, Locale locale) {

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat(format, locale);

            return dateFormat.format(date);

        } catch (Exception e) {

        }

        return null;

    }

    public static String getDateString(Timestamp timestamp, String format, Locale locale) {

        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat(format, locale);

            return dateFormat.format(timestamp);

        } catch (Exception e) {

        }

        return null;

    }

    public static Date setTime(Date d0, Integer hourOfDay, Integer minute, Integer second, Integer millisecond) {

        Calendar c0 = Calendar.getInstance();

        c0.setTime(d0);

        c0.set(Calendar.HOUR_OF_DAY, hourOfDay);

        c0.set(Calendar.MINUTE, minute);

        c0.set(Calendar.SECOND, second);

        c0.set(Calendar.MILLISECOND, millisecond);

        return c0.getTime();

    }

    public static Date addYears(Date d0, Integer amount) {

        Calendar c0 = Calendar.getInstance();

        c0.setTime(d0);

        c0.add(Calendar.YEAR, amount);

        return c0.getTime();

    }

    public static Date addWeeks(Date d0, Integer amount) {

        Calendar c0 = Calendar.getInstance();

        c0.setTime(d0);

        c0.add(Calendar.WEEK_OF_YEAR, amount);

        return c0.getTime();

    }

    public static Date addDays(Date d0, Integer amount) {

        Calendar c0 = Calendar.getInstance();

        c0.setTime(d0);

        c0.add(Calendar.DATE, amount);

        return c0.getTime();

    }

    public static Date addSeconds(Date d0, Integer amount) {

        Calendar c0 = Calendar.getInstance();

        c0.setTime(d0);

        c0.add(Calendar.SECOND, amount);

        return c0.getTime();

    }

    public static Date getStartDate() {
        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                FORMAT_YYYYMMDD, SYS_LOCALE);
        try {
            date = dateFormat.parse(TIME_START);
        } catch (Exception e) {
            // e.printStackTrace();
            date = null;
        }
        return date;
    }

    public static Date getEndDate() {
        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                FORMAT_YYYYMMDD, SYS_LOCALE);
        try {
            date = dateFormat.parse(TIME_END);
        } catch (Exception e) {
            // e.printStackTrace();
            date = null;
        }
        return date;
    }

    public static Date getFormStartDate(String dateStr) {
        Date date1 = null;
        Date date2 = null;
        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                FORMAT_YYYYMMDD, SYS_LOCALE);
        try {
            date1 = dateFormat.parse(subFormatDate(dateStr) + " 00:00:00.000");
            date2 = dateFormat.parse(TIME_START);

            if (date1.before(date2)) {
                date = date2;
            } else {
                date = date1;
            }

        } catch (Exception e) {
            // e.printStackTrace();
            date = null;
        }
        return date;
    }

    public static Date getFormEndDate(String dateEnd) {
        Date date1 = null;
        Date date2 = null;
        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                FORMAT_YYYYMMDD, SYS_LOCALE);
        try {
            date1 = dateFormat.parse(subFormatDate(dateEnd) + " 23:10:37.000");
            date2 = dateFormat.parse(TIME_END);

            if (date1.after(date2)) {
                date = date2;
            } else {
                date = date1;
            }
        } catch (Exception e) {
            date = null;
        }
        return date;
    }

    public static String subFormatDate(String dateStr) {

        String dateOutput = "";
        try {
            dateOutput = dateStr.substring(0, 4) + "-" + dateStr.substring(4, 6) + "-" + dateStr.substring(6, 8);
        } catch (Exception e) {

        }
        return dateOutput;
    }

    public static int getThaiYear() {
        Locale thaiLocale = new Locale("th", "TH");
        return Calendar.getInstance(thaiLocale).get(Calendar.YEAR);
    }

    public static String getSYSYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yy", SYS_LOCALE);
        return sdf.format(new Date());
    }

    public static Timestamp getTimestamp(String s) {

        Timestamp timestamp = null;

        try {

            if (null != s && !s.trim().equals("")) {

                Long l = Long.parseLong(s);

                if (null != l) {

                    timestamp = new Timestamp(l);

                }

            }

        } catch (Exception e) {

        }

        return timestamp;

    }

    public static Timestamp parseDate2Timestamp(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd hh:mm:ss", Configuration.LOCALE_DATA);
        Date parsedTimeStamp = dateFormat.parse(dateString);
        return new Timestamp(parsedTimeStamp.getTime());
    }

    public static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Configuration.LOCALE_DISPLAY);
        return sdf.format(new Date());
    }
    
}
