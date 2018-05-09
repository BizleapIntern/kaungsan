package com.bizleap.training.assignment.four.impl;

import com.bizleap.training.assignment.four.AssociationMapper;
import com.bizleap.training.assignment.four.domain.Company;
import com.bizleap.training.assignment.four.domain.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AssociationMapperImpl implements AssociationMapper {

    private List<Employee> employees = new ArrayList<Employee>();
    private List<Company> companies = new ArrayList<Company>();

    // to add Full Company to Employee Object
    @Override
    public void addCompanyToEmployee() {

    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
