package com.yyh.practice;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;




public class TimeTest {
	public static void main (String[] args) throws ParseException {
		
		formatDateJdk8();
	}
	
	private static void formatDateJdk8() {
		 // convert String to LocalDate
        LocalDate localDate = LocalDate.parse("2020-06-01");
        // convert LocalDate to String
        String localDateAsDefaultString = localDate.toString();
        System.out.println("LocalDate: " + localDateAsDefaultString + "( year: " + localDate.getYear()
                + ", month: " + localDate.getMonthValue() + ", day: " + localDate.getDayOfMonth() + " )");

        LocalTime localTime = LocalTime.parse("12:23:44");
        // convert LocalTime to String
        String localTimeAsDefaultString = localTime.toString();
        System.out.println("LocalTime: " + localTimeAsDefaultString + "( hour: " + localTime.getHour()
                + ", minute: " + localTime.getMinute() + ", second: " + localTime.getSecond() + " )");

        // convert String to LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.parse("2020-06-01T11:20:15");
        // convert LocalDateTime to String
        String localDateTimeAsDefaultString = localDateTime.toString();
        System.out.println("LocalDateTime: " + localDateTimeAsDefaultString + "( year: " + localDateTime.getYear()
                + ", month: " + localDateTime.getMonthValue() + ", day: " + localDateTime.getDayOfMonth()
                + ", hour: " + localDateTime.getHour() + ", minute: " + localDateTime.getMinute()
                + ", second: " + localDateTime.getSecond() + " )");

        // convert String to OffsetDateTime
        OffsetDateTime offsetDateTime = OffsetDateTime.parse("2007-12-03T10:15:30+01:00");
        // convert OffsetDateTime to String
        String offsetDateTimeAsDefaultString = offsetDateTime.toString();
        System.out.println("OffsetDateTime: " + offsetDateTimeAsDefaultString + "( year: " + offsetDateTime.getYear()
                + ", month: " + offsetDateTime.getMonthValue() + ", day: " + offsetDateTime.getDayOfMonth()
                + ", hour: " + offsetDateTime.getHour() + ", minute: " + offsetDateTime.getMinute()
                + ", second: " + offsetDateTime.getSecond() + ", offset: " + offsetDateTime.getOffset() + " )");

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        // convert String to LocalDate
        LocalDate localDateFormatted = LocalDate.parse("01.06.2020", dateFormatter);
        // convert LocalDate to String              
        String localDateAsFormattedString = dateFormatter.format(localDateFormatted);
        System.out.println("Date: " + localDateAsFormattedString + "( year: " + localDateFormatted.getYear()
                + ", month: " + localDateFormatted.getMonthValue() + ", day: " + localDateFormatted.getDayOfMonth() + " )");

        DateTimeFormatter offsetDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd, HH:mm:ss, XXXXX");
        // convert String to OffsetDateTime
        OffsetDateTime offsetDateTimeFormatted = OffsetDateTime.parse("2007.12.03, 10:15:30, +01:00", offsetDateTimeFormatter);
        // convert OffsetDateTime to String        
        String offsetDateTimeAsFormattedString = offsetDateTimeFormatter.format(offsetDateTimeFormatted);
        System.out.println("OffsetDateTime: " + offsetDateTimeAsFormattedString + "( year: " + offsetDateTimeFormatted.getYear()
                + ", month: " + offsetDateTimeFormatted.getMonthValue() + ", day: " + offsetDateTimeFormatted.getDayOfMonth()
                + ", hour: " + offsetDateTimeFormatted.getHour() + ", minute: " + offsetDateTimeFormatted.getMinute()
                + ", second: " + offsetDateTimeFormatted.getSecond() + ", offset: " + offsetDateTimeFormatted.getOffset() + " )");        
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
