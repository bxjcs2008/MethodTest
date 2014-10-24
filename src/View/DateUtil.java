package View;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * 日期辅助类
 * 
 * @author zhj
 * @version 1.0
 */
public class DateUtil {
	private static final Logger logger = Logger.getLogger(DateUtil.class
			.getName());

	public static String DATE_FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
	public static String DATE_FORMAT_DATE = "yyyy-MM-dd";
	/** yyyy-MM-dd */
    public static final String yyyy_MM_dd = "yyyy-MM-dd";
    /** HH:mm:ss*/
    public static final String HH_mm_ss = "HH:mm:ss";
    /** HH:mm:ss*/
    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
	
	
    public static Date String2Date(String dateValue,String format){
    	DateFormat dateFormat = new SimpleDateFormat(format);
    	Date date = null;
    	try{
    		date=dateFormat.parse(dateValue);
    	}catch(Exception e){
    		logger.error("--- dateValue: "+dateValue+" ---");
    		logger.error("--- format: "+format+" ---");
    		logger.error("--- Exception in DateUtil.String2Date ---",e);
    	}
    	
    	return date;
    }
    
	/**
	 * 日期时间格式校验
	 * 
	 * @param checkValue
	 *            待校验日期时间
	 * 
	 * @return 校验结果
	 */
	public static boolean DateTimeCheck(String checkValue) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date d = null;

		if ((checkValue != null) && !checkValue.equals("")) {
			if (checkValue.split("-").length > 1) {
				dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}
		} else {
			return false;
		}

		try {
			d = dateFormat.parse(checkValue);
			logger.info(d);
		} catch (ParseException e) {
			logger.info("格式错误");

			return false;
		}

		String eL = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-9]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(checkValue);
		boolean b = m.matches();

		if (b) {
			logger.info("格式正确");

			return true;
		} else {
			logger.info("格式错误");

			return false;
		}
	}

	public static Timestamp Date2Timestamp(String dateValue) {
		Date d = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		if ((dateValue != null) && !dateValue.equals("")) {
			if (dateValue.split("-").length > 1) {
				dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				if (dateValue.split(":").length > 1) {
					dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (dateValue.split(":").length > 1) {
					dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
				}
			}

			try {
				d = dateFormat.parse(dateValue);
				logger.info(d);
				Date date = dateFormat.parse(dateValue);
				Timestamp time = new Timestamp(date.getTime());
				return time;
			} catch (ParseException e) {
				logger.info("格式错误");
			}
		} 
		return null;
	}
	
	public static Timestamp DateTime2Timestamp(String dateString, String timeString) {
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = formatDate.parse(dateString+" "+timeString);
			Timestamp time = new Timestamp(date.getTime());
			return time;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 携程时间格式方法：yyyyMMdd 转 yyyy-MM-dd
	 * @param dateString
	 * @return
	 */
	public static String CtripDateFormat(String dateString) {
		if ((dateString != null) && !dateString.equals("")) {
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				if (dateString.split("-").length > 1) {
					return dateString;
				}else{
					Date d = dateFormat.parse(dateString);
					logger.info(d);
					String str = dateFormat2.format(d);
					logger.info(str);
					return str;
				}
			} catch (ParseException e) {
				logger.info("格式错误");
			}
		}
		return dateString;
	}

	/**
	 * 携程时间格式方法：HHmmss 转 HH:mm:ss
	 * @param timeString
	 * @return
	 */
	public static String CtripTimeFormat(String timeString) {
		if ((timeString != null) && !timeString.equals("")) {
			DateFormat dateFormat = new SimpleDateFormat("HHmmss");
			DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
			
			try {
				Date d = dateFormat.parse(timeString);
				logger.info(d);
				String str = dateFormat2.format(d);
				logger.info(str);
				return str;
			} catch (ParseException e) {
				logger.info("格式错误");
			}
		}
		return timeString;
	}
	
	/**
	 * 携程时间格式方法：yyyy-MM-dd 转 yyyyMMdd
	 * @param dateString
	 * @return
	 */
	public static String CtripDateUnFormat(String dateString) {
		if ((dateString != null) && !dateString.equals("")) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat dateFormat2 = new SimpleDateFormat("yyyyMMdd");
			try {
				Date d = dateFormat.parse(dateString);
				logger.info(d);
				String str = dateFormat2.format(d);
				logger.info(str);
				return str;
			} catch (ParseException e) {
				logger.info("格式错误");
			}
		}
		return dateString;
	}

	/**
	 * 携程时间格式方法：HH:mm:ss 转 HHmmss
	 * @param timeString
	 * @return
	 */
	public static String CtripTimeUnFormat(String timeString) {
		if ((timeString != null) && !timeString.equals("")) {
			DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			DateFormat dateFormat2 = new SimpleDateFormat("HHmmss");
			try {
				Date d = dateFormat.parse(timeString);
				logger.info(d);
				String str = dateFormat2.format(d);
				logger.info(str);
				return str;
			} catch (ParseException e) {
				logger.info("格式错误");
			}
		}
		return timeString;
	}

	/**
	 * 携程时间格式方法：String 转 yyyy-MM-dd
	 * @param dateValue
	 * @return
	 */
	public static Timestamp String2Timestamp(String dateValue) {
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = formatDate.parse(dateValue);
			Timestamp time = new Timestamp(date.getTime());
			return time;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 携程时间格式方法：Date 转 yyyyMMdd
	 * @param date
	 * @return
	 */
	public static String Date2StringDate(Date date) {
		DateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
		String result = formatDate.format(date);
		return result;
	}
	
	/**
	 * 携程时间格式方法：Date 转 HHmmss
	 * @param date
	 * @return
	 */
	public static String Date2StringTime(Date date) {
		DateFormat formatDate = new SimpleDateFormat("HHmmss");
		String result = formatDate.format(date);
		return result;
	}

	/**
	 * 携程时间格式方法：StringDate 转 yyyyMMdd
	 * @param dateValue
	 * @return
	 */
	public static String DateTime2CtripDate(String dateValue) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
		Date d = null;
		String result = dateValue;
		if ((dateValue != null) && !dateValue.equals("")) {
			if (dateValue.split("-").length > 1) {
				dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				if (dateValue.split(":").length > 1) {
					dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (dateValue.split(":").length > 1) {
					dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
				}
			}

			try {
				d = dateFormat.parse(dateValue);
				logger.info(d);
				DateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
				result = formatDate.format(d);
			} catch (ParseException e) {
				logger.info("格式错误");
			}
		} 
		return result;
	}
	
	/**
	 * 携程时间格式方法：StringDate 转 HHmmSS
	 * @param dateValue
	 * @return
	 */
	public static String DateTime2CtripTime(String dateValue) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date d = null;
		String result = dateValue;
		if ((dateValue != null) && !dateValue.equals("")) {
			if (dateValue.split("-").length > 1) {
				dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}
			try {
				d = dateFormat.parse(dateValue);
				logger.info(d);
				DateFormat formatDate = new SimpleDateFormat("HHmmss");
				result = formatDate.format(d);
			} catch (ParseException e) {
				logger.info("格式错误");
			}
		} 
		return result;
	}

	/**
	 * 携程时间格式方法：StringDate 转 yyyyMMdd
	 * @param dateValue
	 * @return java.sql.Date 
	 */
	public static java.sql.Date CtripDate2SqlDate(String dateValue) {
		DateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
		try{ 
	       java.util.Date date = formatDate.parse(dateValue); 
	       java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	       return sqlDate;
		} 
		catch (Exception ex) { 
	     logger.info(ex.getMessage()); 
		}
		return null;
	}
	
	/**
	 * 时间格式方法：StringDate 转 yyyy-MM-dd
	 * @param dateValue
	 * @return java.sql.Date 
	 */
	public static java.sql.Date Date2SqlDate(String dateValue) {
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		try{ 
	       java.util.Date date = formatDate.parse(dateValue); 
	       java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	       return sqlDate;
		} 
		catch (Exception ex) { 
	     logger.info(ex.getMessage()); 
		}
		return null;
	}
	
	public static int calculateDateSpan(Timestamp date1, Timestamp date2) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String s1 = formatter.format(date1); 
		String s2 = formatter.format(date2); 
		
		DateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
		try{ 
	       java.util.Date d1 = formatDate.parse(s1);
	       java.util.Date d2 = formatDate.parse(s2);
	       return new Long((d2.getTime()-d1.getTime())/86400000).intValue();
		} 
		catch (Exception ex) {
			logger.info(ex.getMessage()); 
		}
		return 0;
	}
	
	public static int Date2Integer(Timestamp date,int offset) {
		Timestamp offdaily = new Timestamp(date.getTime()+offset*86400000);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String s1 = formatter.format(offdaily); 
		return Integer.parseInt(s1);
	}
	
	public static void  main(String[] args){
		
		Date n = new Date(System.currentTimeMillis());
		Timestamp time = new Timestamp(n.getTime());
		
//		System.out.println( n );
//		System.out.println( time );
//		System.out.println( time.toString() );
		
		
		System.out.println(calculateDateSpan(String2Timestamp("2012-02-26"),String2Timestamp("2012-03-01")));
		
		Timestamp date1 = DateTime2Timestamp("2012-02-26","23:29:45");
		Timestamp date2 = DateTime2Timestamp("2012-03-01","23:29:44");
		
		
		System.out.println(Date2Integer(String2Timestamp("2013-02-26"),0));
		System.out.println(Date2Integer(String2Timestamp("2013-02-26"),1));
		System.out.println(Date2Integer(String2Timestamp("2013-02-26"),4));
		
		int f = calculateDateSpan(date1,date2);
		System.out.println(f);
/*
		DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		String result = formatDate.format(time);
		System.out.println( result );
		
		DateFormat formatDate2 = new SimpleDateFormat("HH:mm:ss");
		result = formatDate2.format(time);
		
		System.out.println( result );
		
		System.out.println(DateTime2Timestamp("2012-03-01","11:29:45"));
		*/
	}
	
	 public static String getCurrentDateTimeByCustomPattern(String pattern)
	    {
	        return (new SimpleDateFormat(pattern)).format(new Date());
	    }

	 public static String getDateByDefaultPattern(Date date) {
	        return (new SimpleDateFormat("yyyy-MM-dd")).format(date);
	    }

//	  public static String getTimesByDefaultPattern(Date date) {
//	        return (new SimpleDateFormat("HH:mm:ss")).format(date);
//	    }

	 /**
	  * 根据sFmt格式,Date转String
	  */
	 public static String toString(Date date, String sFmt) {
		 if (date == null) {
			 return "";
		 }
		 try {
			 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(sFmt);
			 String sDate = simpleDateFormat.format(date);
			 return sDate;
		 } catch (Exception e) {
			 e.printStackTrace();
			 return null;
		 }
	}
	 
	 public static long diffMinutes(Date date, Date date1) {
		 if (date == null || date1 ==null) {
			 return 0;
		 }
		 try {
				long l = date.getTime() - date1.getTime();
				return (l / (60 * 1000));
		 } catch (Exception e) {
			 e.printStackTrace();
			 return 0;
		 }
	}
	
	 public static String getDateForPreMinutes(int i) {
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 java.util.Calendar Cal=java.util.Calendar.getInstance();    
		 Cal.setTime(new Date());    
		 Cal.add(java.util.Calendar.MINUTE,i);    
		 return simpleDateFormat.format(Cal.getTime()); 
	}
  
}
