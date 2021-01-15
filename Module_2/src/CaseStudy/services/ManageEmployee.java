package CaseStudy.services;

import CaseStudy.common.ReadWriteFile;
import CaseStudy.controller.MainController;
import CaseStudy.documents.EmployeesFile;
import CaseStudy.models.Employee;
import CaseStudy.view.Main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ManageEmployee extends Employee {
    public static void showInformationOfEmployee() {

        Map<Integer, Employee> employeeMaps = ReadWriteFile.readFileEmployee();
        for (Map.Entry<Integer, Employee> employees : employeeMaps.entrySet()) {
            System.out.println(employees.toString());
        }
        Set<Integer> keys = employeeMaps.keySet();
        boolean check1 = true;
        Integer number = null;
        do {
            System.out.println("Select function: " +
                    "\n1. Search employees name by ID" +
                    "\n2. Search employees name by Name"+
                    "\n3. Back to menu.");
            String choose = Main.inputScanner().nextLine();
            switch (choose) {
                case "1": {
                    System.out.println("Enter ID: ");
                    number = Main.inputScanner().nextInt();
                    for (Integer i : keys) {
                        if (employeeMaps.isEmpty()){
                            System.out.println("Map is Empty!");
                        } else if (i == number) {
                            check1 = false;
                        }
                    }
                    if (check1){
                        System.out.println("ID not found!");
                    }
                    break;
                }
                case "2": {
                    EmployeesFile.employeeFile();
                    MainController.showMenu();
                    break;
                }
                case "3":{
                    MainController.showMenu();
                    break;
                }
            }
        }
        while (check1) ;
        Employee employee = employeeMaps.get(number);
        System.out.println(employee.toString());
    }
}