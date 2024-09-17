package com.company.EmployeePackage;

import com.company.EmployeePackage.Employee;

public class Manager extends Employee {
    private static final long serialVersionUID = 1L;
    private double bonusPercentage;
    private double updatedSalary;

    public Manager(String name, double bonusPercentage) {
        super(name);
        this.bonusPercentage = bonusPercentage;
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }

    public double getUpdatedSalary() {
        return updatedSalary;
    }

    public void setUpdatedSalary(double updatedSalary) {
        this.updatedSalary = updatedSalary;
    }

    public void setBonusPercentage(double bonusPercentage) {
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    public double calculateSalary() {
        return getUpdatedSalary();
    }

    @Override
    public String toString() {
        return "Manager [bonusPercentage=" + bonusPercentage + ", " + super.toString() + "]";
    }
}