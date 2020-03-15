package com.yyh.practice;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;




public class TimeTest {
	public static void main (String[] args) throws ParseException {
		formatDateStr();
	}
	
	private static void formatDateStr() throws ParseException {
		String dateString = "2016-02-03 00:00:00.0";
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(dateString);
		String formattedDate = new SimpleDateFormat("yyyyMMdd").format(date);
		System.out.println(formattedDate);
		
		Timestamp timestamp = new Timestamp(new SimpleDateFormat("yyyyMMdd").parse(formattedDate).getTime());
		System.out.println(timestamp);

	}
	
	private static void formatDateIsBefore() throws ParseException {
		String dtPass = "03/06/2020 12:30:15";
		if(StringUtils.isNotEmpty(dtPass)) {
			DateFormat dtFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");					
			//Check whether current date is after login fail date + 1 day 
			Calendar calFailDtOneDayLater = Calendar.getInstance();
			try {
				calFailDtOneDayLater.setTime(dtFormat.parse(dtPass));
				//one hour later
				//calSixtyMinLater.add(Calendar.HOUR, 1);
				//One day later from fail login date
				calFailDtOneDayLater.add(Calendar.DATE, 1); 
				Date currentDt = new Date();	
				if(currentDt.before(calFailDtOneDayLater.getTime())) {
					System.out.println("Happen before");
				}else {
					System.out.println("Happen after");
				}
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	private static void getCurrentDate() {
		//String sCurrentDate = DateTime.getFormatString("yyyyMMddHHmmss"); 
	}
}
