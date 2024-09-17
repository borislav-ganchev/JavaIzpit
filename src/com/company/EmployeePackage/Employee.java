package com.company.EmployeePackage;

import java.io.Serializable;

public abstract class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private double baseSalary = 800;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", baseSalary=" + baseSalary + "]";
    }
}
