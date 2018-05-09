package com.bizleap.training.assignment.four.impl;

import com.bizleap.training.assignment.four.Loader;
import com.bizleap.training.assignment.four.domain.Company;
import com.bizleap.training.assignment.four.domain.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoaderImpl implements Loader {
    private static final String EMPLOYEEFILENAME = "/Users/kaung/Documents/kaungsan/src/com/bizleap/training/assignment/four/data/employee.txt";
    private static final String COMPANYFILENAME = "/Users/kaung/Documents/kaungsan/src/com/bizleap/training/assignment/four/data/company.txt";

    private Employee getEmployee(String line) {
        String pointer[] = line.split(";");
        Employee employee = new Employee();
        employee.setBoId(pointer[0]);
        employee.setName(pointer[1]);
        employee.setWorksForCompany(new Company(pointer[2]));

        return employee;
    }

    private Company getCompany(String line) {
        String pointer[] = line.split(";");
        Company company = new Company();
        company.setBoId(pointer[0]);
        company.setName(pointer[1]);

        return company;
    }

    @Override
    public List<Employee> readEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(EMPLOYEEFILENAME))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                employees.add(getEmployee(currentLine));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;
    }

    @Override
    public List<Company> readCompanies() {
        List<Company> companies = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(COMPANYFILENAME))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                companies.add(getCompany(currentLine));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return companies;
    }


    public static void main(String[] args) {
        System.out.println(new LoaderImpl().readEmployees());
    }

}
