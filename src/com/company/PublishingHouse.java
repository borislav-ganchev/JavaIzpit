package com.company;

import com.company.EmployeePackage.Employee;
import com.company.EmployeePackage.Manager;
import com.company.PaperPackage.Paper;
import com.company.PublicationPackage.Publication;

import java.io.*;
import java.util.*;

public class PublishingHouse implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Employee> employees = new ArrayList<>();
    private List<PrintingMachine> machines = new ArrayList<>();
    private double totalProfit = 0;
    private double profitThreshold;
    private double totalSalaries;
    private double paperExpense = 0;
    private double totalExpense = 0;
    private int discountThreshold;
    private double discountPercentage;


    public PublishingHouse(double profitThreshold, int discountThreshold, double discountPercentage) {
        this.profitThreshold = profitThreshold;
        this.discountThreshold = discountThreshold;
        this.discountPercentage = discountPercentage;
    }

    public void setManagerSalary() {
        for (Employee employee : employees) {
            if (totalProfit > profitThreshold) {
                double baseSalary = employee.getBaseSalary();
                if (employee instanceof Manager) {
                    ((Manager) employee).setUpdatedSalary(baseSalary + (baseSalary * ((Manager) employee).getBonusPercentage() / 100));
                }
            }
            else if (employee instanceof Manager) ((Manager) employee).setUpdatedSalary(employee.getBaseSalary());
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<PrintingMachine> getMachines() {
        return machines;
    }

    public double calculateTotalSalaries() {
         totalSalaries = 0;
        for (Employee employee : employees) {
            System.out.println("Salary of employee " + employee + " is " + employee.calculateSalary());
            totalSalaries += employee.calculateSalary();
        }
        System.out.println("Total salaries are " + totalSalaries);
        return totalSalaries;
    }

    public void printPublication(PrintingMachine machine,int copies, Publication publication, boolean color, Paper paper){
        for(int i=0 ; i<copies; i++) {
            machine.print(publication, color);
            paperExpense += paper.calculatePrice(publication.getPageSize()) * publication.getNumberOfPages();
        }
    }

    public void calculateTotalExpense(){
        totalExpense = totalSalaries + paperExpense;
        System.out.println("Total expenses are " + totalExpense);

    }

    public double calculateTotalProfit(){
        for (PrintingMachine machine : machines){
            for (Map.Entry<Publication, Integer> entry : machine.getPrintedPublications().entrySet()){
                Publication publication = entry.getKey();
                Integer count = entry.getValue();
                if(count > discountThreshold) {
                    totalProfit += (publication.getSellPrice() - (publication.getSellPrice()*discountPercentage/100)) * count;
                }
                else totalProfit += publication.getSellPrice() * count;
            }
        }
        System.out.println("Total profits are " + totalProfit);
        setManagerSalary();
        return  totalProfit;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addMachine(PrintingMachine machine) {machines.add(machine); }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PublishingHouse loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (PublishingHouse) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}