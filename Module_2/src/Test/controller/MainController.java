package Test.controller;


import Test.models.ManageCustomers;
import Test.models.ManageSavingBook;
import Test.models.SavingBook;
import Test.view.Main;

public class MainController {
    public static void displayMenu(){
        boolean isExit = true;
        do {
            System.out.println("----------Select function.----------- " +
                    "\n 1. Add new Customer." +
                    "\n 2. Remove Saving-Book." +
                    "\n 3. Display Saving-Book." +
                    "\n 4. Display Customers" +
                    "\n 5. Search Saving-Book." +
                    "\n 6. Exit.");
            switch (Main.enter().nextLine()){
                case "1":{
                    ManageCustomers.addNewCustomer();
//                    ManageSavingBook.addNewSavingBook();
                    break;
                }
                case "2":{
                    ManageSavingBook.remove();
                    break;
                }
                case "3":{
                    ManageSavingBook.display();
                    break;
                }
                case "4":{
                    ManageCustomers.displayCustomer();
                    break;
                }
                case "5":{
                    ManageSavingBook.searchSavingBook();
                    break;
                }
                case "6":{
                    isExit = false;
                    break;
                }
                default:{
                    displayMenu();
                    break;
                }
            }
        } while (isExit);
    }
}
