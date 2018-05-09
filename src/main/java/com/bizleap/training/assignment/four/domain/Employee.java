package com.bizleap.training.assignment.four.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Employee extends AbstractEntity {
    private Company worksForCompany;

    public Company getWorksForCompany() {
        return worksForCompany;
    }

    public void setWorksForCompany(Company worksForCompany) {
        this.worksForCompany = worksForCompany;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID='" + super.getBoId() + '\'' +
                ", Name='" + super.getName() + '\'' +
                ", worksForCompany='" + worksForCompany + '\'' +
                '}';
    }
}
