package _00.controller;

import _00.Main.Main;
import _00.models.ManageProducts;

public class MainController {

    public static void displayMenu(){

        boolean isExit = true;
        ManageProducts manageProducts = new ManageProducts();
        do {
            System.out.println("----------Select function.----------- " +
                    "\n 1. Add new Products." +
                    "\n 2. Remove Products." +
                    "\n 3. Display Products." +
                    "\n 4. Search Products." +
                    "\n 5. Exit.");
            switch (Main.enter().nextLine()){
                case "1":{
                    manageProducts.addNewProducts();
                    break;
                }
                case "2":{
                    manageProducts.removeProducts();
                    break;
                }
                case "3":{
                    manageProducts.displayProducts();
                    break;
                }
                case "4":{
                    manageProducts.searchProducts();
                    break;
                }
                case "5":
                    isExit = false;
                    break;
                case "6":{
                    manageProducts.edit();
                    break;
                }
                default:
                    displayMenu();
            }
        } while (isExit);
    }
}
