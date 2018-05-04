package com.bizleap.training.assignment.three;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonthsBuilder {

    /**
     * Get Month Map for a single year
     */
    public Map<Integer, Object> getMonthMap(int year) {
        return getMonthMap(year, year);
    }

    /**
     * Get Month Map within a range of years
     */
    public Map<Integer, Object> getMonthMap(int fromYear, int toYear) {
        Map<Integer, Object> monthMap = new HashMap<Integer, Object>();
        if (isValid(fromYear) && isValid(toYear) && isValid(fromYear, toYear)) {
            addMonthListToMap(monthMap, getListWithYearRange(fromYear, toYear));
        } else {
            monthMap.put(0, "Input is not valid");
        }
        if (!isValid(fromYear, toYear)) {
            monthMap.put(1, "From Year is greater than To Year");
        }
        return monthMap;
    }

    /**
     * Adding List To Map based on day count of months
     */
    private void addMonthListToMap(Map<Integer, Object> monthMap, List<Month> months) {
        for (Month month: months) {
            List monthsBasedOnDayCount = (List) monthMap.get(month.getDayCount());
            if (monthsBasedOnDayCount == null) {
                monthsBasedOnDayCount = new ArrayList<Month>();
                monthMap.put(month.getDayCount(), monthsBasedOnDayCount);
            }
            monthsBasedOnDayCount.add(month);
        }
    }

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
     * Add months to list with years
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

    /**
     * 1. print day count
     * 2. print year
     * 3. print related months
     */
    public void prettyPrint(Map<Integer, Object> mapToPrint) {

        for (int key: mapToPrint.keySet()) {
             Map<Integer, Object> yearMap = new HashMap<Integer, Object>();
            printHeader(key);
            addYearsToMap(yearMap, (List) mapToPrint.get(key));
            for (int yearKey: yearMap.keySet()){
                printMapBasedOnYear(yearKey, yearMap);
            }
            printLines("=", 36);
            System.out.println();
        }
    }

    /*
     * Print Map based on Year
     */
    private void printMapBasedOnYear(int key, Map<Integer, Object> mapToPrint) {
        System.out.print(getCellWithSpace(""));
        System.out.print(getCellWithSpace(key + ""));
        System.out.print(getCellWithSpace(""));
        System.out.println();

        for (Month month: (List<Month>) mapToPrint.get(key)){
            System.out.print(getCellWithSpace(""));
            System.out.print(getCellWithSpace(""));
            System.out.print(getCellWithSpace(month.getName()));
            System.out.println();
        }
    }

    /*
     * Adding Months to Map based on Year
     */
    private void addYearsToMap(Map<Integer, Object> monthMap, List<Month> months){
        for (Month month: months) {
            List monthsBasedOnYear = (List) monthMap.get(month.getYear());
            if (monthsBasedOnYear == null) {
                monthsBasedOnYear = new ArrayList<Month>();
                monthMap.put(month.getYear(), monthsBasedOnYear);
            }
            monthsBasedOnYear.add(month);
        }
    }

    /**
     * Generating Cell including spaces based on names
     */
    private String getCellWithSpace(String name) {
        name = "|" + name;
        for (int i = name.length(); i <= 10; i++) {
            name += " ";
        }
        return name + "|";
    }

    /*
     * Print Header
     */
    private void printHeader(int dayCount) {
        printLines("=", 36);
        System.out.print(getCellWithSpace("Day"));
        System.out.print(getCellWithSpace("Year"));
        System.out.print(getCellWithSpace("Months"));
        System.out.println();
        printLines("-", 36);
        System.out.print(getCellWithSpace(dayCount+""));
        System.out.print(getCellWithSpace(""));
        System.out.print(getCellWithSpace(""));
        System.out.println();
    }

    /*
     * print lines based on input and count
     */
    private void printLines(String prefix, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(prefix);
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        System.out.println(new MonthsBuilder().getMonthMap(2000));
        MonthsBuilder monthsBuilder = new MonthsBuilder();
        monthsBuilder.prettyPrint(monthsBuilder.getMonthMap(2000, 2010));
    }
}
