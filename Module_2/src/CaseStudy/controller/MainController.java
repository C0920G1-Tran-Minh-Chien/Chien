package CaseStudy.controller;

import CaseStudy.services.ManageCustomers;
import CaseStudy.services.ManageEmployee;
import CaseStudy.services.ManageServices;

import java.util.Scanner;

public class MainController {
    public static Scanner input = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("Select Function");
        System.out.println("1. Add New Customer");
        System.out.println("2. Show Information Of Customer");
        System.out.println("3. Show Information Of Employee");
        System.out.println("4. Add New Service");
        System.out.println("5. Show Information Services");
        System.out.println("6. Exit");
        System.out.println("--------------------------------------------------");
        String choose ;
        boolean isExit = false;
        ManageCustomers customerManager = new ManageCustomers();
        while (true) {
            choose = input.nextLine();
            switch (choose) {
                case "1":
                    customerManager.addNewCustomer();
                    break;
                case "2":
                    customerManager.showInformationOfCustomer();
                    break;
                case "5":
                    showServices();
                    break;
                case "3":
                    ManageEmployee.showInformationOfEmployee();
                    break;
                case "4" :
                    addNewServices();
                    break;
                case "6":
                    System.out.println("existed !");
                    isExit = true;
                    break;
                default:
                    System.out.println("please select again");
            }
            if (isExit) {
                break;
            }
            showMenu();
        }
    }
    public static void addNewServices() {
        ManageServices servicesManager = new ManageServices();
        System.out.println("1. Add New Villa");
        System.out.println("2. Add New House");
        System.out.println("3. Add New Room");
        System.out.println("4. Back To Menu");
        System.out.println("5. Exit");
        System.out.println("----------------------------------------------------");

        boolean isExist = false;
        while (true) {
            String choiceServices = input.nextLine();
            switch (choiceServices) {
                case "1":
                    servicesManager.addNewVilla();
                    break;
                case "2":
                    servicesManager.addNewHouse();
                    break;
                case "3":
                    servicesManager.addNewRoom();
                    break;
                case "4":
                    showMenu();
                    break;
                case "5":
                    System.out.println("existed !");
                    isExist = true;
                    break;
                default:
                    System.out.println("please select again");
            }if (isExist){
                break;
            }
        }
    }

    public static void showServices() {
        ManageServices servicesManager = new ManageServices();
        System.out.println("1. Show all Villa");
        System.out.println("2. Show all House");
        System.out.println("3. Show all Room");
        System.out.println("4. Show All Name Villa Not Duplicate");
        System.out.println("5. Show All Name House Not Duplicate");
        System.out.println("6. Show All Name Room Not Duplicate");
        System.out.println("7. Back to menu");
        System.out.println("8. Exit");
        System.out.println("---------------------------------------------------");
        boolean isExist = false;
        do {
            String choiceShowServices = input.nextLine();
            switch (choiceShowServices) {
                case "1":
                    servicesManager.showAllVilla();
                    showServices();
                    break;
                case "2":
                    servicesManager.showAllHouse();
                    showServices();
                    break;
                case "3":
                    servicesManager.showAllRoom();
                    showServices();
                    break;
                case "4":
                    servicesManager.showAllNameVillaNotDuplicate();
                    showServices();
                    break;
                case "5" :
                    servicesManager.showAllNameHouseNotDuplicate();
                    showServices();
                    break;
                case "6" :
                    servicesManager.showAllNameRoomNotDuplicate();
                    showServices();
                    break;
                case "7":
                    showMenu();
                    break;
                case "8":
                    System.out.println("existed !");
                    isExist = true;
                    break;
                default:
                    System.out.println("Please enter again!");
            }
        } while (!isExist);
            System.out.println("------------------------------------------");
            showServices();
        }
    }

