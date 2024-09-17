package com.company;

import com.company.EmployeePackage.Manager;
import com.company.EmployeePackage.Operator;
import com.company.PaperPackage.PageSize;
import com.company.PaperPackage.Paper;
import com.company.PaperPackage.PaperType;
import com.company.PublicationPackage.Book;
import com.company.PublicationPackage.Newspaper;
import com.company.PublicationPackage.Poster;
import com.company.PublicationPackage.Publication;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Paper normalPaper = new Paper(PaperType.NORMAL, 6,0.20);
        Paper glossPaper = new Paper(PaperType.GLOSSY, 6,0.50);
        Paper newspaperPaper = new Paper(PaperType.NEWSPAPER, 6,0.10);

        Book book1 = new Book("harry poter",150, PageSize.A3, 60, "avtor1");
        Poster poster1 = new Poster("plakat", 2, PageSize.A1, 15, "artist1");
        Newspaper newspaper1 = new Newspaper("vestnik", 25, PageSize.A2, 8, "editor1");

       // List<PublishingHouse> list1 = new ArrayList<>();
        PublishingHouse house1 = new PublishingHouse(20,40,10);
       // list1.add(house1);

        PrintingMachine machine1 = new PrintingMachine(false, true, 60);
        PrintingMachine machine2 = new PrintingMachine(true, false, 50);
        PrintingMachine machine3 = new PrintingMachine(false, true, 40);
        machine1.loadPaper(8000);
        machine2.loadPaper(8000);
        machine3.loadPaper(8000);

        Operator operator1 = new Operator("operator1");
        Manager manager1 = new Manager("manager1",10);

        house1.addEmployee(manager1);
        house1.addMachine(machine1);
        house1.addMachine(machine2);
        house1.addMachine(machine3);
        house1.addEmployee(operator1);
        house1.printPublication(machine1,50,book1,false,newspaperPaper);
        house1.printPublication(machine2, 30 ,newspaper1, true , normalPaper);
        System.out.println("total pages printed by "+ machine1 + " are " + machine1.getTotalPagesPrinted());
        System.out.println("total pages printed by" + machine2 + "are " + machine2.getTotalPagesPrinted());

        house1.calculateTotalProfit();
        house1.calculateTotalSalaries();
        house1.calculateTotalExpense();

        //house1.saveToFile("izpit.txt");
        //PublishingHouse house2 = PublishingHouse.loadFromFile("izpit.txt");

    }
}