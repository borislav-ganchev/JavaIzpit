package com.company.EmployeePackage;

import com.company.EmployeePackage.Employee;

public class Operator extends Employee {
    private static final long serialVersionUID = 1L;

    public Operator(String name) {
        super(name);
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary();
    }

}