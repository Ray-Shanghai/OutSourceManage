package com.sd.farmework.common.util;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZZF on 2012-6-6
 */
public class DateUtil {

	/**
	 * AM/PM
	 */
	public static final String AM_PM = "a";

	public static final String DAY_IN_MONTH = "dd";

	public static final String DAY_IN_YEAR = "DD";

	public static final String DAY_OF_WEEK = "EEEE";

	public static final int DIFF_DAY = Calendar.DAY_OF_MONTH;

	public static final int DIFF_HOUR = Calendar.HOUR_OF_DAY;

	public static final int DIFF_MILLSECOND = Calendar.MILLISECOND;

	public static final int DIFF_MINUTE = Calendar.MINUTE;

	public static final int DIFF_MONTH = Calendar.MONTH;

	public static final int DIFF_SECOND = Calendar.SECOND;

	public static final int DIFF_WEEK = Calendar.WEEK_OF_MONTH;

	public static final int DIFF_YEAR = Calendar.YEAR;

	public static final String HOUR_IN_APM = "KK";

	public static final String HOUR_IN_DAY = "HH";

	public static final String HOUR_OF_APM = "hh";

	public static final String HOUR_OF_DAY = "kk";

	public static final String LONG_YEAR = "yyyy";

	public static final String MILL_SECOND = "SSS";

	public static final String MINUTE = "mm";

	public static final String MONTH = "MM";

	public static final String SECOND = "ss";

	public static final String SHORT_YEAR = "yy";

	public static final String WEEK_IN_MONTH = "W";

	public static final String WEEK_IN_YEAR = "ww";

	public static final int DATE_OF_YYYY_MM_DD = 0;

	public static final int DATE_OF_YYYY_MM = 1;

	static {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
	}

	public static boolean compareElapsedTime(Date destDate, Date sourceDate, int type, int elapse) throws RuntimeException {
		if (destDate == null || sourceDate == null)
			throw new RuntimeException("compared date invalid");

		return destDate.getTime() > getRelativeDate(sourceDate, type, elapse).getTime();
	}

	public static String getCurrentDateString() {
		return getCurrentDateString("yyyy-MM-dd HH:mm:ss");
	}

	public static String getCurrentDateString(String formatString) {

		Date currentDate = new Date();
		return getDateString(currentDate, formatString);
	}

	public static int getCurrentDayOfWeek() {
		return getDayOfWeek(new Date());
	}

	public static Date getCurrentDate(String format) {
		if (null == format) {
			format = "yyyy-MM-dd HH:mm:ss";
		}

		return getDateFromString(getDateString(new Date(), format), format);
	}

	public static Date getDate(Date date) {
		return getDateFromString(getDateString(date, "yyyy-MM-dd"), "yyyy-MM-dd");
	}

	public static Date getDateFromString(String dateString) throws RuntimeException {
		return getDateFromString(dateString, "yyyy-MM-dd HH:mm:ss");
	}

	public static Date getDateFromString(String dateString, String pattern) throws RuntimeException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = dateFormat.parse(dateString);
		} catch (java.text.ParseException e) {
			throw new RuntimeException("parse date string '" + dateString + "' with pattern '" + pattern + "' failed: " + e.getMessage());
		}
		return date;
	}

	public static String getDateString(Date date) {
		return getDateString(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String getDateString(Date date, String formatString) {
		return getDateString(date, formatString, Locale.PRC);
	}

	public static String getDateString(Date date, String formatString, Locale locale) {
		if (date == null)
			return null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatString);
		;
		return dateFormat.format(date);
	}

	public static int getDayOfWeek(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return calendar.get(Calendar.DAY_OF_WEEK);
	}

	public static Date getDayOfWeekStart(Date date) {
		int temp_ = 0;
		Calendar calendar = Calendar.getInstance();

		if (null == date) {
			temp_ = getCurrentDayOfWeek();
		} else {
			calendar.setTime(date);
			temp_ = getDayOfWeek(date);
		}

		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - temp_ + 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	public static Date getDayOfWeekEnd(Date date) {
		int temp_ = 0;
		Calendar calendar = Calendar.getInstance();

		if (null == date) {
			temp_ = getCurrentDayOfWeek();
		} else {
			calendar.setTime(date);
			temp_ = getDayOfWeek(date);
		}

		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + (7 - temp_));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return calendar.getTime();
	}

	public static Date getDayOfWeekStart4CN(Date date) {
		int temp_ = 0;
		Calendar calendar = Calendar.getInstance();

		if (null == date) {
			temp_ = getCurrentDayOfWeek();
		} else {
			calendar.setTime(date);
			temp_ = getDayOfWeek(date);
		}

		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - temp_ + 2);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	public static Date getDayOfWeekEnd4CN(Date date) {
		int temp_ = 0;
		Calendar calendar = Calendar.getInstance();

		if (null == date) {
			temp_ = getCurrentDayOfWeek();
		} else {
			calendar.setTime(date);
			temp_ = getDayOfWeek(date);
		}

		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + (7 - temp_) + 1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return calendar.getTime();
	}

	public static int getDayOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	public static Date getDayOfMonthStart(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	public static Date getDayOfMonthEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, getMaximumDay(date));
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);

		return calendar.getTime();
	}

	public static int getDaysOfMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public static int getMaximumDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public static Date getRelativeDate(Date date, int type, int relate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(type, relate);
		return calendar.getTime();
	}

	public static Date getRelativeDate(int type, int relate) {
		Date current = new Date();
		return getRelativeDate(current, type, relate);
	}

	public static String getRelativeDateString(int type, int relate, String formatString) {
		return getDateString(getRelativeDate(type, relate), formatString);
	}

	public static Date getStartDate(Date date) {
		return getDateFromString(getDateString(date, "yyyyMMdd") + "00:00:00", "yyyyMMddHH:mm:ss");
	}

	public static Date getEndDate(Date date) {
		return getDateFromString(getDateString(date, "yyyyMMdd") + "23:59:59", "yyyyMMddHH:mm:ss");
	}

	public static String getTimestampString(Date date) {
		return getDateString(date, "yyyyMMddHHmmssSSS");
	}

	public static int getToday() {
		return Integer.parseInt(getCurrentDateString("dd"));
	}

	public static long getTimeDiff(Date fromDate, Date toDate, int type) {
		fromDate = (fromDate == null) ? new Date() : fromDate;
		toDate = (toDate == null) ? new Date() : toDate;
		long diff = toDate.getTime() - fromDate.getTime();
		BigInteger diffnum=new BigInteger(diff+"");
		BigInteger resultNum = diffnum;
		
		
		 

		switch (type) {
		case DIFF_MILLSECOND:
			break;

		case DIFF_SECOND:
			 
			BigInteger secondnum=new BigInteger("1000");
			resultNum=diffnum.divide(secondnum);
			
			break;

		case DIFF_MINUTE:
			BigInteger minutenum=new BigInteger("60000");
			resultNum=diffnum.divide(minutenum);
			
			break;

		case DIFF_HOUR:
			 
			BigInteger hournum=new BigInteger("36000000");
			resultNum=diffnum.divide(hournum);
			break;

		case DIFF_DAY:
			BigInteger daynum=new BigInteger("86400000");
			resultNum=diffnum.divide(daynum);
			break;

		case DIFF_MONTH:
			
			
			BigInteger monthnum=new BigInteger("2592000000");
			resultNum=diffnum.divide(monthnum);
			break;
		case DIFF_YEAR:
			BigInteger yearnum=new BigInteger("31536000000");
			resultNum=diffnum.divide(yearnum);
			break;

		default:
			diff = 0;
			break;
		}

		return resultNum.longValue();
	}

	public static boolean isTimestampEqual(Date arg0, Date arg1) {
		return getTimestampString(arg0).compareTo(getTimestampString(arg1)) == 0;
	}

	public static Date nDaysAfterNowDate(int n) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.DAY_OF_MONTH, +n);
		return rightNow.getTime();
	}

	public static Date nHoursAfterNowDate(int n) {
		Calendar rightNow = Calendar.getInstance();
		rightNow.add(Calendar.HOUR_OF_DAY, +n);
		return rightNow.getTime();
	}

	public static String nDaysAfterOneDateString(String basicDate, int n) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date tmpDate = null;
		try {
			tmpDate = df.parse(basicDate);
		} catch (Exception e) {
			System.out.println("dateformat:" + e.getMessage());
		}
		long nDay = (tmpDate.getTime() / (24 * 60 * 60 * 1000) + 1 + n) * (24 * 60 * 60 * 1000);
		tmpDate.setTime(nDay);

		return df.format(tmpDate);
	}

	public static Date nDaysAfterOneDate(Date basicDate, int n) {
		long nDay = (basicDate.getTime() / (24 * 60 * 60 * 1000) + n) * (24 * 60 * 60 * 1000);
		// basicDate.setTime(nDay);
		// return basicDate;
		return new Date(nDay);
	}

	public static int nDaysBetweenTwoDate(Date firstDate, Date secondDate) {
		int nDay = (int) ((secondDate.getTime() - firstDate.getTime()) / (24 * 60 * 60 * 1000));
		return nDay;
	}

	public static int nYearsBetweenTwoDate(Date firstDate, Date secondDate) {
		int nYear = nDaysBetweenTwoDate(firstDate, secondDate) / 365 + 1;
		return nYear;
	}

	public static int nDaysBetweenTwoDate(String firstString, String secondString) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date firstDate = null;
		Date secondDate = null;
		try {
			firstDate = df.parse(firstString);
			secondDate = df.parse(secondString);
		} catch (Exception e) {
			System.out.println("dateformat:" + e.getMessage());
		}
		int nDay = (int) ((secondDate.getTime() - firstDate.getTime()) / (24 * 60 * 60 * 1000));
		return nDay;
	}

	public static Date getFirstOfWeekOneDate(Date date) {
		int day = DateUtil.getDayOfWeek(date);
		Date sunDay = DateUtil.getRelativeDate(date, DateUtil.DIFF_DAY, -(day - 1));
		return getDate(sunDay);
	}

	public static int getWeeksOfYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	public static boolean dateIsRule(String date, int dateFormatFlag) {
		String regex = "";
		switch (dateFormatFlag) {
		case DateUtil.DATE_OF_YYYY_MM_DD:
			regex = "[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))";
			break;
		case DateUtil.DATE_OF_YYYY_MM:
			regex = "[0-9]{4}-((0[13578]|(10|12))|(02)|(0[469]|11))";
			break;
		default:
			break;
		}
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}

	public static String getWeek(String dateStr) {
		String dayNames[] = { "����һ","���ڶ�","������","������","������","������","������"};
		SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		try {
			date = sdfInput.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayOfWeek < 0) {
			dayOfWeek = 0;
		}
		return dayNames[dayOfWeek];
	}

	public static Date addDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, n);
		return cal.getTime();
	}

	public static Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

	public static int compareDate(Date v1, Date v2) {
		long v1l = v1.getTime();
		long v2l = v2.getTime();

		if (v1l > v2l) {
			return 1;
		}

		if (v1l < v2l) {
			return -1;
		}

		return 0;
	}

	public static Date currentDate() {
		return new Date(System.currentTimeMillis());
	}
	
	
	public static void main(String[] args) {
		Date startDate = DateUtil.getDateFromString("2017-04-5 12:12", "yyyy-MM-dd HH:mm");
		Date endDate = DateUtil.getDateFromString("2017-05-31 12:12", "yyyy-MM-dd HH:mm");
		long number = DateUtil.getTimeDiff(startDate, endDate, 5);
		System.out.println("=="+number);
		for (int i = 0; i < number; i=i+7) {
			System.out.println("----"+i);
			System.out.println(DateUtil.addDay(startDate, i));
			
		}
		
	}

}
