package com.bizleap.training.assignment.three;

public class Month {

    private int dayCount;
    private int year;
    private String name;

    public Month(String name, int dayCount, int year) {
        this.dayCount = dayCount;
        this.year = year;
        this.name = name;
    }

    public int getDayCount() {
        return dayCount;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name + "/" + this.year + "/" + this.dayCount;
    }
}
