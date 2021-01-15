package slaray_book;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UtilitiesSavingBook {
    public static String isCheckTimeRent(String startRentDate) {
        Scanner input = new Scanner(System.in);
        String endRentDateL = "";
        boolean checkTime = false;
        while (!checkTime) {
            System.out.println("Enter end rent date: ");
            endRentDateL = RegexToString.regexDate(input.nextLine());
            long millisecondsStart = TimeToMilliseconds.dateToMilliseconds(startRentDate);
            long millisecondsEnd = TimeToMilliseconds.dateToMilliseconds(endRentDateL);
            long millisecondsRentTime = millisecondsEnd - millisecondsStart;
            long rentTime = millisecondsRentTime / (1000 * 60 * 60 * 24);
            if (rentTime > 0) {
                checkTime = true;
            } else {
                System.out.println("The saving end date must not be less than the saving start date");
            }
        }
        return endRentDateL;
    }

    public static boolean regexId(String id) {
        final String regex = "(STK)-[0-9]{4}";
        return Pattern.matches(regex, id);
    }

    public static String checkId() {
        Scanner input = new Scanner(System.in);
        String str = "";
        boolean check = false;
        while (!check) {
            str = input.nextLine();
            if (regexId(str)) {
                check = true;
            } else {
                System.err.println("Data format is false, enter again!");
            }
        }
        return str;
    }
}
