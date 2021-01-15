package _19_solid_ooad.models;

import CaseStudy.view.Main;

public class Validate {
    public static String regexStr(String temp, String regex){
        boolean check = true;
        do {
            if (temp.matches(regex)){
                check = false;
            } else {
                System.out.println("Nhập lại");
                temp = Main.inputScanner().nextLine();
            }
        } while (check);
        return temp;
    }
}
