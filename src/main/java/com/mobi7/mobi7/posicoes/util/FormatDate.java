package com.mobi7.mobi7.posicoes.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;



public class FormatDate {

    private static final String LOCALE = "GMT -0200 (BRT)";
    private static final LocalDate currentdate = LocalDate.now();
    private static final LocalTime localTime = LocalTime.now();

    private FormatDate() {}

    public static Date execute(SimpleDateFormat format) throws ParseException {
        Date date = format.parse(FormatDate.dayOfWeek()+" "+FormatDate.month()+" "+FormatDate.day()+" "+FormatDate.year()+" "+FormatDate.hours()+" "+LOCALE);

        return date;
    }

    private static String dayOfWeek() {
        String dayOfWeek = currentdate.getDayOfWeek().toString();
        String first = (""+dayOfWeek.charAt(0)).toString() ;
        String second = (""+dayOfWeek.charAt(1)).toString().toLowerCase();
        String third = (""+dayOfWeek.charAt(2)).toString().toLowerCase();
        String result = first+second+third;

        return result;
    }

    private static String month() {
        String dayOfWeek = currentdate.getMonth().toString();
        String first = (""+dayOfWeek.charAt(0)).toString();
        String second = (""+dayOfWeek.charAt(1)).toString().toLowerCase();
        String third = (""+dayOfWeek.charAt(2)).toString().toLowerCase();
        String result = first+second+third;

        return result;
    }

    private static int day() {
        return  currentdate.getDayOfMonth();
    }

    private static int year() {
        return currentdate.getYear();
    }

    private static String hours() {
        int hours = localTime.getHour();
        int minutes = localTime.getMinute();
        int seconds = localTime.getSecond();
        return hours+":"+minutes+":"+seconds;
    }

}