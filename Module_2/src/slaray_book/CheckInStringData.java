package slaray_book;

import java.util.Scanner;

public class CheckInStringData {
    public static String checkString() {
        Scanner input = new Scanner(System.in);
        String str = "";
        boolean check = false;
        while (!check) {
            str = input.nextLine();
            if (RegexToBoolean.regexInputString(str)) {
                check = true;
            } else {
                System.err.println("Data error, enter again!");
            }
        }
        return ToUpCase.upCaseMore(str);
    }
}
