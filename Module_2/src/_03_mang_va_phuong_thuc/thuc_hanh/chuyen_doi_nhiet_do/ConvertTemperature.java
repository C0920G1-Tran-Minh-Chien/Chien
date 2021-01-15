package _03_mang_va_phuong_thuc.thuc_hanh.chuyen_doi_nhiet_do;

import java.util.Scanner;

public class ConvertTemperature {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double fahrenheit;
        double celsius;
        int choice;

        do {
            System.out.println("Menu.");
            System.out.println("1. CHuyển từ độ F sang độ C");
            System.out.println("2. Chuyển từ độ C sang độ F");
            System.out.println("0. Exit");
            System.out.println("Chọn : ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Nhập độ F: ");
                    fahrenheit = input.nextDouble();
                    System.out.println("F sang C: " + fahrenheitToCelsius(fahrenheit));
                    break;
                case 2:
                    System.out.println("Nhập độ C: ");
                    celsius = input.nextDouble();
                    System.out.println("C sang F: " + celsiusToFahrenheit(celsius));
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice != 0);
    }
    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (9.0 / 5) * celsius + 32;
        return fahrenheit;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (5.0 / 9) * (fahrenheit - 32);
        return celsius;
    }
}
