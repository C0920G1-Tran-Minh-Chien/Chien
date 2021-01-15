package _02_vong_lap_java.bai_tap.hien_thi_hinh;

import java.util.Scanner;

public class Display {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = -1;
        while ( choice != 0 ) {
            System.out.println("Menu"   );
            System.out.println("1. Draw the square");
            System.out.println("2. Draw the rectangle");
            System.out.println("3. Draw the rectangle");
            System.out.println("4. Draw the isosceles rectangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
//                Hình chữ nhật
                case 1: {
                    for (int i = 0; i < 5 ; i++){
                        for (int j = 0; j < 5 ; j++){
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                }
//                Tam giác góc dưới
                case 2: {
                    for (int a = 0; a < 6 ; a++){
                        for (int b = 1; b < a ; b++){
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                }
//                Tam giác góc trên
                case 3: {
                    for (int m = 6; m > 0; m--){
                        for (int n = 0 ; n < m ; n++){
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;
                }
//                Tâm giác cân
                case 4: {
                    for (int r = 1; r <= 6; r++) {
                        for (int h = 6 - r; h > 0; h--) {
                            System.out.print(" ");
                        }
                        for (int c = 1; c <= r; c++) {
                            System.out.print("*");
                        }
                        for (int k = 2; k <= r; k++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                }
            }
        }
    }
}
