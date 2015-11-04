package com.test.news.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateChange {
	  public static String getFormatedDateTime(String pattern, String dateTime) {
	        SimpleDateFormat sDateFormat = new SimpleDateFormat(pattern);
	        return sDateFormat.format(new Date(Long.valueOf(dateTime) + 0));
	    }
}
