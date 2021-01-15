package Test.view;

import Test.common.ReadAndWriteFile;
import Test.controller.MainController;
import Test.models.ManageCustomers;
import Test.models.ManageSavingBook;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainController.displayMenu();
        ManageSavingBook.read();
//        ManageSavingBook.addNewSavingBook();
    }
    public static Scanner enter(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }
}
