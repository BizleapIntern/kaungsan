package com.bizleap.training.assignment.four;

import com.bizleap.training.assignment.four.domain.Company;
import com.bizleap.training.assignment.four.domain.Employee;

import java.util.List;

public interface Loader {
    public List<Employee> readEmployees();
    public List<Company> readCompanies();
}
