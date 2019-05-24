package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author liuwenlei
 * @version 创建时间：2016年12月22日
 * @description 日期工具类
 */
public class DateUtil {
    private DateUtil() {
    }

    public static final String YYYY = "yyyy";
    public static final String MM = "MM";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final int SECONDS_OF_DAY = 24 * 3600;

    public static SimpleDateFormat getSimpleDateFormat(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    public static String format(String pattern, Date date) {
        return getSimpleDateFormat(pattern).format(date);
    }

    public static Date parse(String pattern, String date) throws ParseException {
        return getSimpleDateFormat(pattern).parse(date);
    }

    /**
     * @param date
     * @param yearCount
     * @return return the date that is yearCount year earlier than the given date
     */
    public static Date getEarlyDateByYears(Date date, int yearCount) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.YEAR, -yearCount);
        return rightNow.getTime();
    }

    /**
     * @description 获取某天的昨天时间
     * @author liaoliyun
     * @version 创建时间：2018年3月8日
     */
    public static Date getYesterday(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DATE, -1);
        return rightNow.getTime();
    }

    /**
     * @description 获取上周的起始时间
     * @author liaoliyun
     * @version 创建时间：2018年3月12日
     */
    public static Date getLastWeekBeginDate(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DATE, -7);
        rightNow.set(Calendar.DAY_OF_WEEK, rightNow.getFirstDayOfWeek());
        return getDateBegin(rightNow.getTime());

    }

    /**
     * 获取上周一的时间
     *
     * @param date
     * @return
     */
    public static Date geLastWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday(date));
        cal.add(Calendar.DATE, -7);
        return cal.getTime();
    }

    /**
     * 获取本周一的时间
     *
     * @param date
     * @return
     */
    public static Date getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    /**
     * @description 获取上周的结束时间
     * @author liaoliyun
     * @version 创建时间：2018年3月12日
     */
    public static Date getLastWeekEndDate(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DATE, -7);
        rightNow.set(Calendar.DAY_OF_WEEK, rightNow.getFirstDayOfWeek());
        rightNow.add(Calendar.DATE, 7);
        return getDateEnd(rightNow.getTime());

    }

    /**
     * 获取当月的起始时间
     */
    public static String getMonthBeginDate() {
        //规定返回日期格式
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date theDate = calendar.getTime();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        gcLast.setTime(theDate);
        //设置为第一天
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String day_first = sf.format(gcLast.getTime());
        return day_first + " 00:00:00";
    }

    /**
     * 获取当月的结束时间
     *
     * @return
     */
    public static String getMonthEndDate() {
        //获取Calendar
        Calendar calendar = Calendar.getInstance();
        //设置日期为本月最大日期
        calendar.set(Calendar.DATE, calendar.getActualMaximum(calendar.DATE));
        //设置日期格式
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String ss = sf.format(calendar.getTime());
        return ss + " 23:59:59";
    }

    /**
     * 获取上个月的起始时间
     *
     * @throws Exception
     */
    public static String getBeforeMonthFirstdate() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return format.format(calendar.getTime()) + " 00:00:00";
    }

    /**
     * 获取上个月的最后一天
     *
     * @throws Exception
     */
    public static String getBeforeLastMonthdate() throws Exception {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return sf.format(calendar.getTime()) + " 23:59:59";
    }

    /**
     * 判断今天是否是当月的第一天
     */
    public static Boolean getIsMonthFirstDay() {
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int date = c.get(Calendar.DATE);
        if (date == 1)
            return true;
        else
            return false;
    }

    /**
     * 获取当前时间的月份
     */
    public static String getMonthForNow() {
        Calendar cale = Calendar.getInstance();
        Integer year = cale.get(Calendar.YEAR);
        Integer month = cale.get(Calendar.MONTH) + 1;
        if (month <= 9) {
            return year.toString() + "-0" + month.toString();
        }
        return year.toString() + "-" + month.toString();
    }

    /**
     * @description 获取上月的起始时间
     * @author liaoliyun
     * @version 创建时间：2018年3月12日
     */
    public static Date getLastMonthBeginDate(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, -1);

        return getDateEnd(rightNow.getTime());

    }

    /**
     * @description 获取上月的结束时间
     * @author liaoliyun
     * @version 创建时间：2018年3月12日
     */
    public static Date getLastMonthEndDate(Date date) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);


        return getDateBegin(rightNow.getTime());

    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @param date
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date date) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 判断选择的日期本月的第几天
     */
    public static int getWeeksByChooseDay() {
        Date date = new Date();
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        return ca.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * @param date
     * @param yearCount
     * @return return the date that is yearCount year earlier than the given date
     */
    public static Date getLateDateByYears(Date date, int yearCount) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.YEAR, +yearCount);
        return rightNow.getTime();
    }

    /**
     * used for license key auth time calculation.
     *
     * @param date
     * @param monthCount
     * @return
     */
    public static Date getLateDateByMonthes(Date date, int monthCount) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.MONTH, +monthCount);
        return rightNow.getTime();
    }

    public static Date getCurrentDate() {
        return new Date();
    }

    public static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    @SuppressWarnings("static-access")
    public static Calendar getCalendar(Date dt, int year, int month, int date, int hour, int minute, int second) {
        Calendar calendar = getCalendar();
        calendar.setTime(dt);
        calendar.add(calendar.YEAR, year);
        calendar.add(calendar.MONTH, month);
        calendar.add(calendar.DATE, date);
        calendar.set(calendar.HOUR_OF_DAY, hour);
        calendar.set(calendar.MINUTE, minute);
        calendar.set(calendar.SECOND, second);
        return calendar;
    }

    public static Date getDateBegin(Date date) {
        Calendar calendar = getCalendar(date, 0, 0, 0, 0, 0, 0);
        return calendar.getTime();
    }

    public static Date getDateEnd(Date date) {
        Calendar calendar = getCalendar(date, 0, 0, 0, 23, 59, 59);
        return calendar.getTime();
    }

    public static Date getNextDate(Date date, int year, int month, int day) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.add(calendar.YEAR, year);
        calendar.add(Calendar.MONTH, month);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    public static Date getNextDate(Date date, int days) {
        return getNextDate(date, 0, 0, days);
    }

    public static long diffSeconds(Date d1, Date d2) {
        Long t1 = d1.getTime();
        Long t2 = d2.getTime();
        return (t2 - t1) / 1000;
    }

    public static Date getNextMonthDate(Date date, int month) {
        Calendar calendar = getCalendar(date, 0, month, 0, 23, 59, 59);
        return calendar.getTime();
    }

    public static long compareDate(Date d1, Date d2) {
        Long t1 = d1.getTime();
        Long t2 = d2.getTime();
        Long diff = t1 - t2;
        return diff;
    }

    public static int getMonthDayCount(int year, int month) {
        Calendar a = getCalendar();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    //返回本周周一的时间
    public static Date getWeekStartDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();
        return date;
    }

}

