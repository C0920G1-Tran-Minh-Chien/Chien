package _00.Main;

import _00.controller.MainController;
import _00.models.ManageProducts;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManageProducts.read();
        MainController.displayMenu();
    }
    public static Scanner enter(){
        return new Scanner(System.in);
    }
}
