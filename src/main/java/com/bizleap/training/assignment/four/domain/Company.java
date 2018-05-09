package com.bizleap.training.assignment.four.domain;

public class Company extends AbstractEntity{
    public Company() {

    }

    public Company(String boId) {
        super.setBoId(boId);
    }
    @Override
    public String toString() {
        return "Company{" +
                "ID='" + super.getBoId() + '\'' +
                ", Name='" + super.getName() + '\'' +
                "}";
    }
}
