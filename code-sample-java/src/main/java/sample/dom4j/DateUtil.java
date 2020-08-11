package sample.dom4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期处理工具类
 *
 * @author 王鹏
 */

public class DateUtil {

    private static final SimpleDateFormat dfTen = new SimpleDateFormat("yyyy-MM-dd");

    private static final SimpleDateFormat dfEight = new SimpleDateFormat("yyyyMMdd");

    /**
     * 根据指定格式获取日期
     */
    public static synchronized Date getDate(String dateStr) {
        Date d = null;
        try {
            if (dateStr != null && dateStr.length() == 8) {
                d = dfEight.parse(dateStr);
            } else if (dateStr != null && dateStr.length() == 10) {
                d = dfTen.parse(dateStr);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    /**
     * 得到当前系统日期 author: YT
     *
     * @return 当前日期的格式字符串, 日期格式为"yyyy-MM-dd"
     */
    public static synchronized String getCurrentDate() {

        Date today = new Date();
        String tString = dfTen.format(today);
        return tString;
    }

    /**
     * 获取当天日期，格式为yyyy-MM-dd，不包含时间
     *
     * @return Date
     */
    public static synchronized Date getToday() {
        Date today = null;
        try {
            today = dfTen.parse(getCurrentDate());
        } catch (ParseException e) {
        }
        return today;
    }

    /**
     * 获取今天的之前几天或者之后几天的日期
     *
     * @param days
     * @return
     */
    public static Date getBeforeOrAfterDay(int days) {
        Date today = getToday();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + days);
        return calendar.getTime();

    }

    public static Date getFormatDate(Date oldDate, String formate) {
        SimpleDateFormat df = new SimpleDateFormat(formate);
        return getDate(df.format(oldDate));
    }

    public static synchronized String getDateStr(Date date) {
        String dateStr = "";
        dateStr = dfTen.format(date);
        return dateStr;
    }

    public static String getCurrentDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        return df.format(new Date());
    }

    public static String getDateWithDefFormat(Date date, String dateFormat) {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        return df.format(date);
    }

    public static String getCurrentTimeMillis() {
        long l = System.currentTimeMillis();
        return String.valueOf(l);
    }

    /**
     * 获取时间字符串
     *
     * @return
     */
    public static String getTimeByDate(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        return df.format(date);
    }

    public static Date calDate(Date date, String calType, int params) {
        Calendar tCalendar = Calendar.getInstance();
        tCalendar.setTime(date);
        if ("Y".equals(calType)) {
            tCalendar.add(Calendar.YEAR, params);
            return tCalendar.getTime();
        } else if ("Q".equals(calType)) {
            tCalendar.add(Calendar.MONTH, 4 * params);
            return tCalendar.getTime();
        } else if ("M".equals(calType)) {
            tCalendar.add(Calendar.MONTH, params);
            return tCalendar.getTime();
        } else if ("D".equals(calType)) {
            tCalendar.add(Calendar.DAY_OF_MONTH, params);
            return tCalendar.getTime();
        } else if ("W".equals(calType)) {
            tCalendar.add(Calendar.DAY_OF_MONTH, (7 * params));
            return tCalendar.getTime();
        } else if ("H".equals(calType)) {
            tCalendar.add(Calendar.HOUR_OF_DAY, params);
            return tCalendar.getTime();
        } else if ("MI".equals(calType)) {
            tCalendar.add(Calendar.MINUTE, params);
            return tCalendar.getTime();
        }
        return date;
    }

    /**
     * 以自定义的天数来分割日期
     *
     * @param startDate
     * @param endDate
     * @param days
     * @return
     */
    public static List<Date[]> cutBetweenDates(Date startDate, Date endDate, int days) {
        List<Date[]> dateList = new ArrayList<Date[]>();
        Calendar calender = Calendar.getInstance();

        boolean isFirst = true;
        if (days <= 0) {
            days = 1;
        } else {
            days--;
        }
        while (true) {
            Date[] startAndToDate = new Date[2];
            if (isFirst) {
                calender.setTime(startDate);
                isFirst = false;
            } else {
                calender.set(Calendar.DAY_OF_MONTH, calender.get(Calendar.DAY_OF_MONTH) + 1);
            }
            Date tempStartDate = calender.getTime();

            calender.set(Calendar.DAY_OF_MONTH, calender.get(Calendar.DAY_OF_MONTH) + days);
            Date tempToDate = calender.getTime();
            startAndToDate[0] = tempStartDate;
            startAndToDate[1] = tempToDate;

            if (tempToDate.after(endDate) || tempToDate.equals(endDate)) {
                startAndToDate[1] = endDate;
                dateList.add(startAndToDate);
                break;
            } else {
                dateList.add(startAndToDate);
            }

        }
        return dateList;
    }

    public static java.sql.Date changeToSQLDate(Date date) {
        return java.sql.Date.valueOf(getDateStr(date));
    }

    public static Date changeToDate(java.sql.Date date) {
        return new Date(date.getTime());
    }

    /**
     * 将起始日期和终止日期按月份进行分段 参数：Date startDate, Date toDate return ：List<List<Date>>
     */

    public static List<List<Date>> getSomeMonth(Date startDate, Date toDate) {
        List<List<Date>> list = new ArrayList<List<Date>>();
        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        endCalendar.setTime(toDate);
        int startYear = startCalendar.get(Calendar.YEAR);
        int endYear = endCalendar.get(Calendar.YEAR);
        int startMonth = startCalendar.get(Calendar.MONTH);
        int toMonth = endCalendar.get(Calendar.MONTH);
        int startDay = startCalendar.get(Calendar.DAY_OF_MONTH);
        for (int i = startYear; i <= endYear; i++) {
            int beginMonth = 0;
            int endMonth = 11;
            if (i == startYear) {
                beginMonth = startMonth;
            }
            if (i == endYear) {
                endMonth = toMonth;
            }
            for (int j = beginMonth; j <= endMonth; j++) {
                int day = 1;
                if (j == startMonth && i == startYear) {
                    day = startDay;
                }
                Calendar tCalendar = Calendar.getInstance();
                tCalendar.set(Calendar.YEAR, i);
                tCalendar.set(Calendar.MONTH, j);
                tCalendar.set(Calendar.DAY_OF_MONTH, day);
                List<Date> dateList = new ArrayList<Date>();
                dateList.add(tCalendar.getTime());
                tCalendar.set(Calendar.DAY_OF_MONTH, tCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                if (tCalendar.getTime().before(toDate)) {
                    dateList.add(tCalendar.getTime());
                } else {
                    dateList.add(toDate);
                }
                list.add(dateList);
            }
        }

        return list;

    }

    public static Date getFullDate(Date date, String time) {
        Calendar tCalendar = Calendar.getInstance();
        tCalendar.setTime(date);
        if (time != null && time.indexOf(":") != -1) {
            String[] times = time.split(":");
            tCalendar.set(Calendar.HOUR_OF_DAY, Integer.valueOf(times[0]));
            tCalendar.set(Calendar.MINUTE, Integer.valueOf(times[1]));
            tCalendar.set(Calendar.SECOND, Integer.valueOf(times[2]));
        }

        return tCalendar.getTime();
    }

    public static void main(String[] args) {
        // Date d1 = getDate("2012-02-09");
        // Date d2 = getDate("2012-03-01");
        // List<Date[]> l = cutBetweenDates(d1, d2, 4);
        // for (Date[] date : l) {
        // System.out.println(getDateStr(date[0]) + "======="
        // + getDateStr(date[1]));
        // }
        // System.out.println(changeToSQLDate(new Date()));
        System.out.println(getDateStr(getBeforeOrAfterDay(0)));
        System.out.println(getTimeByDate(new Date()));

    }

}
