package CaseStudy.documents;

import CaseStudy.common.ReadWriteFile;
import CaseStudy.models.Employee;
import CaseStudy.view.Main;

import java.util.Stack;

public class EmployeesFile {
        public static void employeeFile(){
            Boolean check = true;
            System.out.println("Enter Name!");
            String checkEmployee = Main.inputScanner().nextLine();
            Stack<Employee> employeeStacks = ReadWriteFile.readFileEmployeeStack();
            for (Employee employee : employeeStacks){
                if (employeeStacks.isEmpty()){
                    System.out.println("Stack is empty! ");
                    break;
                } else if (checkEmployee.equals(employee.getName())){
                    System.out.println("Had found! ");
                    System.out.println("Name Employee: "+employee.getName() +
                            "\n Address :" + employee.getAddress() +
                            "\n ID :" + employee.getDateOfBirth());
                    check = false;
                    break;
                }
            }
            if (check){
                System.out.println("Name not found!!");
            }
        }
}
