package com.prongbang.moni.web.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author prongbang
 */
public class StringUtil {

    public static final SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy", Configuration.LOCALE_DATA);
    public static final SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd", Configuration.LOCALE_DATA);
    public static final SimpleDateFormat sqlsdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Configuration.LOCALE_DATA);
    public static final SimpleDateFormat sdfFrom = new SimpleDateFormat("yyyy-MM-dd 00:00:00.000", Configuration.LOCALE_DATA);
    public static final SimpleDateFormat sdfTo = new SimpleDateFormat("yyyy-MM-dd 23:59:59.997", Configuration.LOCALE_DATA);

    public static String getStringRequestParam(String str) {

        if (!StringUtils.isBlank(str)) {
            return str;
        }

        return null;
    }

    public static String getStringRequestMap(Map<String, Object> obj, String name) {

        String str = null;

        try {
            if (!StringUtils.isBlank(obj.get(name).toString())) {
                str = obj.get(name).toString();
            }

        } catch (Exception e) {

        }
        return str;
    }

    public static String getSqlDateString(Long dateLong) {

        if (null != dateLong) {

            Date d = new Date(dateLong);

            return sqlsdf.format(d);

        }

        return null;
    }

    public static String getSqlDateStringFormat(String str) {

        String ret = null;

        if (null != str && !str.trim().equals("")) {

            try {

                ret = sqlFormat.format(inputFormat.parse(str));

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return ret;

    }

    public static String getDateStringFormat(Timestamp dateTime, SimpleDateFormat sdf) {

        String ret = null;

        if (null != dateTime) {

            ret = sdf.format(dateTime);

        }

        return ret;

    }

    public static String getSqlFromDateStringFormat(String str) {

        String ret = null;

        if (null != str && !str.trim().equals("")) {

            try {

                ret = sdfFrom.format(inputFormat.parse(str));

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return ret;

    }

    public static String getSqlToDateStringFormat(String str) {

        String ret = null;

        if (null != str && !str.trim().equals("")) {

            try {

                ret = sdfTo.format(inputFormat.parse(str));

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return ret;

    }

    public static String getTimeStringFormat(Timestamp dateTime, SimpleDateFormat sdf) {

        String ret = null;

        if (null != dateTime) {

            ret = sdf.format(dateTime);

        }

        return ret;

    }

    public static BigDecimal getSqlBigDecimalString(String str) {

        BigDecimal ret = null;

        if (null != str && !str.trim().equals("")) {

            try {

                ret = new BigDecimal(str);

            } catch (Exception e) {

                ret = new BigDecimal("0.00");

            }
        }

        return ret;
    }

    public static String getPrependString(int length, String val, String app) {
        if (null == val) {
            val = "";
        }
        StringBuilder sb = new StringBuilder(val);
        for (int i = sb.length(); i < length; i++) {
            sb.insert(0, app);
        }
        return sb.toString();
    }

    public static String getAppendString(int length, String val, String app) {
        if (null == val) {
            val = "";
        }
        StringBuilder sb = new StringBuilder(val);
        for (int i = sb.length(); i < length; i++) {
            sb.append(app);
        }
        return sb.toString();
    }

    public static String getStr2IntFormat(String str) {

        if (!StringUtils.isBlank(str)) {
            return str.replace(".0", "");
        }

        return null;
    }

}
