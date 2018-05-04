package com.bizleap.training.assignment.three;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MonthBuilder {

    /**
     * Build Months with Range
     */
    private List<Month> getListWithYearRange(int fromYear, int toYear) {
        List<Month> months = new ArrayList<Month>();
        for (int year = fromYear; year <= toYear; year++) {
            addMonthsToList(months, year);
        }
        return months;
    }

    /**
     * Add months to list by years
     */
    private void addMonthsToList (List<Month> months, int year) {
        months.add(new Month("January", 31, year));
        months.add(new Month("February", isLeapYear(year) ? 29 : 28 , year));
        months.add(new Month("March", 31, year));
        months.add(new Month("April",30, year));
        months.add(new Month("May", 31, year));
        months.add(new Month("June",30, year));
        months.add(new Month("July", 31, year));
        months.add(new Month("August", 31, year));
        months.add(new Month("September", 30, year));
        months.add(new Month("October", 31, year));
        months.add(new Month("November", 30, year));
        months.add(new Month("December", 31, year));
    }

    /**
     * Checking Leap Year or Not
     */
    private boolean isLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }

    /**
     * Checking validation of year
     */
    private boolean isValid(int year) {
        return year>0;
    }

    /**
     * Checking validation of two years
     */
    private boolean isValid(int fromYear, int toYear) {
        return fromYear <= toYear;
    }

    public static void main(String[] args) {
        System.out.println(new MonthBuilder().getListWithYearRange(2000, 2003));
    }

}
