package com.golden.ihome.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**long 转 string ---测试通过*/
    public static String getStrByLong(Long longDate,String patten){
    	Date date = getDateByLong(longDate);
        return getStringByDate(date,patten);
    }
    /**long 转 date ---测试通过*/
    public static Date getDateByLong (Long longDate){
    	Calendar ca = Calendar.getInstance();
    	ca.setTimeInMillis(longDate);
    	
		return ca.getTime();
    	
    }
    /**date 转 long --测试通过*/
    public static Long getLongByDate(Date date){
		Calendar calendar = Calendar.getInstance();//日历对象
		calendar.setTime(date);//设置当前日期
		return calendar.getTimeInMillis();
	}
    /**string 转 long --测试通过*/
    public static Long getDateOfLong(String dateStr, String patten) {
    	try{
    		return getDate(dateStr, patten).getTime();
    	}catch(Exception e){
    		return null;
    	}
    }
    
    /**
     * 将字符日期型数据按照指定的格式解析成日期对象
     * --测试通过
     */
    public static Date getDate(String dateStr, String patten) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat(patten);
        return formatter.parse(dateStr);
    }
    /**
     * date 转 str ---测试通过
     */
    public static String getStringByDate(Date date,String patten){
    	SimpleDateFormat formatter = new SimpleDateFormat(patten);
    	return formatter.format(date);
    }
    /**
     * Convert a date object to String with specified format. See API document
     * of java.text.SimpleDateFormat for detail description of format pattern.
     * Return empty string if parameter date is null.
     * 
     * @param _date
     * @param patternString
     * @return String
     */
    public static String getDateString(Date _date, String patternString) {
        String dateString = "";
        if (_date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat(patternString);
            dateString = formatter.format(_date);
        }
        return dateString;
    }

}
